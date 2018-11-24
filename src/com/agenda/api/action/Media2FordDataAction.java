package com.agenda.api.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.agenda.api.entity.M2FEntrance;
import com.agenda.api.entity.M2FUserData;
import com.agenda.api.exception.ActionAccessException;
import com.agenda.api.manager.M2FEntranceManager;
import com.agenda.api.manager.M2FUserDataManager;
import com.agenda.api.model.BaseResponse;
import com.agenda.api.service.Media2FordService;
import com.agenda.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts2ajax")
@Scope("prototype")
@Controller
public class Media2FordDataAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Media2FordDataAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	@Autowired
	private M2FUserDataManager m2fUserDataMng;
	@Autowired
	private M2FEntranceManager m2fEntranceMng;
	@Autowired
	private Media2FordService media2FordService;
	private String createDate;
	private String name;
	private String gender;
	private String mobile;
	private String tel;
	private String email1;
	private String email2;
	private String interested;
	private String boxNum;
	private String model;
	private String buyCarTime;
	private String province;
	private String city;
	private String address;
	private String postcode;
	private String booking;
	private String dealerName;
	private String dealerCode;
	private String testDriveTime;
	private String hasDriveLicense;
	private String budgetCar;
	private String hasCarBrand;
	private String carTime;
	private String source;
	private String friContact;
	private String secContact;
	private String otherInterested;
	private String otherBrandPropaganda;
	private String eventCode;
	private String age;
	private String isMarry;
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
	private long status;

	@Action(value = "CommitData", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", type = "json") })
	public String CommitData() {
		log.info("JS调用:接口参数CommitData: "+"createDate："+createDate+"name："+name+"gender："+gender+"mobile："+mobile+"tel："+tel+"email1："+email1+"email2："+email2+"interested："+interested+"boxNum："+boxNum+"model："
				+model+"buyCarTime："+buyCarTime+"province："+province+"city："+city+"address："+address+"postcode："+postcode+"booking："+booking+"dealerName："+dealerName+"dealerCode："+dealerCode+"testDriveTime："
				+testDriveTime+"hasDriveLicense："+hasDriveLicense+"budgetCar："+budgetCar+"hasCarBrand："+hasCarBrand+"carTime："+carTime+"source："+source+"friContact："+friContact+"secContact："+secContact+"otherInterested："+
				otherInterested+"otherBrandPropaganda："+otherBrandPropaganda+"eventCode："+eventCode+"age："+age+"isMarry："+isMarry+"background："+background+"industry："+industry+"profession："+profession+"income："+
				income+"memo1："+memo1+"memo2："+memo2+"memo3："+memo3+"memo4："+memo4+"memo5："+memo5+"memo6："+memo6+"memo7："+memo7+"memo8："+memo8+"memo9："+memo9+"memo10："+memo10);

		M2FUserData userdata = null;
		try {
			if (!Utils.isNullorEmpty(this.eventCode)) {
				M2FEntrance m2fEntrance = (M2FEntrance) this.m2fEntranceMng.get(this.eventCode);
				if (m2fEntrance != null) {
					List<M2FUserData> userdataList = this.m2fUserDataMng.getM2FUserDataByECodeMobile(this.eventCode,
							this.mobile);
					if ((userdataList == null) || (userdataList.size() == 0)) {
						userdata = setM2FUserData();
						userdata = (M2FUserData) this.m2fUserDataMng.save(userdata);
						this.status = userdata.getDid();
					} else {
						userdata = (M2FUserData) userdataList.get(0);
						this.status = userdata.getDid();
					}
				} else {
					this.status = -9L;
				}
			} else {
				this.status = -9L;
			}
		} catch (ActionAccessException ex) {
			log.error("", ex);
		} catch (Exception ex) {
			log.error("", ex);
			this.status = -99L;
		} catch (Throwable ex) {
			log.error("", ex);
			this.status = -99L;
		}
		return "success";
	}

	@Action("commitDataJSONP")
	public void commitDataJSONP() {
		log.info("JS调用:接口参数commitDataJSONP: "+"createDate："+createDate+"name："+name+"gender："+gender+"mobile："+mobile+"tel："+tel+"email1："+email1+"email2："+email2+"interested："+interested+"boxNum："+boxNum+"model："
				+model+"buyCarTime："+buyCarTime+"province："+province+"city："+city+"address："+address+"postcode："+postcode+"booking："+booking+"dealerName："+dealerName+"dealerCode："+dealerCode+"testDriveTime："
				+testDriveTime+"hasDriveLicense："+hasDriveLicense+"budgetCar："+budgetCar+"hasCarBrand："+hasCarBrand+"carTime："+carTime+"source："+source+"friContact："+friContact+"secContact："+secContact+"otherInterested："+
				otherInterested+"otherBrandPropaganda："+otherBrandPropaganda+"eventCode："+eventCode+"age："+age+"isMarry："+isMarry+"background："+background+"industry："+industry+"profession："+profession+"income："+
				income+"memo1："+memo1+"memo2："+memo2+"memo3："+memo3+"memo4："+memo4+"memo5："+memo5+"memo6："+memo6+"memo7："+memo7+"memo8："+memo8+"memo9："+memo9+"memo10："+memo10);

		String jsonp = this.request.getParameter("jsonpcallback").toString();
		M2FUserData userdata = null;
		try {
			if (!Utils.isNullorEmpty(this.eventCode)) {
				M2FEntrance m2fEntrance = (M2FEntrance) this.m2fEntranceMng.get(this.eventCode);
				if (m2fEntrance != null) {
					List<M2FUserData> userdataList = this.m2fUserDataMng.getM2FUserDataByECodeMobile(this.eventCode,
							this.mobile);
					if ((userdataList == null) || (userdataList.size() == 0)) {
						this.status = this.media2FordService.CommitData(this.createDate, this.name, this.gender,
								this.mobile, this.tel, this.email1, this.email2, this.interested, this.boxNum,
								this.model, this.buyCarTime, this.province, this.city, this.address, this.postcode,
								this.booking, this.dealerName, this.dealerCode, this.testDriveTime,
								this.hasDriveLicense, this.budgetCar, this.hasCarBrand, this.carTime, this.source,
								this.friContact, this.secContact, this.otherInterested, this.otherBrandPropaganda,
								this.eventCode, this.age, this.isMarry, this.background, this.industry, this.profession,
								this.income, this.memo1, this.memo2, this.memo3, this.memo4, this.memo5, this.memo6,
								this.memo7, this.memo8, this.memo9, this.memo10);
					} else {
						userdata = (M2FUserData) userdataList.get(0);
						this.status = userdata.getDid();
					}
				} else {
					this.status = -9L;
				}
			} else {
				this.status = -9L;
			}
		} catch (ActionAccessException ex) {
			log.error("", ex);
		} catch (Exception ex) {
			log.error("", ex);
			this.status = -99L;
		} catch (Throwable ex) {
			log.error("", ex);
			this.status = -99L;
		}
		try {
			String str = jsonp + "(" + "{\"status\":" + this.status + "}" + ")";
			this.response.setContentType("text/html;charset=UTF-8");
			this.response.getWriter().write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Action("saveDataJSONP")
	public void saveDataJSONP() {
		log.info("JS调用:接口参数saveDataJSONP: "+"createDate："+createDate+"name："+name+"gender："+gender+"mobile："+mobile+"tel："+tel+"email1："+email1+"email2："+email2+"interested："+interested+"boxNum："+boxNum+"model："
				+model+"buyCarTime："+buyCarTime+"province："+province+"city："+city+"address："+address+"postcode："+postcode+"booking："+booking+"dealerName："+dealerName+"dealerCode："+dealerCode+"testDriveTime："
				+testDriveTime+"hasDriveLicense："+hasDriveLicense+"budgetCar："+budgetCar+"hasCarBrand："+hasCarBrand+"carTime："+carTime+"source："+source+"friContact："+friContact+"secContact："+secContact+"otherInterested："+
				otherInterested+"otherBrandPropaganda："+otherBrandPropaganda+"eventCode："+eventCode+"age："+age+"isMarry："+isMarry+"background："+background+"industry："+industry+"profession："+profession+"income："+
				income+"memo1："+memo1+"memo2："+memo2+"memo3："+memo3+"memo4："+memo4+"memo5："+memo5+"memo6："+memo6+"memo7："+memo7+"memo8："+memo8+"memo9："+memo9+"memo10："+memo10);

		BaseResponse resp = new BaseResponse() ;
		if (this.request.getParameter("jsonpcallback") == null) {
			resp.setStatus(-10);
			resp.setData("");
			resp.setMessage("缺少参数:jsonpcallback!");
			String str = "jsonpcallback" + "(" + resp.toString() + ")";
			response.setContentType("text/javascript;charset=UTF-8");
			try {
				response.getWriter().write(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		String jsonp = this.request.getParameter("jsonpcallback").toString();
		try {
			resp = media2FordService.saveData(createDate, name, gender, mobile, tel, email1, email2, interested, boxNum,
					model, buyCarTime, province, city, address, postcode, booking, dealerName, dealerCode,
					testDriveTime, hasDriveLicense, budgetCar, hasCarBrand, carTime, source, friContact, secContact,
					otherInterested, otherBrandPropaganda, eventCode, age, isMarry, background, industry, profession,
					income, memo1, memo2, memo3, memo4, memo5, memo6, memo7, memo8, memo9, memo10);
			String str = jsonp + "(" + resp.toString() + ")";
			response.setContentType("text/javascript;charset=UTF-8");
			response.getWriter().write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Action(value = "saveData")
	public void saveData() {
		log.info("JS调用:接口参数saveData: "+"createDate："+createDate+"name："+name+"gender："+gender+"mobile："+mobile+"tel："+tel+"email1："+email1+"email2："+email2+"interested："+interested+"boxNum："+boxNum+"model："
				+model+"buyCarTime："+buyCarTime+"province："+province+"city："+city+"address："+address+"postcode："+postcode+"booking："+booking+"dealerName："+dealerName+"dealerCode："+dealerCode+"testDriveTime："
				+testDriveTime+"hasDriveLicense："+hasDriveLicense+"budgetCar："+budgetCar+"hasCarBrand："+hasCarBrand+"carTime："+carTime+"source："+source+"friContact："+friContact+"secContact："+secContact+"otherInterested："+
				otherInterested+"otherBrandPropaganda："+otherBrandPropaganda+"eventCode："+eventCode+"age："+age+"isMarry："+isMarry+"background："+background+"industry："+industry+"profession："+profession+"income："+
				income+"memo1："+memo1+"memo2："+memo2+"memo3："+memo3+"memo4："+memo4+"memo5："+memo5+"memo6："+memo6+"memo7："+memo7+"memo8："+memo8+"memo9："+memo9+"memo10："+memo10);

		BaseResponse resp;
		try {
			resp = media2FordService.saveData(createDate, name, gender, mobile, tel, email1, email2, interested, boxNum,
					model, buyCarTime, province, city, address, postcode, booking, dealerName, dealerCode,
					testDriveTime, hasDriveLicense, budgetCar, hasCarBrand, carTime, source, friContact, secContact,
					otherInterested, otherBrandPropaganda, eventCode, age, isMarry, background, industry, profession,
					income, memo1, memo2, memo3, memo4, memo5, memo6, memo7, memo8, memo9, memo10);

			response.setContentType("text/javascript;charset=UTF-8");
			response.getWriter().write(resp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private M2FUserData setM2FUserData() throws ActionAccessException {
		M2FUserData userdata = new M2FUserData();

		userdata.setEventcode(this.eventCode);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (this.createDate.trim().length() > 10) {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		try {
			userdata.setCreatedate(dateFormat.parse(this.createDate));
		} catch (Exception ex) {
			this.status = -1L;
			throw new ActionAccessException();
		}
		if (Utils.isNullorEmpty(this.name)) {
			this.status = -2L;
			throw new ActionAccessException();
		}
		userdata.setName(this.name);
		if (Utils.isNullorEmpty(this.gender)) {
			this.status = -3L;
			throw new ActionAccessException();
		}
		userdata.setGender(this.gender);
		if (!Utils.isMobileStr(this.mobile)) {
			this.status = -4L;
			throw new ActionAccessException();
		}
		userdata.setMobile(this.mobile);
		if (!Utils.isEmailStr(this.email1)) {
			this.status = -5L;
			throw new ActionAccessException();
		}
		userdata.setEmail1(this.email1);
		if (Utils.isNullorEmpty(this.buyCarTime)) {
			this.status = -6L;
			throw new ActionAccessException("");
		}
		userdata.setBuycartime(this.buyCarTime);
		if (Utils.isNullorEmpty(this.province)) {
			this.status = -7L;
			throw new ActionAccessException();
		}
		try {
			userdata.setProvince(new String(this.province.getBytes("UTF-8"), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			this.status = -99L;
			throw new ActionAccessException();
		}
		if (Utils.isNullorEmpty(this.city)) {
			this.status = -8L;
			throw new ActionAccessException();
		}
		userdata.setCity(this.city);

		userdata.setTel(this.tel);
		userdata.setEmail2(this.email2);
		userdata.setInterested(this.interested);

		userdata.setBoxnum(this.boxNum);
		userdata.setModel(this.model);
		userdata.setAddress(this.address);
		userdata.setPostcode(this.postcode);
		userdata.setBooking(this.booking);
		userdata.setDealername(this.dealerName);
		userdata.setDealercode(this.dealerCode);
		userdata.setTestdrivetime(this.testDriveTime);
		userdata.setHasdrivelicense(this.hasDriveLicense);
		userdata.setBudgetcar(this.budgetCar);
		userdata.setHascarbrand(this.hasCarBrand);
		userdata.setCartime(this.carTime);
		userdata.setSource(this.source);
		userdata.setFricontact(this.friContact);
		userdata.setSeccontact(this.secContact);
		userdata.setOtherinterested(this.otherInterested);
		userdata.setOtherbrandpropaganda(this.otherBrandPropaganda);
		userdata.setAge(this.age);
		userdata.setIsmarry(this.isMarry);
		userdata.setBackground(this.background);
		userdata.setIndustry(this.industry);
		userdata.setProfession(this.profession);
		userdata.setIncome(this.income);
		userdata.setMemo1(this.memo1);
		userdata.setMemo2(this.memo2);
		userdata.setMemo3(this.memo3);
		userdata.setMemo4(this.memo4);
		userdata.setMemo5(this.memo5);
		userdata.setMemo6(this.memo6);
		userdata.setMemo7(this.memo7);
		userdata.setMemo8(this.memo8);
		userdata.setMemo9(this.memo9);
		userdata.setMemo10(this.memo10);
		userdata.setFlag(1);

		return userdata;
	}

	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setInterested(String interested) {
		this.interested = interested;
	}

	public void setBoxNum(String boxNum) {
		this.boxNum = boxNum;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBuyCarTime(String buyCarTime) {
		this.buyCarTime = buyCarTime;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public void setTestDriveTime(String testDriveTime) {
		this.testDriveTime = testDriveTime;
	}

	public void setHasDriveLicense(String hasDriveLicense) {
		this.hasDriveLicense = hasDriveLicense;
	}

	public void setBudgetCar(String budgetCar) {
		this.budgetCar = budgetCar;
	}

	public void setHasCarBrand(String hasCarBrand) {
		this.hasCarBrand = hasCarBrand;
	}

	public void setCarTime(String carTime) {
		this.carTime = carTime;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setFriContact(String friContact) {
		this.friContact = friContact;
	}

	public void setSecContact(String secContact) {
		this.secContact = secContact;
	}

	public void setOtherInterested(String otherInterested) {
		this.otherInterested = otherInterested;
	}

	public void setOtherBrandPropaganda(String otherBrandPropaganda) {
		this.otherBrandPropaganda = otherBrandPropaganda;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setIsMarry(String isMarry) {
		this.isMarry = isMarry;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}

	public void setMemo5(String memo5) {
		this.memo5 = memo5;
	}

	public void setMemo6(String memo6) {
		this.memo6 = memo6;
	}

	public void setMemo7(String memo7) {
		this.memo7 = memo7;
	}

	public void setMemo8(String memo8) {
		this.memo8 = memo8;
	}

	public void setMemo9(String memo9) {
		this.memo9 = memo9;
	}

	public void setMemo10(String memo10) {
		this.memo10 = memo10;
	}
}
