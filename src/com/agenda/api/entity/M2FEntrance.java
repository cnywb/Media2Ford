package com.agenda.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "M2F_ENTRANCE", schema = "CRM")
public class M2FEntrance implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eventcode;
	private String entrancename;
	private String entrancedesc;
	private String entranceurl;
	private int mid;
	private int inputtype;
	private Date entrancestarttime;
	private Date entranceendtime;
	private Date createdate;
	private Date modifydate;
	private long auid;
	private String memo;
	private int flag;
	private int pid;
	
	public M2FEntrance() {}
	
	@Id
	@Column(name = "EVENTCODE", unique = false, nullable = false, length = 100)
	public String getEventcode() {
		return eventcode;
	}
	
	public void setEventcode(String eventcode) {
		this.eventcode = eventcode;
	}
	
	@Column(name = "ENTRANCENAME", length = 100)
	public String getEntrancename() {
		return entrancename;
	}
	
	public void setEntrancename(String entrancename) {
		this.entrancename = entrancename;
	}
	
	@Column(name = "ENTRANCEDESC", length = 200)
	public String getEntrancedesc() {
		return entrancedesc;
	}
	
	public void setEntrancedesc(String entrancedesc) {
		this.entrancedesc = entrancedesc;
	}
	
	@Column(name = "ENTRANCEURL", length = 200)
	public String getEntranceurl() {
		return entranceurl;
	}
	
	public void setEntranceurl(String entranceurl) {
		this.entranceurl = entranceurl;
	}
	
	@Column(name = "MID", length = 20)
	public int getMid() {
		return mid;
	}
	
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	@Column(name = "INPUTTYPE", precision = 22, scale = 0)
	public int getInputtype() {
		return inputtype;
	}
	
	public void setInputtype(int inputtype) {
		this.inputtype = inputtype;
	}
	
	@Column(name = "ENTRANCESTARTTIME", length = 20)
	public Date getEntrancestarttime() {
		return entrancestarttime;
	}
	
	public void setEntrancestarttime(Date entrancestarttime) {
		this.entrancestarttime = entrancestarttime;
	}
	
	@Column(name = "ENTRANCEENDTIME", length = 20)
	public Date getEntranceendtime() {
		return entranceendtime;
	}
	
	public void setEntranceendtime(Date entranceendtime) {
		this.entranceendtime = entranceendtime;
	}
	
	@Column(name = "CREATEDATE", length = 20)
	public Date getCreatedate() {
		return createdate;
	}
	
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Column(name = "MODIFYDATE", length = 20)
	public Date getModifydate() {
		return modifydate;
	}
	
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	
	@Column(name = "AUID", length = 100)
	public long getAuid() {
		return auid;
	}
	
	public void setAuid(long auid) {
		this.auid = auid;
	}
	
	@Column(name = "MEMO", length = 1000)
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Column(name = "FLAG", length = 20)
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Column(name = "PID", length = 20)
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
