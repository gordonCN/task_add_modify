package com.ailk.toptea.itsm.extra.enty;

import java.util.Date;

public class ModifyOrder {
	// �����
// 	select * from vw_itsm_changes t where t.regtime > to_date('2016-01-01','yyyy-mm-dd')
	public int id ;   
	public String title;
	public Date regTime;
	public Date updateTime ;
	
 
	public String askername;  // �����

	public String origin; // �����Դ 
	public String subkindinfo; //�����Ϣ
	public String kind; // �������
	public String risklevel; // Σ�ռ���

	public String systype; // ����ϵͳ
	public String classname ;// ����
	public String describe;	 // ����
	public String effectapp; // Ӱ��ϵͳ

	public String notifydep ;// Ӱ�첿��
	public String status;	 // ����״̬
	public String manager; // ����
	public Date accepttime; // ����ʱ�� 
	public Date planstarttime; // �ƻ���ʼʱ��
	public Date planendtime;
	// CHECKLOG	
	public String receiver ; // ������
	public Date starttime;
	public Date endtime;
	public String sovler;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAskername() {
		return askername;
	}
	public void setAskername(String askername) {
		this.askername = askername;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSubkindinfo() {
		return subkindinfo;
	}
	public void setSubkindinfo(String subkindinfo) {
		this.subkindinfo = subkindinfo;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getRisklevel() {
		return risklevel;
	}
	public void setRisklevel(String risklevel) {
		this.risklevel = risklevel;
	}
	public String getSystype() {
		return systype;
	}
	public void setSystype(String systype) {
		this.systype = systype;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getEffectapp() {
		return effectapp;
	}
	public void setEffectapp(String effectapp) {
		this.effectapp = effectapp;
	}
	public String getNotifydep() {
		return notifydep;
	}
	public void setNotifydep(String notifydep) {
		this.notifydep = notifydep;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getAccepttime() {
		return accepttime;
	}
	public void setAccepttime(Date accepttime) {
		this.accepttime = accepttime;
	}
	public Date getPlanstarttime() {
		return planstarttime;
	}
	public void setPlanstarttime(Date planstarttime) {
		this.planstarttime = planstarttime;
	}
	public Date getPlanendtime() {
		return planendtime;
	}
	public void setPlanendtime(Date planendtime) {
		this.planendtime = planendtime;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getSovler() {
		return sovler;
	}
	public void setSovler(String sovler) {
		this.sovler = sovler;
	} 
	
}
