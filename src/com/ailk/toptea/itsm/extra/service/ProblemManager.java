package com.ailk.toptea.itsm.extra.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ailk.toptea.itsm.extra.enty.ProblemOrder;
import com.ailk.toptea.itsm.extra.until.DBuntil;


public class ProblemManager {

	  private static ProblemManager instance = new ProblemManager();  
	    private ProblemManager (){}  ;
	    public static ProblemManager getInstance() {  
	    return instance;  
	    }  
	
	
	
	// ������� ��������
	public static void main(String[] args) {
		


		
	}
	
	// ��ȡǰ���������ݣ�ÿ�ն�ʱ��ȡ ÿ�����1��00��ȡ
	public void getDailyTask(String dbip,int dbport,String dbtable,String dbusername,String dbpassword,String dbwritepath,
			String uploadip,String uploadusername,String uploadpassword,String uploadpath){ 
	// public void getDailyTask(){
		/*
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
		String dbwritepath="E:/codingResource/DBxml/problemTask/";
	
		String uploadip = "10.32.145.71";
		String uploadusername = "toptea";
		String uploadpassword = "toptea123";
		String uploadpath = "/toptea/template";
		
	*/		
		// 
		Calendar   cal   =   Calendar.getInstance();
		cal.add(Calendar.DATE,   -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(yesterday);
		// д���ļ���
		
		String prefilename =yesterday;
		String dbwritefilename = "ProblemTask"+prefilename +".xml";
		
		
		String uploadfilename= dbwritefilename;
		
		int workflowOid = 1071;
		// String date = yesterday;
		String date = "2016-02-01";
		
			
		// ��ȡ���ݿ�����
			try{
			String sql1 = "select * from itsm_task_stat_"+workflowOid+" t WHERE to_char(t.task_create_time,'yyyy-mm-dd')='"+date+"' or to_char(t.task_update_time,'yyyy-mm-dd')='"+date+"'";
			List list = instance.getProblemOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
			
			instance.ProblemOrderToXml(list, dbwritepath, dbwritefilename);
			
			uploadXml upxml = new uploadXml();
			FileInputStream inputfile =new FileInputStream(new File(dbwritepath+dbwritefilename));	
			
			
			boolean flag = upxml.uploadFile(uploadip,uploadusername,uploadpassword,uploadpath,uploadfilename, inputfile);
			System.out.println(flag);
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
	}
	
	
	// ��ȡ2�·�����
	public void getMonthTasks(){
	
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
		String dbwritepath="E:/codingResource/DBxml/problemTask/";
		
		String uploadip = "10.32.145.71";
		String uploadusername = "toptea";
		String uploadpassword = "toptea123";
		String uploadpath = "/toptea/template";
		
	
		// д���ļ���
		
		String dbwritefilename = "";		
		
		String uploadfilename= "";
		int workflowOid = 1071;
		String date = "";
		StringBuffer sbf  = new StringBuffer();
		for(int j =2;j<4;j++){
			if(j ==2){
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
					 		
				// ��ȡ���ݿ�����
					try{
					String sql1 = "select * from itsm_task_stat_"+workflowOid+" t WHERE to_char(t.task_create_time,'yyyy-mm-dd')='"+date+"' or to_char(t.task_update_time,'yyyy-mm-dd')='"+date+"'";
					List list = instance.getProblemOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
					dbwritefilename ="ProblemTask"+ date +".xml";
					instance.ProblemOrderToXml(list, dbwritepath, dbwritefilename);
					
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
					String sql1 = "select * from itsm_task_stat_"+workflowOid+" t WHERE to_char(t.task_create_time,'yyyy-mm-dd')='"+date+"' or to_char(t.task_update_time,'yyyy-mm-dd')='"+date+"'";
					List list = instance.getProblemOrders(dbip,dbport,dbusername,dbpassword,dbtable,sql1);
					dbwritefilename ="ProblemTask"+ date +".xml";
					instance.ProblemOrderToXml(list, dbwritepath, dbwritefilename);
					
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
	public void ProblemOrderToXml(List list,String localpath,String filename){
		xmlService xs=new xmlService();
		xs.problemOrderWriteXml(list, localpath, filename);
	}
	
	


	public List<ProblemOrder> getProblemOrders(String ip,int port,String username,String password,String dbname,String sql){
		
		DBuntil dbu= new DBuntil();
		return dbu.getProblemTasks(ip, port, dbname, username, password, sql);
	}
	
}
