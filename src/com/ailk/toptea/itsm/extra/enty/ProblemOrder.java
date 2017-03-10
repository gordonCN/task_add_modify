package com.ailk.toptea.itsm.extra.enty;

import java.util.Date;

public class ProblemOrder extends Order{
	// 问题单
	public Date  fld_problem_plan_time; // 计划完成时间
	public String fld_problem_priority; // 问题优先级
	public String fld_problem_is_batch; // 是否是批量问题
	public String fld_problem_origin; // 问题来源
	public String fld_problem_repeat_site; // 重复问题标志
	public String fld_problem_system; // 所属系统
	public Date fld_problem_end_time; // 诊断结束时间
	public String fld_problem_process_opinion; // 当前处理意见
	public Date   fld_problem_close_time; // 关闭时间
	public String fld_problem_influence; // 影响度
	public String fld_problem_configuration ; // 配置项
	public String fld_problem_type; // 分类；
	public String fld_problem_desc; // 描述
	public String fld_problem_data_maintain; // 数据维护
	public String fld_problem_no_reason; // 无法解决问题
	public String fld_problem_reason; // 问题原因
	public String fld_problem_happen_site ; // 问题发送地点
	public String fld_problem_request_person; // 请求者 
	public String fld_problem_outside_marked; // 外部系统表示
	public Date fld_problem_start_time; // 诊断开始时间
	public String fld_problem_replace_method; // 替代、变通方法
	public String fld_problem_outside_regain; // 外部系统回复状态
	public String fld_problem_state; // 状态、
	public Date fld_problem_complete_time; // 实际上线时间
	public String fld_problem_title; // 标题
	public String fld_problem_id; 
	public String fld_problem_upgrade; //由重大事件升级
	public String fld_problem_result; // 结果
	public String fld_problem_is_complaints; // 是否涉及升级投诉
	public String fld_problem_to_group; //至工作组
	public String fld_problem_to_person ; //至个人
	public String fld_problem_outside_id; // 外部系统id 
	public Date fld_problem_limit_time; // 最终期限
	
	public Date getFld_problem_plan_time() {
		return fld_problem_plan_time;
	}
	public void setFld_problem_plan_time(Date fldProblemPlanTime) {
		fld_problem_plan_time = fldProblemPlanTime;
	}
	public String getFld_problem_priority() {
		return fld_problem_priority;
	}
	public void setFld_problem_priority(String fldProblemPriority) {
		fld_problem_priority = fldProblemPriority;
	}
	public String getFld_problem_is_batch() {
		return fld_problem_is_batch;
	}
	public void setFld_problem_is_batch(String fldProblemIsBatch) {
		fld_problem_is_batch = fldProblemIsBatch;
	}
	public String getFld_problem_origin() {
		return fld_problem_origin;
	}
	public void setFld_problem_origin(String fldProblemOrigin) {
		fld_problem_origin = fldProblemOrigin;
	}
	public String getFld_problem_repeat_site() {
		return fld_problem_repeat_site;
	}
	public void setFld_problem_repeat_site(String fldProblemRepeatSite) {
		fld_problem_repeat_site = fldProblemRepeatSite;
	}
	public String getFld_problem_system() {
		return fld_problem_system;
	}
	public void setFld_problem_system(String fldProblemSystem) {
		fld_problem_system = fldProblemSystem;
	}
	
	public String getFld_problem_process_opinion() {
		return fld_problem_process_opinion;
	}
	public void setFld_problem_process_opinion(String fldProblemProcessOpinion) {
		fld_problem_process_opinion = fldProblemProcessOpinion;
	}
	public Date getFld_problem_close_time() {
		return fld_problem_close_time;
	}
	public void setFld_problem_close_time(Date fldProblemCloseTime) {
		fld_problem_close_time = fldProblemCloseTime;
	}
	public String getFld_problem_influence() {
		return fld_problem_influence;
	}
	public void setFld_problem_influence(String fldProblemInfluence) {
		fld_problem_influence = fldProblemInfluence;
	}
	public String getFld_problem_configuration() {
		return fld_problem_configuration;
	}
	public void setFld_problem_configuration(String fldProblemConfiguration) {
		fld_problem_configuration = fldProblemConfiguration;
	}
	public String getFld_problem_type() {
		return fld_problem_type;
	}
	public void setFld_problem_type(String fldProblemType) {
		fld_problem_type = fldProblemType;
	}
	public String getFld_problem_desc() {
		return fld_problem_desc;
	}
	public void setFld_problem_desc(String fldProblemDesc) {
		fld_problem_desc = fldProblemDesc;
	}
	public String getFld_problem_data_maintain() {
		return fld_problem_data_maintain;
	}
	public void setFld_problem_data_maintain(String fldProblemDataMaintain) {
		fld_problem_data_maintain = fldProblemDataMaintain;
	}
	public String getFld_problem_no_reason() {
		return fld_problem_no_reason;
	}
	public void setFld_problem_no_reason(String fldProblemNoReason) {
		fld_problem_no_reason = fldProblemNoReason;
	}
	public String getFld_problem_reason() {
		return fld_problem_reason;
	}
	public void setFld_problem_reason(String fldProblemReason) {
		fld_problem_reason = fldProblemReason;
	}
	public String getFld_problem_happen_site() {
		return fld_problem_happen_site;
	}
	public void setFld_problem_happen_site(String fldProblemHappenSite) {
		fld_problem_happen_site = fldProblemHappenSite;
	}
	public String getFld_problem_request_person() {
		return fld_problem_request_person;
	}
	public void setFld_problem_request_person(String fldProblemRequestPerson) {
		fld_problem_request_person = fldProblemRequestPerson;
	}
	public String getFld_problem_outside_marked() {
		return fld_problem_outside_marked;
	}
	public void setFld_problem_outside_marked(String fldProblemOutsideMarked) {
		fld_problem_outside_marked = fldProblemOutsideMarked;
	}
	
	public String getFld_problem_replace_method() {
		return fld_problem_replace_method;
	}
	public void setFld_problem_replace_method(String fldProblemReplaceMethod) {
		fld_problem_replace_method = fldProblemReplaceMethod;
	}
	public String getFld_problem_outside_regain() {
		return fld_problem_outside_regain;
	}
	public void setFld_problem_outside_regain(String fldProblemOutsideRegain) {
		fld_problem_outside_regain = fldProblemOutsideRegain;
	}
	public String getFld_problem_state() {
		return fld_problem_state;
	}
	public void setFld_problem_state(String fldProblemState) {
		fld_problem_state = fldProblemState;
	}
	
	public String getFld_problem_title() {
		return fld_problem_title;
	}
	public void setFld_problem_title(String fldProblemTitle) {
		fld_problem_title = fldProblemTitle;
	}
	public String getFld_problem_id() {
		return fld_problem_id;
	}
	public void setFld_problem_id(String fldProblemId) {
		fld_problem_id = fldProblemId;
	}
	public String getFld_problem_upgrade() {
		return fld_problem_upgrade;
	}
	public void setFld_problem_upgrade(String fldProblemUpgrade) {
		fld_problem_upgrade = fldProblemUpgrade;
	}
	public String getFld_problem_result() {
		return fld_problem_result;
	}
	public void setFld_problem_result(String fldProblemResult) {
		fld_problem_result = fldProblemResult;
	}
	public String getFld_problem_is_complaints() {
		return fld_problem_is_complaints;
	}
	public void setFld_problem_is_complaints(String fldProblemIsComplaints) {
		fld_problem_is_complaints = fldProblemIsComplaints;
	}
	public String getFld_problem_to_group() {
		return fld_problem_to_group;
	}
	public void setFld_problem_to_group(String fldProblemToGroup) {
		fld_problem_to_group = fldProblemToGroup;
	}
	public String getFld_problem_to_person() {
		return fld_problem_to_person;
	}
	public void setFld_problem_to_person(String fldProblemToPerson) {
		fld_problem_to_person = fldProblemToPerson;
	}
	public String getFld_problem_outside_id() {
		return fld_problem_outside_id;
	}
	public void setFld_problem_outside_id(String fldProblemOutsideId) {
		fld_problem_outside_id = fldProblemOutsideId;
	}
	public Date getFld_problem_end_time() {
		return fld_problem_end_time;
	}
	public void setFld_problem_end_time(Date fldProblemEndTime) {
		fld_problem_end_time = fldProblemEndTime;
	}
	public Date getFld_problem_start_time() {
		return fld_problem_start_time;
	}
	public void setFld_problem_start_time(Date fldProblemStartTime) {
		fld_problem_start_time = fldProblemStartTime;
	}
	public Date getFld_problem_complete_time() {
		return fld_problem_complete_time;
	}
	public void setFld_problem_complete_time(Date fldProblemCompleteTime) {
		fld_problem_complete_time = fldProblemCompleteTime;
	}
	public Date getFld_problem_limit_time() {
		return fld_problem_limit_time;
	}
	public void setFld_problem_limit_time(Date fldProblemLimitTime) {
		fld_problem_limit_time = fldProblemLimitTime;
	}
	
	
	
	
}
