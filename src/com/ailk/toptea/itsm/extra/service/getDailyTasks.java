package com.ailk.toptea.itsm.extra.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class getDailyTasks {

	 public static void main(String[] arg){
		 			 
		
			  TimerTask task = new TaskInfoTask();
		      Calendar  calendar= Calendar.getInstance();    
		      Date firstTime = calendar.getTime(); // ��ǰʱ��
		      System.out.println(firstTime);
		        //�����1Сʱ
		       // long period = 1000 * 60 * 60;    
		        //����ʱ��ÿ10����һ��
		        long period = 1000 * 60 * 60;        
		        
		        Timer timer = new Timer();        
		        timer.schedule(task, firstTime, period);
		
	
	    }
}

class TaskInfoTask extends TimerTask{
	

	// ���ӵ����ݿ������ url 
		String dbip1 = "10.32.145.71"; //affairtask
		String dbip2 = "10.32.145.71"; //problemtask
		String dbip3 = "10.32.145.70"; //modifytask
		String dbip4 = "10.32.145.71"; //complaintask
		// �˿ں� 
		int dbport1 = 1521;
		int dbport2 = 1521;
		int dbport3 = 1521;
		int dbport4 = 1521;
		// ���ݿ�
		String dbtable1= "orcl";
		String dbtable2= "orcl";
		String dbtable3= "bomctest";
		String dbtable4= "orcl";
		// �û���
		String dbusername1="uitsmsys";
		String dbpassword1 = "tn81eVG1";
		String dbusername2="uitsmsys";
		String dbpassword2 = "tn81eVG1";
		String dbusername3="uovsd";
		String dbpassword3 = "manager";
		String dbusername4="usmp";
		String dbpassword4 = "usmp";
		
		
		// ִ�е�sql 
		String dbsql = "";
		
		//���ݿ�����д���λ��
		String dbwritepath1="E:/codingResource/DBxml/affairTask/";
		String dbwritepath2="E:/codingResource/DBxml/problemTask/";
		String dbwritepath3="E:/codingResource/DBxml/modifyTask/";
		String dbwritepath4="E:/codingResource/DBxml/complainTask/";

		
		String uploadip = "10.32.145.71"; 
		String uploadusername = "toptea";
		String uploadpassword = "toptea123";
		String uploadpath = "/toptea/template";
		
	 
	
	 @Override
	    public void run() {
	        // TODO Auto-generated method stub
	        Calendar calendar = Calendar.getInstance();

	        System.out.println("�ȴ��賿 ��ȡbomc ��������");
	    //   int hour = calendar.get(Calendar.HOUR_OF_DAY);
	        int hour = calendar.get(Calendar.HOUR_OF_DAY); // ��ȡ��ǰ�� ����
	        System.out.println(hour);
	        if(16 == hour)
	        {
	            System.out.println("��ʼ��ȡ����");

			    AffairManager.getInstance().getAffairDailyTask(dbip1, dbport1, dbtable1, dbusername1, dbpassword1, dbwritepath1, uploadip, uploadusername, uploadpassword, uploadpath);
	            ProblemManager.getInstance().getDailyTask(dbip2, dbport2, dbtable2, dbusername2, dbpassword2, dbwritepath2, uploadip, uploadusername, uploadpassword, uploadpath);
	            ModifyManager.getInstance().getDailyTask(dbip3, dbport3, dbtable3, dbusername3, dbpassword3, dbwritepath3, uploadip, uploadusername, uploadpassword, uploadpath);
	            ComplainManager.getInstance().getDailyTask(dbip4, dbport4, dbtable4, dbusername4, dbpassword4, dbwritepath4, uploadip, uploadusername, uploadpassword, uploadpath);
			}
	    }
}
