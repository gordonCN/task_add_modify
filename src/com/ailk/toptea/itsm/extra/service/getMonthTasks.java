package com.ailk.toptea.itsm.extra.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getMonthTasks {
	// 获取四类工单 并上传至指定位置
	
	public static void main(String[] args) {
		
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
		
	 
	AffairManager.getInstance().getAffairMonthTask();
	ProblemManager.getInstance().getMonthTasks();
	ModifyManager.getInstance().getMonthTask();
	ComplainManager.getInstance().getMonthTasks();
	
	
	
	
	}
}
