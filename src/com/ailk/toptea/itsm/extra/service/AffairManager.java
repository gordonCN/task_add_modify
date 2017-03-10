package com.ailk.toptea.itsm.extra.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;



import com.ailk.toptea.itsm.extra.enty.AffairOrder;
import com.ailk.toptea.itsm.extra.until.DBuntil;



public class AffairManager {
	  private static AffairManager instance = new AffairManager();  
	    private AffairManager (){}  ;
	    public static AffairManager getInstance() {  
	    return instance;  
	    }  
	
	public static void main(String[] args) {
	// 	instance.getAffairDailyTask();
	}
	
	public void getAffairDailyTask(String dbip,int dbport,String dbtable,String dbusername,String dbpassword,String dbwritepath,
	String uploadip,String uploadusername,String uploadpassword,String uploadpath){ 
	
	
			
			// ��ȡ����
			Calendar   cal   =   Calendar.getInstance();
			cal.add(Calendar.DATE,   -1);
			String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			System.out.println(yesterday);
			
			
	 		String date = "2016-02-01";
	//		String date = yesterday;
			
			//�ļ���
			String prefilename = yesterday; 
			String dbwritefilename = "AffairTask"+prefilename +".xml";
			
			String uploadfilename= dbwritefilename;
			
			
			//��ȡǰһ�յ� ������Ϣ  
			
			int workflowOid = 1069;
			
						 		
			// ��ȡ���ݿ�����
				try{
				String sql1 = "select * from itsm_task_stat_"+workflowOid+" t WHERE to_char(t.task_create_time,'yyyy-mm-dd')='"+date+"' or to_char(t.task_update_time,'yyyy-mm-dd')='"+date+"'";
				List list = instance.getAffairOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
				
				instance.AffairOrderToXml(list, dbwritepath, dbwritefilename);
				
				uploadXml upxml = new uploadXml();
				FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
				
				
				boolean flag = upxml.uploadFile(uploadip,uploadusername,uploadpassword,uploadpath,uploadfilename, inputfile);
				System.out.println(flag);
				
				}catch(Exception e){
					e.printStackTrace();
				}
	    }
	    

	/*
	 * public  void getAffairMonthTask(String ip,int port,String dbname,String username,String password,String dbwritepath,
									String uploadip,String uploadusername,String uploadpassword,String uploadpath) {
	 */
	    public  void getAffairMonthTask() {
		// ���ӵ����ݿ������ url 
		String dbip = "10.32.145.71";
		// �˿ں� 
		int dbport = 1521;
		// ���ݿ�
		String dbtable= "orcl";
		// �û���
		String dbusername="uitsmsys";
		String dbpassword = "tn81eVG1";
		// ִ�е�sql 
		String dbsql = "";
		
		//���ݿ�����д���λ��
		String dbwritepath="E:/codingResource/DBxml/affairTask/";
		// д���ļ���
		
		String dbwritefilename = "";
		
		
		String uploadip = "10.32.145.71";
		String uploadusername = "toptea";
		String uploadpassword = "toptea123";
		String uploadpath = "/toptea/template";
		String uploadfilename= "";
		
		
		int workflowOid = 1069;
		String date = "";
		StringBuffer sbf  = new StringBuffer();
		for(int j =2;j<4;j++){
			if(j ==2){
			 	for(int i = 1;i<29;i++){
			
		//			sbf.append("2017-02-");
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
					 		
				// ��ȡ���ݿ�����
					try{
					String sql1 = "select * from itsm_task_stat_"+workflowOid+" t WHERE to_char(t.task_create_time,'yyyy-mm-dd')='"+date+"' or to_char(t.task_update_time,'yyyy-mm-dd')='"+date+"'";			List list = instance.getAffairOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
					dbwritefilename = "AffairTask"+date +".xml";
					instance.AffairOrderToXml(list, dbwritepath, dbwritefilename);
					
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
					 		
				// ��ȡ���ݿ�����
					try{
					String sql1 = "select * from itsm_task_stat_"+workflowOid+" t WHERE to_char(t.task_create_time,'yyyy-mm-dd')='"+date+"' or to_char(t.task_update_time,'yyyy-mm-dd')='"+date+"'";			List list = instance.getAffairOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
					dbwritefilename = "AffairTask"+date +".xml";
					instance.AffairOrderToXml(list, dbwritepath, dbwritefilename);
					
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
	
	//д��xml
	public void AffairOrderToXml(List list,String localpath,String filename){
		xmlService xs=new xmlService();
		xs.affairOrderWriteXml(list, localpath, filename);
	}
	

	
	public List<AffairOrder> getAffairOrders(String ip,int port,String username,String password,String dbname,String sql){
		
		DBuntil dbu= new DBuntil();
		return dbu.getAffairTasks(ip, port, dbname, username, password, sql);
	}
 
	
}
