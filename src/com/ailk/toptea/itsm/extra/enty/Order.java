package com.ailk.toptea.itsm.extra.enty;

import java.util.Date;

public class Order {

	//�����ࣨ�����ࣩ
	
	public long task_oid; // ������
	public String task_title; // ��������
	public String task_create_by; // ����������
	public Date task_create_time; // ��������ʱ��
	public String task_update_by; // ����������
	public Date task_update_time; // ��������ʱ��
	public String task_relations; // �����漰��
	public String task_status; 	// ����״̬ --�Ƿ�ر�
	public String task_user; // ����������
	public String task_origin; // ������Դ��Ϊ��ʱ��Ϊ��ϵͳ�Խ�
	
	
	
	public long getTask_oid() {
		return task_oid;
	}
	public void setTask_oid(long taskOid) {
		task_oid = taskOid;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String taskTitle) {
		task_title = taskTitle;
	}
	public String getTask_create_by() {
		return task_create_by;
	}
	public void setTask_create_by(String taskCreateBy) {
		task_create_by = taskCreateBy;
	}
	
	public String getTask_update_by() {
		return task_update_by;
	}
	public void setTask_update_by(String taskUpdateBy) {
		task_update_by = taskUpdateBy;
	}

	public Date getTask_create_time() {
		return task_create_time;
	}
	public void setTask_create_time(Date taskCreateTime) {
		task_create_time = taskCreateTime;
	}
	public Date getTask_update_time() {
		return task_update_time;
	}
	public void setTask_update_time(Date taskUpdateTime) {
		task_update_time = taskUpdateTime;
	}
	public String getTask_relations() {
		return task_relations;
	}
	public void setTask_relations(String taskRelations) {
		task_relations = taskRelations;
	}
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String taskStatus) {
		task_status = taskStatus;
	}
	public String getTask_user() {
		return task_user;
	}
	public void setTask_user(String taskUser) {
		task_user = taskUser;
	}
	public String getTask_origin() {
		return task_origin;
	}
	public void setTask_origin(String taskOrigin) {
		task_origin = taskOrigin;
	}
}
