package com.ailk.toptea.itsm.extra.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getMonthTasks {
	// ��ȡ���๤�� ���ϴ���ָ��λ��
	
	public static void main(String[] args) {
		
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
		
	 
	AffairManager.getInstance().getAffairMonthTask();
	ProblemManager.getInstance().getMonthTasks();
	ModifyManager.getInstance().getMonthTask();
	ComplainManager.getInstance().getMonthTasks();
	
	
	
	
	}
}
