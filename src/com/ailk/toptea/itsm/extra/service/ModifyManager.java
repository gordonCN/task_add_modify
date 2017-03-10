package com.ailk.toptea.itsm.extra.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ailk.toptea.itsm.extra.enty.ModifyOrder;
import com.ailk.toptea.itsm.extra.until.DBuntil;

public class ModifyManager {
	 private static ModifyManager instance = new ModifyManager();  
	    private ModifyManager (){}  ;
	    public static ModifyManager getInstance() {  
	    return instance;  
	 }
	    
		
		
		public  void getDailyTask(String dbip,int dbport,String dbtable,String dbusername,String dbpassword,String dbwritepath,
				String uploadip,String uploadusername,String uploadpassword,String uploadpath) {
		
			Calendar   cal   =   Calendar.getInstance();
			cal.add(Calendar.DATE,   -1);
			String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			System.out.println(yesterday);
			
			String prefilename =yesterday;
			String dbwritefilename = "ModifyTask"+prefilename +".xml";
						
			String uploadfilename= dbwritefilename;
			
		//	String date = yesterday;
			String date = "2014-07-16";
		
			try{
				// select *  from vw_itsm_changes t where to_char(t.regtime,'yyyymmdd')='20070608'
			String sql1 = "select * from vw_itsm_changes  t WHERE to_char(t.regtime,'yyyy-mm-dd')='"+date+"' or to_char(t.updatetime,'yyyy-MM-dd')='"+date+"'";
			List list = instance.getModifyOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
			
			instance.ModifyOrderToXml(list, dbwritepath, dbwritefilename);
			
			uploadXml upxml = new uploadXml();
			FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
			
			
			boolean flag = upxml.uploadFile(uploadip,uploadusername,uploadpassword,uploadpath,uploadfilename, inputfile);
			System.out.println(flag);
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void getMonthTask(){
		// 连接的数据库服务器 url 
			String dbip = "10.32.145.70";
			// 端口号 
			int dbport = 1521;
			// 数据库
			String dbtable= "bomctest";
			// 用户名
			String dbusername="uovsd";
			String dbpassword = "manager";
			// 执行的sql 
			String dbsql = "";
			
			//数据库数据写入的位置
			String dbwritepath="E:/codingResource/DBxml/ModifyTask/";
		
			String uploadip = "10.32.145.71";
			String uploadusername = "toptea";
			String uploadpassword = "toptea123";
			String uploadpath = "/toptea/template";
			String uploadfilename= "";
		
			// 写入文件名
			
			
			
			String dbwritefilename = "";
			String date = "";

			StringBuffer sbf  = new StringBuffer();
			for(int j=2;j<4;j++){
				if(j==2){
					for(int i = 1;i<29;i++){
					// 	int i = 3;
					// sbf.append("2017-02-");
						sbf.append("2016-02-");
						if(i <10 ){
							sbf.append("0");
							sbf.append(i);
						}else{
							sbf.append(i);
						}
					
						date = sbf.toString();
						int leng = sbf.length();
						sbf.delete(0, leng);
						 		
					// 获取数据库数据
						try{
							// select *  from vw_itsm_changes t where to_char(t.regtime,'yyyymmdd')='20070608'
							
						String sql1 = "select * from vw_itsm_changes  t WHERE to_char(t.regtime,'yyyy-mm-dd')='"+date+"' or to_char(t.updatetime,'yyyy-MM-dd')='"+date+"'";
						List list = instance.getModifyOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
						dbwritefilename = "ModifyTask"+date +".xml";
						instance.ModifyOrderToXml(list, dbwritepath, dbwritefilename);
						
						uploadXml upxml = new uploadXml();
						FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
						
						
						boolean flag = upxml.uploadFile(uploadip,uploadusername,uploadpassword,uploadpath,uploadfilename, inputfile);
						System.out.println(flag);
						
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}else{
					for(int i = 1;i<16;i++){
						// 	int i = 3;
						// sbf.append("2017-03-");
							sbf.append("2016-03-");
							if(i <10 ){
								sbf.append("0");
								sbf.append(i);
							}else{
								sbf.append(i);
							}
						
							date = sbf.toString();
							int leng = sbf.length();
							sbf.delete(0, leng);
							 		
						// 获取数据库数据
							try{
								// select *  from vw_itsm_changes t where to_char(t.regtime,'yyyymmdd')='20070608'
								
							String sql1 = "select * from vw_itsm_changes  t WHERE to_char(t.regtime,'yyyy-mm-dd')='"+date+"' or to_char(t.updatetime,'yyyy-MM-dd')='"+date+"'";
							List list = instance.getModifyOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
							dbwritefilename = "ModifyTask"+date +".xml";
							instance.ModifyOrderToXml(list, dbwritepath, dbwritefilename);
							
							uploadXml upxml = new uploadXml();
							FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
							
							
							boolean flag = upxml.uploadFile(uploadip,uploadusername,uploadpassword,uploadpath,uploadfilename, inputfile);
							System.out.println(flag);
							
							}catch(Exception e){
								e.printStackTrace();
							}
						}
				}
			}
			
		}
		
		//写入xml
		
		public void ModifyOrderToXml(List list,String localpath,String filename){
			xmlService xs=new xmlService();
			xs.modifyOrderWriteXml(list, localpath, filename);
		}
		
		


		public List<ModifyOrder> getModifyOrders(String ip,int port,String username,String password,String dbname,String sql){
			
			DBuntil dbu= new DBuntil();
			return dbu.getModifyTasks(ip, port, dbname, username, password, sql);
		}
		
	    
}
