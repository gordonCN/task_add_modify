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
		      Date firstTime = calendar.getTime(); // 当前时间
		      System.out.println(firstTime);
		        //间隔：1小时
		       // long period = 1000 * 60 * 60;    
		        //测试时间每10分钟一次
		        long period = 1000 * 60 * 60;        
		        
		        Timer timer = new Timer();        
		        timer.schedule(task, firstTime, period);
		
	
	    }
}

class TaskInfoTask extends TimerTask{
	

	// 连接的数据库服务器 url 
		String dbip1 = "10.32.145.71"; //affairtask
		String dbip2 = "10.32.145.71"; //problemtask
		String dbip3 = "10.32.145.70"; //modifytask
		String dbip4 = "10.32.145.71"; //complaintask
		// 端口号 
		int dbport1 = 1521;
		int dbport2 = 1521;
		int dbport3 = 1521;
		int dbport4 = 1521;
		// 数据库
		String dbtable1= "orcl";
		String dbtable2= "orcl";
		String dbtable3= "bomctest";
		String dbtable4= "orcl";
		// 用户名
		String dbusername1="uitsmsys";
		String dbpassword1 = "tn81eVG1";
		String dbusername2="uitsmsys";
		String dbpassword2 = "tn81eVG1";
		String dbusername3="uovsd";
		String dbpassword3 = "manager";
		String dbusername4="usmp";
		String dbpassword4 = "usmp";
		
		
		// 执行的sql 
		String dbsql = "";
		
		//数据库数据写入的位置
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

	        System.out.println("等待凌晨 获取bomc 工单数据");
	    //   int hour = calendar.get(Calendar.HOUR_OF_DAY);
	        int hour = calendar.get(Calendar.HOUR_OF_DAY); // 获取当前的 参数
	        System.out.println(hour);
	        if(16 == hour)
	        {
	            System.out.println("开始获取数据");

			    AffairManager.getInstance().getAffairDailyTask(dbip1, dbport1, dbtable1, dbusername1, dbpassword1, dbwritepath1, uploadip, uploadusername, uploadpassword, uploadpath);
	            ProblemManager.getInstance().getDailyTask(dbip2, dbport2, dbtable2, dbusername2, dbpassword2, dbwritepath2, uploadip, uploadusername, uploadpassword, uploadpath);
	            ModifyManager.getInstance().getDailyTask(dbip3, dbport3, dbtable3, dbusername3, dbpassword3, dbwritepath3, uploadip, uploadusername, uploadpassword, uploadpath);
	            ComplainManager.getInstance().getDailyTask(dbip4, dbport4, dbtable4, dbusername4, dbpassword4, dbwritepath4, uploadip, uploadusername, uploadpassword, uploadpath);
			}
	    }
}
