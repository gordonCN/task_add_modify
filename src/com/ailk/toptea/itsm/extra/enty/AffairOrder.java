package com.ailk.toptea.itsm.extra.enty;

import java.util.Date;

public class AffairOrder extends Order {
	// �¼�������
	public String fld_timeout; // �Ƿ�ʱ
	public String fld_incident_property; //�¼�����
	public String fld_config; // ������
	public Date   fld_begin_time; // ʵ�ʿ�ʼʱ��
	
	public String fld_priority ; // ���ȼ�
	public String fld_classify; // ����
	public String fld_incident_source; // �¼���Դ
	public Date   fld_hanppend_time ; // ����ʱ��
	public String fld_to_user;  // ������
	public String fld_solve_people; //�����
	public String fld_system  ;  // ����ϵͳ
	public String fld_state ; // ����״̬��
	public String fld_desc; // ����
	public String fld_user_role; // �����˽�ɫ
	public String fld_influence_degree; // Ӱ���
	public Date   fld_deadline;  // ��������
	public Date   fld_finish_time;  //ʵ�����ʱ��
	public String fld_to_group; // ��������
	
	public String fld_solve_group ; // ��������ڹ�����
	public String fld_create_group; // ���������ڹ����顢
	public String fld_temp_opinion; // ��ǰ�������   fld_temp_current �������ֶ�
	public String fld_batch; // �Ƿ�Ϊ�������¡�
	public String fld_creater_line; // ������������
	public String fld_gs_belong_sys; // ��ʱ����ϵͳ
	public String fld_gs_task_type; // ��������
	public String fld_gs_work_time_hidden; //��ʱ��
	public String fld_gs_group_id ; // ѡ����Ŀ�顢
	public String fld_gs_job_content; // ������������
	public String fld_gs_job_type; // ��ʱ����    fld_gs_type2  �������ֶ�
	public String fld_gs_operator_id; // ִ����id 
	public Date   fld_gs_arrive_time; // ����ִ����Աʱ��
	public String fld_gs_factory_id; // ѡ����
	public String fld_gs_execu_action ; // ִ�ж���
	public String fld_account_attr; // �ʺ�����
	public String getFld_timeout() {
		return fld_timeout;
	}
	public void setFld_timeout(String fldTimeout) {
		fld_timeout = fldTimeout;
	}
	public String getFld_incident_property() {
		return fld_incident_property;
	}
	public void setFld_incident_property(String fldIncidentProperty) {
		fld_incident_property = fldIncidentProperty;
	}
	public String getFld_config() {
		return fld_config;
	}
	public void setFld_config(String fldConfig) {
		fld_config = fldConfig;
	}
	public Date getFld_begin_time() {
		return fld_begin_time;
	}
	public void setFld_begin_time(Date fldBeginTime) {
		fld_begin_time = fldBeginTime;
	}
	public String getFld_priority() {
		return fld_priority;
	}
	public void setFld_priority(String fldPriority) {
		fld_priority = fldPriority;
	}
	public String getFld_classify() {
		return fld_classify;
	}
	public void setFld_classify(String fldClassify) {
		fld_classify = fldClassify;
	}
	public String getFld_incident_source() {
		return fld_incident_source;
	}
	public void setFld_incident_source(String fldIncidentSource) {
		fld_incident_source = fldIncidentSource;
	}
	public Date getFld_hanppend_time() {
		return fld_hanppend_time;
	}
	public void setFld_hanppend_time(Date fldHanppendTime) {
		fld_hanppend_time = fldHanppendTime;
	}
	public String getFld_to_user() {
		return fld_to_user;
	}
	public void setFld_to_user(String fldToUser) {
		fld_to_user = fldToUser;
	}
	public String getFld_solve_people() {
		return fld_solve_people;
	}
	public void setFld_solve_people(String fldSolvePeople) {
		fld_solve_people = fldSolvePeople;
	}
	public String getFld_system() {
		return fld_system;
	}
	public void setFld_system(String fldSystem) {
		fld_system = fldSystem;
	}
	public String getFld_state() {
		return fld_state;
	}
	public void setFld_state(String fldState) {
		fld_state = fldState;
	}
	public String getFld_desc() {
		return fld_desc;
	}
	public void setFld_desc(String fldDesc) {
		fld_desc = fldDesc;
	}
	public String getFld_user_role() {
		return fld_user_role;
	}
	public void setFld_user_role(String fldUserRole) {
		fld_user_role = fldUserRole;
	}
	
	public String getFld_influence_degree() {
		return fld_influence_degree;
	}
	public void setFld_influence_degree(String fldInfluenceDegree) {
		fld_influence_degree = fldInfluenceDegree;
	}
	public Date getFld_deadline() {
		return fld_deadline;
	}
	public void setFld_deadline(Date fldDeadline) {
		fld_deadline = fldDeadline;
	}
	public Date getFld_finsh_time() {
		return fld_finish_time;
	}
	public void setFld_finsh_time(Date fldFinshTime) {
		fld_finish_time = fldFinshTime;
	}
	public String getFld_to_group() {
		return fld_to_group;
	}
	public void setFld_to_group(String fldToGroup) {
		fld_to_group = fldToGroup;
	}
	public String getFld_solve_group() {
		return fld_solve_group;
	}
	public void setFld_solve_group(String fldSolveGroup) {
		fld_solve_group = fldSolveGroup;
	}
	public String getFld_create_group() {
		return fld_create_group;
	}
	public void setFld_create_group(String fldCreateGroup) {
		fld_create_group = fldCreateGroup;
	}
	public String getFld_temp_opinion() {
		return fld_temp_opinion;
	}
	public void setFld_temp_opinion(String fldTempOpinion) {
		fld_temp_opinion = fldTempOpinion;
	}
	public String getFld_batch() {
		return fld_batch;
	}
	public void setFld_batch(String fldBatch) {
		fld_batch = fldBatch;
	}
	public String getFld_creater_line() {
		return fld_creater_line;
	}
	public void setFld_creater_line(String fldCreaterLine) {
		fld_creater_line = fldCreaterLine;
	}
	public String getFld_gs_belong_sys() {
		return fld_gs_belong_sys;
	}
	public void setFld_gs_belong_sys(String fldGsBelongSys) {
		fld_gs_belong_sys = fldGsBelongSys;
	}
	public String getFld_gs_task_type() {
		return fld_gs_task_type;
	}
	public void setFld_gs_task_type(String fldGsTaskType) {
		fld_gs_task_type = fldGsTaskType;
	}
	public String getFld_gs_work_time_hidden() {
		return fld_gs_work_time_hidden;
	}
	public void setFld_gs_work_time_hidden(String fldGsWorkTimeHidden) {
		fld_gs_work_time_hidden = fldGsWorkTimeHidden;
	}
	public String getFld_gs_group_id() {
		return fld_gs_group_id;
	}
	public void setFld_gs_group_id(String fldGsGroupId) {
		fld_gs_group_id = fldGsGroupId;
	}
	public String getFld_gs_job_content() {
		return fld_gs_job_content;
	}
	public void setFld_gs_job_content(String fldGsJobContent) {
		fld_gs_job_content = fldGsJobContent;
	}
	public String getFld_gs_job_type() {
		return fld_gs_job_type;
	}
	public void setFld_gs_job_type(String fldGsJobType) {
		fld_gs_job_type = fldGsJobType;
	}
	public String getFld_gs_operator_id() {
		return fld_gs_operator_id;
	}
	public void setFld_gs_operator_id(String fldGsOperatorId) {
		fld_gs_operator_id = fldGsOperatorId;
	}
	public Date getFld_gs_arrive_time() {
		return fld_gs_arrive_time;
	}
	public void setFld_gs_arrive_time(Date fldGsArriveTime) {
		fld_gs_arrive_time = fldGsArriveTime;
	}
	public String getFld_gs_factory_id() {
		return fld_gs_factory_id;
	}
	public void setFld_gs_factory_id(String fldGsFactoryId) {
		fld_gs_factory_id = fldGsFactoryId;
	}
	public String getFld_gs_execu_action() {
		return fld_gs_execu_action;
	}
	public void setFld_gs_execu_action(String fldGsExecuAction) {
		fld_gs_execu_action = fldGsExecuAction;
	}
	public String getFld_account_attr() {
		return fld_account_attr;
	}
	public void setFld_account_attr(String fldAccountAttr) {
		fld_account_attr = fldAccountAttr;
	}
	
	
	
}
