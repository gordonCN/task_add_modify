package com.ailk.toptea.itsm.extra.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ailk.toptea.itsm.extra.enty.AffairOrder;
import com.ailk.toptea.itsm.extra.enty.ComplainOrder;
import com.ailk.toptea.itsm.extra.enty.ModifyOrder;
import com.ailk.toptea.itsm.extra.enty.Order;
import com.ailk.toptea.itsm.extra.enty.ProblemOrder;

public class DBuntil {
	Connection con = null;// 创建一个数据库连接
	PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	ResultSet result = null;// 创建一个结果集对象

	/*oracle 连接
	* 获取事件单
	*/
	public List<AffairOrder> getAffairTasks(String ip,int port,String dbname,String username,String password,String sql){
		List<AffairOrder> list = new ArrayList<AffairOrder>();
		AffairOrder order  = new AffairOrder();
		String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+dbname;
		System.out.println(url);
		try{
			con = getConnection(url, username, password);	
			System.out.println(sql);
			pre = con.prepareStatement(sql);
			result =pre.executeQuery();
			
			while(result.next()){
				
				long task_oid=result.getLong("task_oid");
				
				order.setTask_oid(task_oid);
				
				String task_title=result.getString("task_title");
				order.setTask_title(task_title);
				
				String task_create_by =result.getString("task_create_by");
				order.setTask_create_by(task_create_by);
				Date task_create_time = result.getDate("task_create_time");
				order.setTask_create_time(task_create_time);
				String task_update_by = result.getString("task_update_by");
				order.setTask_update_by(task_update_by);
				Date task_update_time = result.getDate("task_update_time");
				order.setTask_update_time(task_update_time);
				String task_user = result.getString("task_users");
				order.setTask_user(task_user);
				String task_origin = result.getString("task_origin");
				if(null == task_origin ){
					task_origin = "";
				}
				order.setTask_origin(task_origin);
				String task_relations = result.getString("task_relations");
				if(null == task_relations ){
					task_relations = "";
				}
				order.setTask_relations(task_relations);
				
				int n = result.getInt("task_status");
				if(n == 0){
					order.setTask_status("流转");
				}else{
					order.setTask_status("关闭");
				}
				
				String fld_timeout = result.getString("fld_timeout");
				if(null == fld_timeout ){
					fld_timeout = "";
				}
				order.setFld_timeout(fld_timeout);
				
				String fld_config =result.getString("fld_config");
				if(null == fld_config ){
					fld_config = "";
				}
				order.setFld_config(fld_config);
				
				Date fld_begin_time =result.getDate("fld_begin_time");
				order.setFld_begin_time(fld_begin_time);
				
				String fld_priority =result.getString("fld_priority");				
				order.setFld_priority(fld_priority);
				String fld_classify =result.getString("fld_classify");
				if(null == fld_classify ){
					fld_classify = "";
				}
				order.setFld_classify(fld_classify);
				
				String fld_incident_source =result.getString("fld_incident_source");
				if(null == fld_incident_source ){
					fld_incident_source = "";
				}
				order.setFld_incident_source(fld_incident_source);
				
				String fld_incident_property =result.getString("fld_incident_property");
				if(null == fld_incident_property ){
					fld_incident_property = "";
				}
				order.setFld_incident_property(fld_incident_property);
			
				Date fld_hanppend_time= result.getDate("fld_happen_time"); // 发生时间
				order.setFld_hanppend_time(fld_hanppend_time);
				String fld_to_user = result.getString("fld_to_user");  // 至个人
				order.setFld_to_user(fld_to_user);
				String fld_solve_people= result.getString("fld_solve_people"); //解决人
				order.setFld_solve_people(fld_solve_people);
				String fld_system = result.getString("fld_system") ;  // 所属系统				
				order.setFld_system(fld_system);
				
				String fld_state = result.getString("fld_state"); // 处理状态、
				if(null == fld_state ){
					fld_state = "";
				}
				order.setFld_state(fld_state);
				
				String fld_desc= result.getString("fld_desc"); // 描述
				if(null == fld_desc ){
					fld_desc = "";
				}
				order.setFld_desc(fld_desc);
				
				String fld_user_role= result.getString("fld_role"); // 处理人角色
				if(null == fld_user_role ){
					fld_user_role = "";
				}
				order.setFld_user_role(fld_user_role);
				
				String fld_influence_degree= result.getString("fld_influence_degree"); // 影响度
				if(null == fld_influence_degree ){
					fld_influence_degree = "";
				}
				order.setFld_influence_degree(fld_influence_degree);
				
				Date fld_deadline= result.getDate("fld_deadline");  // 最终期限
				order.setFld_deadline(fld_deadline);
				Date fld_finish_time = result.getDate("fld_finish_time");  //实际完成时间
				order.setFld_finsh_time(fld_finish_time);
				
				String fld_to_group= result.getString("fld_to_group"); // 至工作组
				if(null == fld_to_group ){
					fld_to_group = "";
				}
				order.setFld_to_group(fld_to_group);
				
				String fld_solve_group = result.getString("fld_solve_group"); // 解决人所在工作组
				if(null == fld_solve_group ){
					fld_solve_group = "";
				}
				order.setFld_solve_group(fld_solve_group);
				
				String fld_create_group= result.getString("fld_creatergroup"); // 请求者所在工作组、
				if(null == fld_create_group ){
					fld_create_group = "";
				}
				order.setFld_create_group(fld_create_group);
				
				String fld_temp_opinion= result.getString("fld_temp_current"); // 当前处理意见   fld_temp_current 数据中字段
				if(null == fld_temp_opinion ){
					fld_temp_opinion = "";
				}
				order.setFld_temp_opinion(fld_temp_opinion);
				
				String fld_batch= result.getString("fld_batch"); // 是否为批量更新、
				if(null == fld_batch ){
					fld_batch = "";
				}
				order.setFld_batch(fld_batch);
				
				String fld_creater_line= result.getString("fld_create_line"); // 创建人所在线
				if(null == fld_creater_line ){
					fld_creater_line = "";
				}
				order.setFld_creater_line(fld_creater_line);
				
				String fld_gs_belong_sys= result.getString("fld_gs_belong_sys"); // 工时所属系统
				if(null == fld_gs_belong_sys ){
					fld_gs_belong_sys = "";
				}
				order.setFld_gs_belong_sys(fld_gs_belong_sys);
				
				String fld_gs_task_type= result.getString("fld_gs_task_type"); // 工单类型
				if(null == fld_gs_task_type ){
					fld_gs_task_type = "";
				}
				order.setFld_gs_task_type(fld_gs_task_type);
				
				String fld_gs_work_time_hidden= result.getString("fld_gs_work_time_hidden"); //工时量
				if(null == fld_gs_work_time_hidden ){
					fld_gs_work_time_hidden = "";
				}
				order.setFld_gs_work_time_hidden(fld_gs_work_time_hidden);
				
				String fld_gs_group_id = result.getString("fld_gs_group_id2"); // 选择项目组、
				if(null == fld_gs_group_id ){
					fld_gs_group_id = "";
				}
				order.setFld_gs_group_id(fld_gs_group_id);
				
				String fld_gs_job_content= result.getString("fld_gs_job_content"); // 工作内容描述
				if(null == fld_gs_job_content ){
					fld_gs_job_content = "";
				}
				order.setFld_gs_job_content(fld_gs_job_content);
				
				String fld_gs_job_type= result.getString("fld_gs_type2"); // 工时类型    fld_gs_type2  数据中字段
				if(null == fld_gs_job_type ){
					fld_gs_job_type = "";
				}
				order.setFld_gs_job_type(fld_gs_job_type);
				
				String fld_gs_operator_id= result.getString("fld_gs_operator_id"); // 执行人id
				if(null == fld_gs_operator_id ){
					fld_gs_operator_id = "";
				}
				order.setFld_gs_operator_id(fld_gs_operator_id);
				
				Date fld_gs_arrive_time= result.getDate("fld_gs_arrive_time"); // 到达执行人员时间
				order.setFld_gs_arrive_time(fld_gs_arrive_time);
				
				String fld_gs_factory_id= result.getString("fld_gs_factory_id2"); // 选择厂商
				if(null == fld_gs_factory_id ){
					fld_gs_factory_id = "";
				}
				order.setFld_gs_factory_id(fld_gs_factory_id);
				
				String fld_gs_execu_action= result.getString("fld_gs_excu_action") ; // 执行动作
				if(null == fld_gs_execu_action ){
					fld_gs_execu_action = "";
				}
				order.setFld_gs_execu_action(fld_gs_execu_action);
				
				String fld_account_attr= result.getString("fld_account_attr"); // 帐号属性
				if(null == fld_account_attr ){
					fld_account_attr = "";
				}
				order.setFld_account_attr(fld_account_attr);
							
				list.add(order);
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseConnection();
		}
				
		return list;
	}
	
	
	/*问题单获取*/
	public List<ProblemOrder> getProblemTasks(String ip,int port,String dbname,String username,String password,String sql){
		List<ProblemOrder> list = new ArrayList<ProblemOrder>();
		ProblemOrder order =new ProblemOrder();
		String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+dbname;
		System.out.println(url);
		try{
			con = getConnection(url, username, password);	
			System.out.println(sql);
			pre = con.prepareStatement(sql);
			result =pre.executeQuery();
			
			while(result.next()){
				
				long task_oid=result.getLong("task_oid");				
				order.setTask_oid(task_oid);
				
				String task_title=result.getString("task_title");
				order.setTask_title(task_title);
				
				String task_create_by =result.getString("task_create_by");
				order.setTask_create_by(task_create_by);
				Date task_create_time = result.getDate("task_create_time");
				order.setTask_create_time(task_create_time);
				String task_update_by = result.getString("task_update_by");
				order.setTask_update_by(task_update_by);
				Date task_update_time = result.getDate("task_update_time");
				order.setTask_update_time(task_update_time);
				String task_user = result.getString("task_users");
				order.setTask_user(task_user);
				String task_origin = result.getString("task_origin");
				if(null == task_origin ){
					task_origin = "";
				}
				order.setTask_origin(task_origin);
				String task_relations = result.getString("task_relations");
				if(null == task_relations ){
					task_relations = "";
				}
				order.setTask_relations(task_relations);
				
				int n = result.getInt("task_status");
				if(n == 0){
					order.setTask_status("流转");
				}else{
					order.setTask_status("关闭");
				}

				Date fld_problem_plan_time = result.getDate("fld_problem_plan_time");				
				order.setFld_problem_plan_time(fld_problem_plan_time);
				
				String fld_problem_priority =result.getString("fld_problem_priority");
				if(null == fld_problem_priority ){
					fld_problem_priority = "";
				}
				order.setFld_problem_priority(fld_problem_priority);
				
				String fld_problem_is_batch = result.getString("fld_problem_is_batch");
				if(null == fld_problem_is_batch){
					fld_problem_is_batch = "";
				}				
				order.setFld_problem_is_batch(fld_problem_is_batch);
				
				String fld_problem_origin = result.getString("fld_problem_origin");
				if(null == fld_problem_origin){
					fld_problem_origin = "";
				}	
				order.setFld_problem_origin(fld_problem_origin);
				
				String fld_problem_repeat_site = result.getString("fld_problem_repeat_site");
				if(null == fld_problem_repeat_site){
					fld_problem_repeat_site = "";
				}
				order.setFld_problem_repeat_site(fld_problem_repeat_site);
				
				String fld_problem_system = result.getString("fld_problem_system");
				if(null == fld_problem_system){
					fld_problem_system = "";
				}
				order.setFld_problem_system(fld_problem_system);
				
				Date fld_problem_end_time = result.getDate("fld_problem_end_time");
				order.setFld_problem_end_time(fld_problem_end_time);
				
				String fld_problem_process_opinion = result.getString("fld_problem_process_opinion");
				if(null == fld_problem_process_opinion){
					fld_problem_process_opinion = "";
				}
				order.setFld_problem_process_opinion(fld_problem_process_opinion);
				
				Date fld_problem_close_time = result.getDate("fld_problem_close_time");
				order.setFld_problem_close_time(fld_problem_plan_time);
				
				String fld_problem_influence = result.getString("fld_problem_influence");
				if(null == fld_problem_influence){
					fld_problem_influence = "";
				}
				order.setFld_problem_influence(fld_problem_influence);
				
				String fld_problem_configuration = result.getString("fld_problem_configuration");
				if(null == fld_problem_configuration){
					fld_problem_configuration = "";
				}
				order.setFld_problem_configuration(fld_problem_configuration);
				
				String fld_problem_type = result.getString("fld_problem_type");
				if(null == fld_problem_type){
					fld_problem_type = "";
				}
				order.setFld_problem_type(fld_problem_type);
				
				String fld_problem_desc = result.getString("fld_problem_description");
				if(null == fld_problem_desc){
					fld_problem_desc = "";
				}
				order.setFld_problem_desc(fld_problem_desc);
				
				String fld_problem_data_maintain = result.getString("fld_problem_data_maintain");
				if(null == fld_problem_data_maintain){
					fld_problem_data_maintain = "";
				}
				order.setFld_problem_data_maintain(fld_problem_data_maintain);
				
				String fld_problem_no_reason = result.getString("fld_problem_no_reason");
				if(null == fld_problem_no_reason){
					fld_problem_no_reason = "";
				}
				order.setFld_problem_no_reason(fld_problem_no_reason);
				
				String fld_problem_reason = result.getString("fld_problem_reason");
				if(null == fld_problem_reason){
					fld_problem_reason = "";
				}
				order.setFld_problem_reason(fld_problem_reason);
				
				String fld_problem_happen_site = result.getString("fld_problem_happen_site");
				if(null == fld_problem_happen_site){
					fld_problem_happen_site = "";
				}
				order.setFld_problem_happen_site(fld_problem_happen_site);
				
				String fld_problem_request_person = result.getString("fld_problem_request_person");
				if(null == fld_problem_request_person){
					fld_problem_request_person = "";
				}
				order.setFld_problem_request_person(fld_problem_request_person);
				
				String fld_problem_outside_marked = result.getString("fld_problem_outside_marked");
				if(null == fld_problem_outside_marked){
					fld_problem_outside_marked = "";
				}
				order.setFld_problem_outside_marked(fld_problem_outside_marked);
				
				Date fld_problem_start_time = result.getDate("fld_problem_start_time");
				order.setFld_problem_start_time(fld_problem_start_time);
				
				String fld_problem_replace_method = result.getString("fld_problem_replace_method");
				if(null == fld_problem_replace_method){
					fld_problem_replace_method = "";
				}
				order.setFld_problem_replace_method(fld_problem_replace_method);
				
				String fld_problem_outside_regain = result.getString("fld_problem_outside_regain");
				if(null == fld_problem_outside_regain){
					fld_problem_outside_regain = "";
				}
				order.setFld_problem_outside_regain(fld_problem_outside_regain);
				
				String fld_problem_state = result.getString("fld_problem_state");
				if(null == fld_problem_state){
					fld_problem_state = "";
				}
				order.setFld_problem_state(fld_problem_state);
				
				Date fld_problem_complete_time = result.getDate("fld_problem_complete_time");
				order.setFld_problem_complete_time(fld_problem_complete_time);
				
				String fld_problem_title = result.getString("fld_problem_title");
				if(null == fld_problem_title){
					fld_problem_title = "";
				}
				order.setFld_problem_title(fld_problem_title);
				
				String fld_problem_id = result.getString("fld_problem_id");
				if(null == fld_problem_id){
					fld_problem_id = "";
				}
				order.setFld_problem_id(fld_problem_id);
				
				String fld_problem_upgrade = result.getString("fld_problem_upgrade");
				if(null == fld_problem_upgrade){
					fld_problem_upgrade = "";
				}
				order.setFld_problem_upgrade(fld_problem_upgrade);
				
				String fld_problem_result = result.getString("fld_problem_result");
				if(null == fld_problem_result){
					fld_problem_result = "";
				}
				order.setFld_problem_request_person(fld_problem_result);
				
				String fld_problem_is_complaints = result.getString("fld_problem_is_complaints");
				if(null == fld_problem_is_complaints){
					fld_problem_is_complaints = "";
				}
				order.setFld_problem_is_complaints(fld_problem_is_complaints);
				
				String fld_problem_to_group = result.getString("fld_problem_group");
				if(null == fld_problem_to_group){
					fld_problem_to_group = "";
				}
				order.setFld_problem_to_group(fld_problem_to_group);
				
				String fld_problem_to_person = result.getString("fld_problem_person");
				if(null == fld_problem_to_person){
					fld_problem_to_person = "";
				}
				order.setFld_problem_to_person(fld_problem_to_person);
				
				
				String fld_problem_outside_id = result.getString("fld_problem_outside_id");
				if(null == fld_problem_outside_id){
					fld_problem_outside_id = "";
				}
				order.setFld_problem_outside_id(fld_problem_outside_id);
				
				Date fld_problem_limit_time = result.getDate("fld_problem_limit_time");
				order.setFld_problem_limit_time(fld_problem_limit_time);
				
				
				list.add(order);
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseConnection();
		}
				
		return list;
	}
	
	//获取变更单
	public List<ModifyOrder> getModifyTasks(String ip,int port,String dbname,String username,String  password, String sql){
			
			List<ModifyOrder> list = new ArrayList<ModifyOrder>();
			ModifyOrder order  = new ModifyOrder();
			String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+dbname;
			System.out.println(url);
			try{
				con = getConnection(url, username, password);	
				System.out.println(sql);
				pre = con.prepareStatement(sql);
				result =pre.executeQuery();
				
				while(result.next()){
					
					int task_oid=result.getInt("id");
				
					order.setId(task_oid);
					
					String task_title=result.getString("title");
					if(null == task_title){
						task_title = "";
					}
					order.setTitle(task_title);
					
					
					String status = result.getString("status");
					if(null == status){
						status = "";
					}
					order.setStatus("流转");
									
					Date regtime =  result.getDate("regtime");
					order.setRegTime(regtime);
					
					Date update =  result.getDate("updatetime");
					order.setUpdateTime(update);
					
					String askername =  result.getString("askername");
					if(null == askername){
						askername = "";
					}
					order.setAskername(askername);
					
					String origin =  result.getString("origin");
					if(null == origin){
						origin = "";
					}
					order.setOrigin(origin);
					
				/*	 String subkindinfo=  result.getString("subkindinfo");
					 if(null == subkindinfo){
						 subkindinfo = "";
						}
					 order.setSubkindinfo(subkindinfo);
					*/ 
					 String kind=  result.getString("kind");
					 if(null == kind){
						 kind = "";
						}
					 order.setKind(kind);
					 String risklevel=  result.getString("risklevel");
					 if(null == risklevel){
						 risklevel = "";
						}
					 order.setRisklevel(risklevel);
					 String systype=  result.getString("systype");
					 if(null == systype){
						 systype = "";
						}
					 order.setSystype(systype);
					 String classname=  result.getString("class");
					 if(null == classname){
						 classname = "";
						}
					 order.setClassname(classname);
					 String describe=  result.getString("describe");
					 if(null == describe){
						 describe = "";
						}
					 order.setDescribe(describe);
					 String effectapp=  result.getString("effectapp");
					 if(null == effectapp){
						 effectapp = "";
						}
					 order.setEffectapp(effectapp);

					 String notifydep =  result.getString("notifydep");
					 if(null == notifydep){
						 notifydep = "";
						}
					 order.setNotifydep(notifydep);
					 String manager=  result.getString("manager");
					 if(null == manager){
						 manager = "";
						}
					 order.setManager(manager);
					 Date accepttime=  result.getDate("accepttime");
					 order.setAccepttime(accepttime);
					 Date planstarttime=  result.getDate("planstarttime");
					 order.setPlanstarttime(planstarttime);
					 Date planendtime=  result.getDate("planendtime");
					 order.setPlanendtime(planendtime);
					// CHECKLOG	
					 String receiver =  result.getString("receiver");
					 if(null == receiver){
						 receiver = "";
						}
					 order.setReceiver(receiver);
					 Date starttime=  result.getDate("starttime");
					 order.setStarttime(starttime);
					 Date endtime=  result.getDate("endtime");
					 order.setEndtime(endtime);
					 String solver=  result.getString("solver");
					 if(null == solver){
						 solver = "";
						}
					 order.setSovler(solver) ;
					
					list.add(order);
					
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				CloseConnection();
			}
					
			return list;
	}
	
	
	/*投诉单获取*/
	public List<ComplainOrder> getComplainTasks(String ip,int port,String dbname,String username,String  password, String sql){
		
		List<ComplainOrder> list = new ArrayList<ComplainOrder>();
		ComplainOrder order  = new ComplainOrder();
		String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+dbname;
		System.out.println(url);
		try{
			con = getConnection(url, username, password);	
			System.out.println(sql);
			pre = con.prepareStatement(sql);
			result =pre.executeQuery();
			
			while(result.next()){
				
				String task_oid=result.getString("task_id");
				order.setTask_id(task_oid);
				
				String task_title=result.getString("str_declaretitle");
				order.setStr_declaretitle(task_title);
				
				
				int n = result.getInt("task_status");
				if(n == 0){
					order.setTask_status("流转");
				}else{
					order.setTask_status("关闭");
				}
								
				String task_create_by =result.getString("create_by");
				order.setCreate_by(task_create_by);
				
				Date task_create_time = result.getDate("create_date");
				order.setCreate_date(task_create_time);
				
				String task_update_by = result.getString("modify_by");
				order.setModify_by(task_update_by);
				
				Date task_update_time = result.getDate("modify_date");				
				order.setModify_date(task_update_time);
				
				String perdispatcher = result.getString("per_dispatcher");
				order.setPer_dispatcher(perdispatcher);
			//	result.getString("");
				String kfStatus = result.getString("str_kf_status");
				order.setStr_kf_status(kfStatus);
						
				int dealcount = result.getInt("int_inner_deal_count");
				String incount = String.valueOf(dealcount);
				order.setInt_inner_deal_count(incount);
				
				int int_reply_count = result.getInt("int_reply_count");
				String replycount = String.valueOf(int_reply_count);
				order.setInt_reply_count(replycount);
				
				String int_complainnumber = result.getString("int_complainnumber");
				order.setInt_complainnumber(int_complainnumber);
				
				String str_complainsubmittime =result.getString("str_complainsubmittime");
			//	String complainsubmittime = new SimpleDateFormat().format(str_complainsubmittime);
				order.setStr_complainsubmittime(str_complainsubmittime);
				
				String str_declaredesc = result.getString("str_declaredesc");
				order.setStr_declaredesc(str_declaredesc);
				
				String str_kf_serialno = result.getString("str_kf_serialno");
				order.setStr_kf_serialno(str_kf_serialno);
				
				int int_kf_repeat_count = result.getInt("int_kf_repeat_count");			
				order.setInt_kf_repeat_count(int_kf_repeat_count);
				
				String str_kf_person = result.getString("str_kf_person");
				order.setStr_kf_person(str_kf_person);
				
				String str_kf_organization = result.getString("str_kf_organization");
				order.setStr_kf_organization(str_kf_organization);
				
				String str_kf_mobile = result.getString("str_kf_mobile");
				order.setStr_kf_mobile(str_kf_mobile);
				
				String str_kf_time = result.getString("str_kf_time");
				order.setStr_kf_time(str_kf_time);
				
				String str_kf_comment =result.getString("str_kf_comment");
				order.setStr_kf_comment(str_kf_comment);
				 
				Date city_handle_start_date = result.getDate("city_handle_start_date");
				
				order.setCity_handle_start_date(city_handle_start_date);
				
				list.add(order);
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseConnection();
		}
				
		return list;
	}
	
	/*oracle 连接
	* 获取事件单，问题单 
	*/
	public List<Order> getTasks(String ip,int port,String dbname,String username,String password,String sql){
		List<Order> list = null;
		Order order = new Order();
		String url = "jdbc:oracle:thin@"+ip+":"+port+":"+dbname;
		System.out.println(url);
		try{
			con = getConnection(url, username, password);	
			System.out.println(sql);
			pre = con.prepareStatement(sql);
			result =pre.executeQuery();
			
			while(result.next()){
				order.task_oid=result.getLong("task_oid");
				order.task_title=result.getString("task_title");
				order.task_create_by =result.getString("task_create_by");
				order.task_create_time = result.getDate("task_create_time");				
				order.task_update_by = result.getString("task_update_by");
				order.task_update_time = result.getDate("task_update_time");
				order.task_user = result.getString("task_user");				
				order.task_origin = result.getString("origin");
				
				int n = result.getInt("task_status");
				if(n == 0){
					order.task_status  = "流转";
				}else{
					order.task_status = "关闭";
				}
				
				list.add(order);
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseConnection();
		}
				
		return list;
	}
	
	public Connection  getConnection(String url,String username,String password){
		 try{
			 	Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
			 
			 	System.out.println("开始尝试连接数据库！");
			    con = DriverManager.getConnection(url, username, password);// 获取连接
		        System.out.println("连接成功！");
		 }catch(ClassNotFoundException e){
			 e.printStackTrace();
		 }catch(SQLException e1){
			 e1.printStackTrace();		 
		 }
		 return con;
	}
	
	// 断开连接
	public void CloseConnection (){
	
			 try{
				 if(con != null){
					 con.close();
				 }
				 if(pre != null){
					 pre.close();
				 }
				 if(result !=null){
					 result.close();
				 }
			 }catch(SQLException e2){
				 e2.printStackTrace();
			 }
		
	}
}
