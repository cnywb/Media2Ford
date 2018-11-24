package com.agenda.api.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "M2F_ERROR_USERDATA", schema = "CRM")
public class M2FErrorUserData implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long did;
	private Date createdate;
	private String name;
	private String gender;
	private String mobile;
	private String tel;
	private String email1;
	private String email2;
	private String interested;
	private String boxnum;
	private String model;
	private String buycartime;
	private String province;
	private String city;
	private String address;
	private String postcode;
	private String booking;
	private String dealername;
	private String dealercode;
	private String testdrivetime;
	private String hasdrivelicense;
	private String budgetcar;
	private String hascarbrand;
	private String cartime;
	private String source;
	private String fricontact;
	private String seccontact;
	private String otherinterested;
	private String otherbrandpropaganda;
	private String eventcode;
	private String age;
	private String ismarry;
	private String background;
	private String industry;
	private String profession;
	private String income;
	private String memo1;
	private String memo2;
	private String memo3;
	private String memo4;
	private String memo5;
	private String memo6;
	private String memo7;
	private String memo8;
	private String memo9;
	private String memo10;
	private Date dateline;
	private int flag;
	
	public M2FErrorUserData() {}
	
	@Id
	@GeneratedValue(generator="SEQ_M2F_USERDATA", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName="SEQ_M2F_USERDATA", name="SEQ_M2F_USERDATA", allocationSize=1)
	@Column(name = "DID", unique = true, nullable = false, precision = 38)
	public long getDid() {
		return did;
	}
	
	public void setDid(long did) {
		this.did = did;
	}
	
	@Column(name = "CREATEDATE", length = 20)
	public Date getCreatedate() {
		return createdate;
	}
	
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Column(name = "NAME", length = 100)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "GENDER", length = 100)
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "MOBILE", length = 100)
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name = "TEL", length = 100)
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name = "EMAIL1", length = 100)
	public String getEmail1() {
		return email1;
	}
	
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	
	@Column(name = "EMAIL2", length = 100)
	public String getEmail2() {
		return email2;
	}
	
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	@Column(name = "INTERESTED", length = 100)
	public String getInterested() {
		return interested;
	}
	
	public void setInterested(String interested) {
		this.interested = interested;
	}
	
	@Column(name = "BOXNUM", length = 100)
	public String getBoxnum() {
		return boxnum;
	}
	
	public void setBoxnum(String boxnum) {
		this.boxnum = boxnum;
	}
	
	@Column(name = "MODEL", length = 100)
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name = "BUYCARTIME", length = 100)
	public String getBuycartime() {
		return buycartime;
	}
	
	public void setBuycartime(String buycartime) {
		this.buycartime = buycartime;
	}
	
	@Column(name = "PROVINCE", length = 100)
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Column(name = "CITY", length = 100)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "ADDRESS", length = 100)
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "POSTCODE", length = 100)
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	@Column(name = "BOOKING", length = 100)
	public String getBooking() {
		return booking;
	}
	
	public void setBooking(String booking) {
		this.booking = booking;
	}
	
	@Column(name = "DEALERNAME", length = 100)
	public String getDealername() {
		return dealername;
	}
	
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	
	@Column(name = "DEALERCODE", length = 100)
	public String getDealercode() {
		return dealercode;
	}
	
	public void setDealercode(String dealercode) {
		this.dealercode = dealercode;
	}
	
	@Column(name = "TESTDRIVETIME", length = 100)
	public String getTestdrivetime() {
		return testdrivetime;
	}
	
	public void setTestdrivetime(String testdrivetime) {
		this.testdrivetime = testdrivetime;
	}
	
	@Column(name = "HASDRIVELICENSE", length = 100)
	public String getHasdrivelicense() {
		return hasdrivelicense;
	}
	
	public void setHasdrivelicense(String hasdrivelicense) {
		this.hasdrivelicense = hasdrivelicense;
	}
	
	@Column(name = "BUDGETCAR", length = 100)
	public String getBudgetcar() {
		return budgetcar;
	}
	
	public void setBudgetcar(String budgetcar) {
		this.budgetcar = budgetcar;
	}
	
	@Column(name = "HASCARBRAND", length = 100)
	public String getHascarbrand() {
		return hascarbrand;
	}
	
	public void setHascarbrand(String hascarbrand) {
		this.hascarbrand = hascarbrand;
	}
	
	@Column(name = "CARTIME", length = 100)
	public String getCartime() {
		return cartime;
	}
	
	public void setCartime(String cartime) {
		this.cartime = cartime;
	}
	
	@Column(name = "SOURCE", length = 100)
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name = "FRICONTACT", length = 100)
	public String getFricontact() {
		return fricontact;
	}
	
	public void setFricontact(String fricontact) {
		this.fricontact = fricontact;
	}
	
	@Column(name = "SECCONTACT", length = 100)
	public String getSeccontact() {
		return seccontact;
	}
	
	public void setSeccontact(String seccontact) {
		this.seccontact = seccontact;
	}
	
	@Column(name = "OTHERINTERESTED", length = 100)
	public String getOtherinterested() {
		return otherinterested;
	}
	
	public void setOtherinterested(String otherinterested) {
		this.otherinterested = otherinterested;
	}
	
	@Column(name = "OTHERBRANDPROPAGANDA", length = 100)
	public String getOtherbrandpropaganda() {
		return otherbrandpropaganda;
	}
	
	public void setOtherbrandpropaganda(String otherbrandpropaganda) {
		this.otherbrandpropaganda = otherbrandpropaganda;
	}
	
	@Column(name = "EVENTCODE", length = 100)
	public String getEventcode() {
		return eventcode;
	}
	
	public void setEventcode(String eventcode) {
		this.eventcode = eventcode;
	}
	
	@Column(name = "AGE", length = 100)
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	@Column(name = "ISMARRY", length = 100)
	public String getIsmarry() {
		return ismarry;
	}
	
	public void setIsmarry(String ismarry) {
		this.ismarry = ismarry;
	}
	
	@Column(name = "BACKGROUND", length = 100)
	public String getBackground() {
		return background;
	}
	
	public void setBackground(String background) {
		this.background = background;
	}
	
	@Column(name = "INDUSTRY", length = 100)
	public String getIndustry() {
		return industry;
	}
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	@Column(name = "PROFESSION", length = 100)
	public String getProfession() {
		return profession;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	@Column(name = "INCOME", length = 100)
	public String getIncome() {
		return income;
	}
	
	public void setIncome(String income) {
		this.income = income;
	}
	
	@Column(name = "MEMO1", length = 100)
	public String getMemo1() {
		return memo1;
	}
	
	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}
	
	@Column(name = "MEMO2", length = 100)
	public String getMemo2() {
		return memo2;
	}
	
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	
	@Column(name = "MEMO3", length = 100)
	public String getMemo3() {
		return memo3;
	}
	
	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}
	
	@Column(name = "MEMO4", length = 100)
	public String getMemo4() {
		return memo4;
	}
	
	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}
	
	@Column(name = "MEMO5", length = 100)
	public String getMemo5() {
		return memo5;
	}
	
	public void setMemo5(String memo5) {
		this.memo5 = memo5;
	}
	
	@Column(name = "MEMO6", length = 100)
	public String getMemo6() {
		return memo6;
	}
	
	public void setMemo6(String memo6) {
		this.memo6 = memo6;
	}
	
	@Column(name = "MEMO7", length = 100)
	public String getMemo7() {
		return memo7;
	}
	
	public void setMemo7(String memo7) {
		this.memo7 = memo7;
	}
	
	@Column(name = "MEMO8", length = 100)
	public String getMemo8() {
		return memo8;
	}
	
	public void setMemo8(String memo8) {
		this.memo8 = memo8;
	}
	
	@Column(name = "MEMO9", length = 100)
	public String getMemo9() {
		return memo9;
	}
	
	public void setMemo9(String memo9) {
		this.memo9 = memo9;
	}
	
	@Column(name = "MEMO10", length = 100)
	public String getMemo10() {
		return memo10;
	}
	
	public void setMemo10(String memo10) {
		this.memo10 = memo10;
	}
	
	@Column(name = "DATELINE", length = 7)
	public Date getDateline() {
		return dateline;
	}
	
	public void setDateline(Date dateline) {
		this.dateline = dateline;
	}
	
	@Column(name = "FLAG", length = 100)
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
}

