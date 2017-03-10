package com.ailk.toptea.itsm.extra.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;

import com.ailk.toptea.itsm.extra.enty.AffairOrder;
import com.ailk.toptea.itsm.extra.enty.ComplainOrder;
import com.ailk.toptea.itsm.extra.enty.ModifyOrder;
import com.ailk.toptea.itsm.extra.enty.ProblemOrder;



public class xmlService {
	
	public void modifyOrderWriteXml(List<ModifyOrder> list,String localpath,String filename){
		ModifyOrder co = new ModifyOrder();
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("BOMC");
		Element task = root.addElement("ModigyOrder");
		for(int i= 0;i<list.size();i++){
			Element taskinfo = task.addElement("ModifyTaskInfo");
			co = list.get(i);
					
			 int id = co.getId();   
			 String strid = String.valueOf(id);
			 Element idxml = taskinfo.addElement("TaskID");
			 idxml.addText(strid);
			 
			 String title = co.getTitle();
			 Element titlexml = taskinfo.addElement("TaskTitle");
			 titlexml.addText(title);
			 
			 Date regTime = co.getRegTime();
			 Element regtimexml = taskinfo.addElement("TaskCreateTime");
			 if(null == regTime){
				 regtimexml.addText("");
			 }else{
				 String dateTostrRegtime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(regTime);
				 regtimexml.addText(dateTostrRegtime);
			 }
			 
			 Date updateTime  = co.getUpdateTime();
			 Element updatetimexml = 	taskinfo.addElement("TaskUpdateTime");
			 if(updateTime == null){
				 updatetimexml.addText("");
			 }else{
				 String dateTostrupdatetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(updateTime);
				 updatetimexml.addText(dateTostrupdatetime);
			 }
			 
			 String askername = co.getAskername();  // 提出人
			 Element askname = taskinfo.addElement("TaskCreater");
			 askname.addText(askername);
			 
			 String origin = co.getOrigin(); // 变更来源 
			 Element originxml = taskinfo.addElement("TaskOrigin");
			 originxml.addText(origin);
			 
			 
			 String subkindinfo = co.getSubkindinfo(); //变更信息
			 Element subkindinfoxml = taskinfo.addElement("ModifyInfo");
			 if(null == subkindinfo){
				 subkindinfo ="";
			 }
			 subkindinfoxml.addText(subkindinfo);
			 
			 String kind = co.getKind(); // 变更类型
			 Element kindxml = taskinfo.addElement("Kind");
			 kindxml.addText(kind);
			 
			 String risklevel = co.getRisklevel(); // 危险级别
			 Element risklevelxml = taskinfo.addElement("RiskLevel");
			 risklevelxml.addText(risklevel);
			 
			 
			 String systype = co.getSystype(); // 所在系统
			 Element systypexml = taskinfo.addElement("SystemType");
			 systypexml.addText(systype);
			 
			 String classname = co.getClassname() ;// 部门
			 Element classnamexml = taskinfo.addElement("ClassName");
			 classnamexml.addText(classname);
			 
			 
			 String describe = co.getDescribe();	 // 描述
			 Element describexml = taskinfo.addElement("Description");
			 describexml.addText(describe);
			 
			 
			 String effectapp = co.getEffectapp();
			 Element effectappxml = taskinfo.addElement("EffectApp");
			 effectappxml.addText(effectapp);
			 
			 
			 
			 String notifydep  = co.getNotifydep();
			 Element notigydepxml = taskinfo.addElement("NotifyDevelopment");
			 notigydepxml.addText(notifydep);
			 
			 String status = co.getStatus();	 // 工单状态
			 Element statusxml = taskinfo.addElement("TaskStatus");
			 statusxml.addText(status);
			 
			 Date accepttime = co.getAccepttime(); // 接受时间 
			 Element accepttimexml = taskinfo.addElement("AcceptTime");
			 if(accepttime == null){
				 accepttimexml.addText("");
			 }else{
				 String accepttimestr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(accepttime);
				 accepttimexml.addText(accepttimestr);
			 }
			 
			 Date planstarttime = co.getPlanstarttime(); // 计划开始时间
			 Element planstarttimexml = taskinfo.addElement("PlanStartTime");
			 if(planstarttime == null){
				 planstarttimexml.addText("");
			 }else{
				 String planstarttimestr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(planstarttime);
				 planstarttimexml.addText(planstarttimestr);
			 }
			 
			 Date planendtime = co.getPlanendtime();
			 Element planendtimexml = taskinfo.addElement("PlanEndTime");
			 if(planendtime == null){
				 planendtimexml.addText("");
			 }else{
				 String planendtimestr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(planendtime);
				 planendtimexml.addText(planendtimestr);
			 }
			 
			 String receiver = co.getReceiver() ; // 接受人
			 Element receiverxml = taskinfo.addElement("Receiver");
			 receiverxml.addText(receiver);
			 			 
			 Date starttime = co.getStarttime();
			 Element starttimexml = taskinfo.addElement("StartTime");
			 if(starttime == null){
				 starttimexml.addText("");
			 }else{
				 String starttimestr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(starttime);
				 starttimexml.addText(starttimestr);
			 }
			 
			 Date endtime = co.getEndtime();
			 Element endtimexml = taskinfo.addElement("EndTime");
			 if(endtime == null){
				 endtimexml.addText("");
			 }else{
				 String endtimestr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(endtime);
				 endtimexml.addText(endtimestr);
			 }
			 
			 String sovler = co.getSovler();
			 Element sovlerxml = taskinfo.addElement("Sovler");
			 sovlerxml.addText(sovler);
		} 
		String filePath = localpath ;  // 创建路径
		//连接服务器 传输文件
		  
		// String fileName = "row3.xml";  // 文件名
		String fileName = filename;
		  
		  String xmlStr = "";
		  xmlStr = document.asXML();
		  try {
		   Document dcmt = DocumentHelper.parseText(xmlStr);
		   saveDocumentToFile(dcmt, filePath, fileName, true, "UTF-8");
		  } catch (DocumentException e) {
		   e.printStackTrace();
		  }
	}
	
	public void complainOrderWriteXml(List<ComplainOrder> list,String localpath,String filename){
		ComplainOrder co = new ComplainOrder();
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("BOMC");
		Element task = root.addElement("ComplainOrder");
		for(int i= 0;i<list.size();i++){
			Element taskinfo = task.addElement("ComplainTaskInfo");
			co = list.get(i);
			
			/*long taskOidtem = co.getTask_id();
			String taskOid = String.valueOf(taskOidtem);
			Element taskoid = taskinfo.addElement("taskOid");
			taskoid.addText(taskOid);*/
			String taskOidtem = co.getTask_id();
			Element taskoid = taskinfo.addElement("taskOid");
			taskoid.addText(taskOidtem);
			
			String taskStatus = co.getTask_status();
			Element taskstatus = taskinfo.addElement("taskStatus");
			taskstatus.addText(taskStatus);
			
			String taskTitle = co.getStr_declaretitle();
			Element tasktitle = taskinfo.addElement("taskTitle");
			tasktitle.addText(taskTitle);
			
			String taskCreateBy = co.getCreate_by();
			Element taskcreateby = taskinfo.addElement("taskCreateBy");
			taskcreateby.addText(taskCreateBy);
			
			Date taskCreateTimeTemp =co.getCreate_date();			
		
			if(null == taskCreateTimeTemp){
				Element taskcreatetime = taskinfo.addElement("taskCreateTime");
				taskcreatetime.addText("");
			}else{
				String taskCreateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(taskCreateTimeTemp);
				Element taskupdatetime = taskinfo.addElement("taskCreateTime");
				taskupdatetime.addText(taskCreateTime);
					
			}
			
			
			String taskUpdataBy = co.getModify_by();
			if(null ==taskUpdataBy ){
				taskUpdataBy="";
			}				
			Element taskupdateby = taskinfo.addElement("taskUpdateBy");
			taskupdateby.addText(taskUpdataBy);
			
			Date taskUpdateByTemp = co.getModify_date();
			if(null == taskUpdateByTemp){
				Element taskupdatetime = taskinfo.addElement("taskUpdateTime");
				taskupdatetime.addText("");
				
			}else{
				String taskUpdateBy = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(taskUpdateByTemp);
				Element taskupdatetime = taskinfo.addElement("taskUpdateTime");
				taskupdatetime.addText(taskUpdateBy);
					
			}
			
			
			
			String per_dispather = co.getPer_dispatcher();
			if(null ==per_dispather ){
				per_dispather="";
			}
			Element perDispather = taskinfo.addElement("perDispatcher");
			perDispather.addText(per_dispather);
			
			String str_kf_status = co.getStr_kf_status();
			if(null ==str_kf_status ){
				str_kf_status="";
			}
			Element Str_kf_status = taskinfo.addElement("kf_status");
			Str_kf_status.addText(str_kf_status);
			
			String  int_inner_deal_count = co.getInt_inner_deal_count();
			if(null ==int_inner_deal_count ){
				int_inner_deal_count="";
			}
			Element Int_innerdealcount =taskinfo.addElement("inner_deal_count");
			Int_innerdealcount.addText(int_inner_deal_count);
			
			String int_reply_count = co.getInt_reply_count();
			if(null ==int_reply_count ){
				int_reply_count="";
			}
			Element IntReplyCount = taskinfo.addElement("replay_count");
			IntReplyCount.addText(int_reply_count);

			String int_complainnumber = co.getInt_complainnumber();
			if(null ==int_complainnumber ){
				int_complainnumber="";
			}
			Element IntComplainNumber = taskinfo.addElement("ComplainNumber");
			IntComplainNumber.addText(int_complainnumber);
			
			String str_complainsubmittime  = co.getStr_complainsubmittime();
			if(null ==str_complainsubmittime ){
				str_complainsubmittime="";
			}
			Element str_Complainsubmittime = taskinfo.addElement("complainsubmittime");
			str_Complainsubmittime.addText(str_complainsubmittime);
			
			String str_declaredesc= co.getStr_declaredesc();
			if(null ==str_declaredesc ){
				str_declaredesc="";
			}
			Element declareDesc = taskinfo.addElement("DeclareDesc");
			declareDesc.addText(str_declaredesc);
			
			String str_kf_serialno = co.getStr_kf_serialno();
			if(null ==str_kf_serialno ){
				str_kf_serialno="";
			}
			Element Str_kf_serialno = taskinfo.addElement("kf_Serialno");
			Str_kf_serialno.addText(str_kf_serialno);
			
			int int_kf_repeat_count = co.getInt_kf_repeat_count();
			
			Element Int_kf_repeat_count = taskinfo.addElement("kf_Repeat_Count");
			Int_kf_repeat_count.addText(int_inner_deal_count);
			
			String handle_person = co.getStr_kf_person();
			if(null ==handle_person ){
				handle_person="";
			}
			Element handlPerson = taskinfo.addElement("kf_Person");
			handlPerson.addText(handle_person);
			
			String kf_organization = co.getStr_kf_organization();
			if(null ==kf_organization ){
				kf_organization="";
			}
			Element organization = taskinfo.addElement("kf_Orgnization");
			organization.addText(kf_organization);
			
			String kf_mobile = co.getStr_kf_mobile();
			if(null ==kf_mobile ){
				kf_mobile="";
			}
			Element  mobile = taskinfo.addElement("kf_Mobile");
			mobile.addText(kf_mobile);
			
			String kf_time = co.getStr_kf_time();
			if(null ==kf_time ){
				kf_time="";
			}
			Element time = taskinfo.addElement("kf_HandleTime");
			time.addText(kf_time);
			
			String kf_comment = co.getStr_kf_comment();
			if(null ==kf_comment ){
				kf_comment="";
			}
			Element comment = taskinfo.addElement("kf_Comment");
			comment.addText(kf_comment);
			
			Date city_time = co.getCity_handle_start_date();
			if(null == city_time){
			Element citytime = taskinfo.addElement("city_HandldTime");
			citytime.addText("");
			}else{
				String citytime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(city_time);
				Element taskupdatetime = taskinfo.addElement("city_HandldTime");
				taskupdatetime.addText(citytime);
					
			}
			
		}
		String filePath = localpath ;  // 创建路径
		//连接服务器 传输文件
		  
		// String fileName = "row3.xml";  // 文件名
		String fileName = filename;
		  
		  String xmlStr = "";
		  xmlStr = document.asXML();
		  try {
		   Document dcmt = DocumentHelper.parseText(xmlStr);
		   saveDocumentToFile(dcmt, filePath, fileName, true, "UTF-8");
		  } catch (DocumentException e) {
		   e.printStackTrace();
		  }
			
	}
	
	public void problemOrderWriteXml(List<ProblemOrder> list,String localpath,String filename){
		ProblemOrder po = new ProblemOrder();
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("BOMC");
		Element task = root.addElement("ProblemOrder");
		for(int i= 0;i<list.size();i++){
			Element taskinfo = task.addElement("ProblemTaskInfo");
			po = list.get(i);
			
			long taskOidtem = po.getTask_oid();
			String taskOid = String.valueOf(taskOidtem);
			Element taskoid = taskinfo.addElement("taskOid");
			taskoid.addText(taskOid);
			
			String taskTitle = po.getTask_title();
			Element tasktitle = taskinfo.addElement("taskTitle");
			tasktitle.addText(taskTitle);
			
			String taskCreateBy = po.getTask_create_by();
			Element taskcreateby = taskinfo.addElement("taskCreateBy");
			taskcreateby.addText(taskCreateBy);
			
			Date taskCreateTimeTemp =po.getTask_create_time();		
			if(null == taskCreateTimeTemp){
				Element taskcreatetime = taskinfo.addElement("taskCreateTime");
				taskcreatetime.addText("");
			}else{
				String taskCreateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(taskCreateTimeTemp);
				Element taskcreatetime = taskinfo.addElement("taskCreateTime");
				taskcreatetime.addText(taskCreateTime);
			}
			
			String taskUpdataBy = po.getTask_update_by();
			Element taskupdateby = taskinfo.addElement("taskUpdateBy");
			taskupdateby.addText(taskUpdataBy);
			
			Date taskUpdateByTemp = po.getTask_update_time();
			if(null == taskUpdateByTemp){
				Element taskupdatetime = taskinfo.addElement("taskUpdateTime");
				taskupdatetime.addText("");
			}else{
				String taskUpdateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(taskUpdateByTemp);
				Element taskupdatetime = taskinfo.addElement("taskUpdateTime");
				taskupdatetime.addText(taskUpdateTime);
					
			}
			
			String taskStatus = po.getTask_status();
			Element taskstatus = taskinfo.addElement("taskStatus");
			taskstatus.addText(taskStatus);
			
			String taskUser = po.getTask_user();
			Element taskuser = taskinfo.addElement("taskUser");
			taskuser.addText(taskUser);
			
			String taskRelations=po.getTask_relations();
			Element taskrelations = taskinfo.addElement("taskRelations");
			taskrelations.addText(taskRelations);
			
			String taskOrigin = po.getTask_origin();
			Element taskorigin = taskinfo.addElement("taskOrigin");
			taskorigin.addText(taskOrigin);
			
		}
		String filePath = localpath ;  // 创建路径
		//连接服务器 传输文件
		  
		// String fileName = "row3.xml";  // 文件名
		String fileName = filename;
		  
		  String xmlStr = "";
		  xmlStr = document.asXML();
		  try {
		   Document dcmt = DocumentHelper.parseText(xmlStr);
		   saveDocumentToFile(dcmt, filePath, fileName, true, "UTF-8");
		  } catch (DocumentException e) {
		   e.printStackTrace();
		  }
		  
	}
	
	public void affairOrderWriteXml(List<AffairOrder> list,String localpath,String filename){
		AffairOrder ao = new AffairOrder();
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("BOMC");
		Element task = root.addElement("AffairOrder");
				
		for(int i= 0;i<list.size();i++){
			Element taskinfo = task.addElement("AffairTaskInfo");
			ao = list.get(i);
			
			long taskOidtem = ao.getTask_oid();
			String taskOid = String.valueOf(taskOidtem);
			Element taskoid = taskinfo.addElement("taskOid");
			taskoid.addText(taskOid);
			
			String taskTitle = ao.getTask_title();
			Element tasktitle = taskinfo.addElement("taskTitle");
			tasktitle.addText(taskTitle);
			
			String taskCreateBy = ao.getTask_create_by();
			Element taskcreateby = taskinfo.addElement("taskCreateBy");
			taskcreateby.addText(taskCreateBy);
			
			Date taskCreateTimeTemp =ao.getTask_create_time();			
			String taskCreateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(taskCreateTimeTemp);
			Element taskcreatetime = taskinfo.addElement("taskCreateTime");
			taskcreatetime.addText(taskCreateTime);
			
			String taskUpdataBy = ao.getTask_update_by();
			Element taskupdateby = taskinfo.addElement("taskUpdateBy");
			taskupdateby.addText(taskUpdataBy);
			
			Date taskUpdateByTemp = ao.getTask_update_time();
			String taskUpdateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(taskUpdateByTemp);
			Element taskupdatetime = taskinfo.addElement("taskUpdateTime");
			taskupdatetime.addText(taskUpdateTime);
			
			String taskStatus = ao.getTask_status();
			Element taskstatus = taskinfo.addElement("taskStatus");
			taskstatus.addText(taskStatus);
			
			String taskUser = ao.getTask_user();
			Element taskuser = taskinfo.addElement("taskUser");
			taskuser.addText(taskUser);
			
			String taskRelations=ao.getTask_relations();
			Element taskrelations = taskinfo.addElement("taskRelations");
			taskrelations.addText(taskRelations);
			
			String taskOrigin = ao.getTask_origin();
			Element taskorigin = taskinfo.addElement("taskOrigin");
			taskorigin.addText(taskOrigin);
			
			String fldAccountAttr = ao.getFld_account_attr();
			Element fldaccountattr =  taskinfo.addElement("fldAccountAttr");
			fldaccountattr.addText(fldAccountAttr);
			
			String fldBatch = ao.getFld_batch();
			Element fldbatch = taskinfo.addElement("fldBatch");
			fldbatch.addText(fldBatch);
			
			
			
			
			
			 
			
		}
		
	
		// 文件存放
		// E:\codingResource		  
	 	String filePath = localpath ;  // 创建路径
		//连接服务器 传输文件
		  
		// String fileName = "row3.xml";  // 文件名
		String fileName = filename;
		  
		  String xmlStr = "";
		  xmlStr = document.asXML();
		  try {
		   Document dcmt = DocumentHelper.parseText(xmlStr);
		   saveDocumentToFile(dcmt, filePath, fileName, true, "UTF-8");
		  } catch (DocumentException e) {
		   e.printStackTrace();
		  }
		  
	}
	 
	 /**
	  * 方法描述：<b>存储完整XML文件.</b></br>
	  * 备 注: </br>
	  * 创 建 人: zyl</br>
	  * 创建日期:2013-3-18</br>
	  *
	  * @param document
	  * @param xmlFilePath
	  * @param xmlFileName
	  * @param isTrimText
	  * @param xmlEncoding
	  */
	 public static void saveDocumentToFile(Document document,String xmlFilePath, String xmlFileName, boolean isTrimText, String xmlEncoding) {
		 if (document == null || xmlFilePath == null || "".equals(xmlFileName)) {
			 return;
		 }

		  File file = new File(xmlFilePath);
		  // 判断路径是否存在，不存在创建
		  if (!file.exists()) {
		   file.mkdirs();
		  }
		  // 保存文件
		  OutputFormat format = null;

		  if (isTrimText) {
		   format = OutputFormat.createPrettyPrint();
		  } else {
		   format = DomXmlOutputFormat.createPrettyPrint();// 保留xml属性值中的回车换行
		  }

		  if (xmlEncoding != null) {
		   format.setEncoding(xmlEncoding);// GBK
		  } else {
		   format.setEncoding("UTF-8");// UTF-8
		  }

		  try {
		   org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
		   new FileOutputStream(xmlFilePath + xmlFileName), format);// FileOutputStream可以使UTF-8生效
		   xmlWriter.write(document);
		   xmlWriter.close();
		  } catch (IOException e) {
		   System.out.println("保存XML异常：" + e.getMessage());
		   System.out.println("正在保存的文件名是：" + xmlFileName);
		  }
		  // 存到文件中结束
	 }
	  	
}
/**
 * 类 描 述：<b>dom4j输出格式化.</b></br>
 * 备      注:  </br>
 * 创  建   人: yanlei.zhao</br>
 * 创建日期: 2011-12-1</br>
 */

class DomXmlOutputFormat extends OutputFormat { 
	 /**
	  * 方法描述：<b>dom4j输出格式化..</b></br>
	  * 备          注: 保存Document到xml文件时，xml属性中的回车换行需要保留，
	  *    可是发现在使用过程中发现dom4j自动把回车换行去掉了。特写此类</br>
	  * 创  建   人: yanlei.zhao</br>
	  * 创建日期: 2011-12-1</br>
	  * @return
	  */
	    public static OutputFormat createPrettyPrint() {  
	        OutputFormat format = new OutputFormat();  
	        format.setIndentSize(2);  
	        format.setNewlines(true);  
	        format.setTrimText(false); // 覆盖 父类的  format.setTrimText(true); 
	        format.setPadText(true);  

	        return format;  
	    }  

}
