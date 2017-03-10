package com.ailk.toptea.itsm.extra.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ailk.toptea.itsm.extra.enty.ComplainOrder;
import com.ailk.toptea.itsm.extra.until.DBuntil;

public class ComplainManager {
	 private static ComplainManager instance = new ComplainManager();  
	    private ComplainManager (){}  ;
	    public static ComplainManager getInstance() {  
	    return instance;  
	 }
	    
	    
	    public void getDailyTask(String dbip,int dbport,String dbtable,String dbusername,String dbpassword,String dbwritepath,
				String uploadip,String uploadusername,String uploadpassword,String uploadpath){
	    	
	    	Calendar   cal   =   Calendar.getInstance();
			cal.add(Calendar.DATE,   -1);
			String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			System.out.println(yesterday);
			
			String prefilename =yesterday;
			String dbwritefilename = "ComplainTask"+prefilename +".xml";
						
			String uploadfilename= dbwritefilename;
			
		//	String date = yesterday;
			String date = "2016-07-01";
		
			try{
				
			String sql1 =  "select * from task_shengao t WHERE to_char(t.create_date,'yyyy-mm-dd')='"+date+"' or to_char(t.modify_date,'yyyy-MM-dd')='"+date+"'";
			List list = instance.getComplainOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
			
			instance.ComplainOrderToXml(list, dbwritepath, dbwritefilename);
			
			uploadXml upxml = new uploadXml();
			FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
			
			
			boolean flag = upxml.uploadFile(uploadip,uploadusername,uploadpassword,uploadpath,uploadfilename, inputfile);
			System.out.println(flag);
			
			}catch(Exception e){
				e.printStackTrace();
			}
	    	
	    }
	    
		
		// 程序入口 启动程序
		public  void getMonthTasks() {
			// 连接的数据库服务器 url 
			String dbip = "10.32.145.71";
			// 端口号 
			int dbport = 1521;
			// 数据库
			String dbtable= "orcl";
			// 用户名
			String dbusername="usmp";
			String dbpassword = "usmp";
			// 执行的sql 
			String dbsql = "";
			
			//数据库数据写入的位置
			String dbwritepath="E:/codingResource/DBxml/complainTask/";
			// 写入文件名
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String prefilename =sdf.format(new Date());
			String dbwritefilename = prefilename +".xml";
			
			
			String uploadip = "10.32.145.71";
			String uploadusername = "toptea";
			String uploadpassword = "toptea123";
			String uploadpath = "/toptea/template";
			String uploadfilename= "";
			
			
			
			
			
			String date = "";
			StringBuffer sbf  = new StringBuffer();
			for(int j=2;j<4;j++){		
				if(j==2){
					for(int i = 1;i<29;i++){
				
				//		sbf.append("2017-02-");
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
						String sql1 = "select * from task_shengao t WHERE to_char(t.create_date,'yyyy-mm-dd')='"+date+"' or to_char(t.modify_date,'yyyy-MM-dd')='"+date+"'";
						List list = instance.getComplainOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
						dbwritefilename = "complainTask"+date +".xml";
						instance.ComplainOrderToXml(list, dbwritepath, dbwritefilename);
						
						uploadXml upxml = new uploadXml();
						FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
						uploadfilename = dbwritefilename;
						
						boolean flag = upxml.uploadFile(uploadip,uploadusername,uploadpassword,uploadpath,uploadfilename, inputfile);
						System.out.println(flag);
						
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}else{
					for(int i = 1;i<16;i++){
					
				//		sbf.append("2017-03-");
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
						String sql1 = "select * from task_shengao t WHERE to_char(t.create_date,'yyyy-mm-dd')='"+date+"' or to_char(t.modify_date,'yyyy-MM-dd')='"+date+"'";
						List list = instance.getComplainOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
						dbwritefilename = "complainTask"+date +".xml";
						instance.ComplainOrderToXml(list, dbwritepath, dbwritefilename);
						
						uploadXml upxml = new uploadXml();
						FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
						uploadfilename = dbwritefilename;
						
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
		
		public void ComplainOrderToXml(List list,String localpath,String filename){
			xmlService xs=new xmlService();
			xs.complainOrderWriteXml(list, localpath, filename);
		}
		
		


		public List<ComplainOrder> getComplainOrders(String ip,int port,String username,String password,String dbname,String sql){
			
			DBuntil dbu= new DBuntil();
			return dbu.getComplainTasks(ip, port, dbname, username, password, sql);
		}
		
	
}
