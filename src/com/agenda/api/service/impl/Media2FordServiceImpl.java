package com.agenda.api.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.agenda.api.entity.M2FEntrance;
import com.agenda.api.entity.M2FErrorUserData;
import com.agenda.api.entity.M2FUserData;
import com.agenda.api.exception.ActionAccessException;
import com.agenda.api.manager.M2FEntranceManager;
import com.agenda.api.manager.M2FErrorUserDataManager;
import com.agenda.api.manager.M2FUserDataManager;
import com.agenda.api.model.BaseResponse;
import com.agenda.api.service.Media2FordService;
import com.agenda.util.Utils;

@WebService(serviceName = "Media2FordData", endpointInterface = "com.agenda.api.service.Media2FordService")
public class Media2FordServiceImpl implements Media2FordService {
	private static final Logger log = LoggerFactory.getLogger(Media2FordServiceImpl.class);
	@Autowired
	private M2FUserDataManager m2fUserDataMng;
	@Autowired
	private M2FEntranceManager m2fEntranceMng;
	@Autowired
	private M2FErrorUserDataManager m2fErrorUserDataMng;

	List<M2FUserData> validateList=new ArrayList<M2FUserData>();
	
	public long CommitData(String createDate, String name, String gender, String mobile, String tel, String email1,
			String email2, String interested, String boxNum, String model, String buyCarTime, String province,
			String city, String address, String postcode, String booking, String dealerName, String dealerCode,
			String testDriveTime, String hasDriveLicense, String budgetCar, String hasCarBrand, String carTime,
			String source, String friContact, String secContact, String otherInterested, String otherBrandPropaganda,
			String eventCode, String age, String isMarry, String background, String industry, String profession,
			String income, String memo1, String memo2, String memo3, String memo4, String memo5, String memo6,
			String memo7, String memo8, String memo9, String memo10) {
		log.info("WSDL接口参数CommitData: "+"createDate："+createDate+"name："+name+"gender："+gender+"mobile："+mobile+"tel："+tel+"email1："+email1+"email2："+email2+"interested："+interested+"boxNum："+boxNum+"model："
				+model+"buyCarTime："+buyCarTime+"province："+province+"city："+city+"address："+address+"postcode："+postcode+"booking："+booking+"dealerName："+dealerName+"dealerCode："+dealerCode+"testDriveTime："
				+testDriveTime+"hasDriveLicense："+hasDriveLicense+"budgetCar："+budgetCar+"hasCarBrand："+hasCarBrand+"carTime："+carTime+"source："+source+"friContact："+friContact+"secContact："+secContact+"otherInterested："+
				otherInterested+"otherBrandPropaganda："+otherBrandPropaganda+"eventCode："+eventCode+"age："+age+"isMarry："+isMarry+"background："+background+"industry："+industry+"profession："+profession+"income："+
				income+"memo1："+memo1+"memo2："+memo2+"memo3："+memo3+"memo4："+memo4+"memo5："+memo5+"memo6："+memo6+"memo7："+memo7+"memo8："+memo8+"memo9："+memo9+"memo10："+memo10);
		M2FUserData userdata = new M2FUserData();
		StringBuffer errorCode = new StringBuffer("");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		validateList=new ArrayList<M2FUserData>();
		if (createDate.trim().length() > 10) {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		try {
			userdata.setTel(tel);
			userdata.setEmail2(email2);
			userdata.setInterested(interested);

			userdata.setBoxnum(boxNum);
			userdata.setModel(model);
			userdata.setAddress(address);
			userdata.setPostcode(postcode);
			userdata.setBooking(booking);
			userdata.setDealername(dealerName);
			userdata.setDealercode(dealerCode);
			userdata.setTestdrivetime(testDriveTime);
			userdata.setHasdrivelicense(hasDriveLicense);
			userdata.setBudgetcar(budgetCar);
			userdata.setHascarbrand(hasCarBrand);
			userdata.setCartime(carTime);
			userdata.setSource(source);
			userdata.setFricontact(friContact);
			userdata.setSeccontact(secContact);
			userdata.setOtherinterested(otherInterested);
			userdata.setOtherbrandpropaganda(otherBrandPropaganda);
			userdata.setAge(age);
			userdata.setIsmarry(isMarry);
			userdata.setBackground(background);
			userdata.setIndustry(industry);
			userdata.setProfession(profession);
			userdata.setIncome(income);
			userdata.setMemo3(memo3);
			userdata.setMemo4(memo4);
			userdata.setMemo5(memo5);
			userdata.setMemo6(memo6);
			userdata.setMemo7(memo7);
			userdata.setMemo8(memo8);
			userdata.setMemo9(memo9);
			userdata.setMemo10(memo10);
			userdata.setFlag(1);
			if (!Utils.isNullorEmpty(eventCode)) {
				userdata.setEventcode(eventCode);
				M2FEntrance m2fEntrance = (M2FEntrance) this.m2fEntranceMng.get(eventCode);
				if (m2fEntrance != null) {
					if (!Utils.isMobileStr(mobile)) {
						errorCode.append("-4,");
					} else if (Utils.isNullorEmpty(memo1)) {
						errorCode.append("-11,");
					} else {
						userdata.setMemo1(memo1);
						userdata.setMobile(mobile);
						try { 
							userdata.setCreatedate(dateFormat.parse(createDate));
						} catch (Exception ex) {
							errorCode.append("-1,");
						}
						if (Utils.isNullorEmpty(name)) {
							errorCode.append("-2,");
						} else {
							userdata.setName(name);
						}
						if (Utils.isNullorEmpty(gender)) {
							errorCode.append("-3,");
						} else {
							userdata.setGender(gender);
						}
						if (!Utils.isEmailStr(email1)) {
							errorCode.append("-5,");
						} else {
							userdata.setEmail1(email1);
						}
						if (Utils.isNullorEmpty(buyCarTime)) {
							errorCode.append("-6,");
						} else {
							userdata.setBuycartime(buyCarTime);
						}
						if (Utils.isNullorEmpty(province)) {
							errorCode.append("-7,");
						} else {
							userdata.setProvince(new String(province.getBytes("UTF-8"), "UTF-8"));
						}
						if (Utils.isNullorEmpty(city)) {
							errorCode.append("-8,");
						} else {
							userdata.setCity(city);
						}
						if (Utils.isNullorEmpty(memo2)) {
							errorCode.append("-12,");
						} else {
							userdata.setMemo2(memo2);
						}
					}

				} else {
					errorCode.append("-9,");
				}
			} else {
				errorCode.append("-9,");
			}
			if ("".equals(errorCode.toString())) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				userdata.setMemo4(df.format(new Date()));
				if(eventCode!=null && eventCode.equals("1481528315862")){
					if(memo9.equals("") || memo9==null){
						validateList = this.m2fUserDataMng.getM2FUserDataByECodeMobile(memo1, mobile);
					}else{
						validateList = this.m2fUserDataMng.getM2FUserDataByECodeMobile1(memo9, mobile);
					}
				}
				if (validateList == null || validateList.size() == 0) {
					userdata = (M2FUserData) this.m2fUserDataMng.save(userdata);
					return userdata.getDid();
				} else {
					errorCode.append("-13,");
				}
			}
			String[] errArray = errorCode.toString().split(",");
			M2FErrorUserData errorUserData = new M2FErrorUserData();
			errorUserData.setCreatedate(dateFormat.parse(createDate));
			errorUserData.setName(name);
			errorUserData.setGender(gender);
			errorUserData.setMobile(mobile);
			errorUserData.setEmail1(email1);
			errorUserData.setBuycartime(buyCarTime);
			errorUserData.setProvince(new String(province.getBytes("UTF-8"), "UTF-8"));
			errorUserData.setCity(city);
			errorUserData.setTel(tel);
			errorUserData.setEmail2(email2);
			errorUserData.setInterested(interested);
			errorUserData.setBoxnum(boxNum);
			errorUserData.setModel(model);
			errorUserData.setAddress(address);
			errorUserData.setPostcode(postcode);
			errorUserData.setBooking(booking);
			errorUserData.setDealername(dealerName);
			errorUserData.setDealercode(dealerCode);
			errorUserData.setTestdrivetime(testDriveTime);
			errorUserData.setHasdrivelicense(hasDriveLicense);
			errorUserData.setBudgetcar(budgetCar);
			errorUserData.setHascarbrand(hasCarBrand);
			errorUserData.setCartime(carTime);
			errorUserData.setSource(source);
			errorUserData.setFricontact(friContact);
			errorUserData.setSeccontact(secContact);
			errorUserData.setOtherinterested(otherInterested);
			errorUserData.setOtherbrandpropaganda(otherBrandPropaganda);
			errorUserData.setAge(age);
			errorUserData.setIsmarry(isMarry);
			errorUserData.setBackground(background);
			errorUserData.setIndustry(industry);
			errorUserData.setProfession(profession);
			errorUserData.setIncome(income);
			errorUserData.setMemo1(memo1);
			errorUserData.setMemo2(memo2);

			errorUserData.setMemo3(memo3);
			errorUserData.setMemo4(errorCode.toString());
			errorUserData.setMemo5(memo5);
			errorUserData.setMemo6(memo6);
			errorUserData.setMemo7(memo7);
			errorUserData.setMemo8(memo8);
			errorUserData.setMemo9(memo9);
			errorUserData.setMemo10(memo10);
			errorUserData.setFlag(1);

			errorUserData.setEventcode(eventCode);
			errorUserData.setMobile(mobile);

			errorUserData = (M2FErrorUserData) this.m2fErrorUserDataMng.save(errorUserData);
			String subCode = errArray[0];
			return Long.parseLong(subCode);
		} catch (ActionAccessException ex) {
			log.error("", ex);
			return -99L;
		} catch (Exception ex) {
			log.error("", ex);
			return -99L;
		} catch (Throwable ex) {
			log.error("", ex);
		}
		return -99L;

	}

	public BaseResponse saveData(String createDate, String name, String gender, String mobile, String tel,
			String email1, String email2, String interested, String boxNum, String model, String buyCarTime,
			String province, String city, String address, String postcode, String booking, String dealerName,
			String dealerCode, String testDriveTime, String hasDriveLicense, String budgetCar, String hasCarBrand,
			String carTime, String source, String friContact, String secContact, String otherInterested,
			String otherBrandPropaganda, String eventCode, String age, String isMarry, String background,
			String industry, String profession, String income, String memo1, String memo2, String memo3, String memo4,
			String memo5, String memo6, String memo7, String memo8, String memo9, String memo10) throws Exception {
			log.info("WSDL接口参数SaveData: "+"createDate："+createDate+"name："+name+"gender："+gender+"mobile："+mobile+"tel："+tel+"email1："+email1+"email2："+email2+"interested："+interested+"boxNum："+boxNum+"model："
				+model+"buyCarTime："+buyCarTime+"province："+province+"city："+city+"address："+address+"postcode："+postcode+"booking："+booking+"dealerName："+dealerName+"dealerCode："+dealerCode+"testDriveTime："
				+testDriveTime+"hasDriveLicense："+hasDriveLicense+"budgetCar："+budgetCar+"hasCarBrand："+hasCarBrand+"carTime："+carTime+"source："+source+"friContact："+friContact+"secContact："+secContact+"otherInterested："+
				otherInterested+"otherBrandPropaganda："+otherBrandPropaganda+"eventCode："+eventCode+"age："+age+"isMarry："+isMarry+"background："+background+"industry："+industry+"profession："+profession+"income："+
				income+"memo1："+memo1+"memo2："+memo2+"memo3："+memo3+"memo4："+memo4+"memo5："+memo5+"memo6："+memo6+"memo7："+memo7+"memo8："+memo8+"memo9："+memo9+"memo10："+memo10);
		BaseResponse res = saveNormalData(createDate, name, gender, mobile, tel, email1, email2, interested, boxNum,
				model, buyCarTime, province, city, address, postcode, booking, dealerName, dealerCode, testDriveTime,
				hasDriveLicense, budgetCar, hasCarBrand, carTime, source, friContact, secContact, otherInterested,
				otherBrandPropaganda, eventCode, age, isMarry, background, industry, profession, income, memo1, memo2,
				memo3, memo4, memo5, memo6, memo7, memo8, memo9, memo10);
		if (res.getStatus() == 0) {
			saveErrorData(createDate, name, gender, mobile, tel, email1, email2, interested, boxNum, model, buyCarTime,
					province, city, address, postcode, booking, dealerName, dealerCode, testDriveTime, hasDriveLicense,
					budgetCar, hasCarBrand, carTime, source, friContact, secContact, otherInterested,
					otherBrandPropaganda, eventCode, age, isMarry, background, industry, profession, income, memo1,
					memo2, memo3, memo5, memo6, memo7, memo8, memo9, memo10);
		}
		return res;
	}

	public BaseResponse saveNormalData(String createDate, String name, String gender, String mobile, String tel,
			String email1, String email2, String interested, String boxNum, String model, String buyCarTime,
			String province, String city, String address, String postcode, String booking, String dealerName,
			String dealerCode, String testDriveTime, String hasDriveLicense, String budgetCar, String hasCarBrand,
			String carTime, String source, String friContact, String secContact, String otherInterested,
			String otherBrandPropaganda, String eventCode, String age, String isMarry, String background,
			String industry, String profession, String income, String memo1, String memo2, String memo3, String memo4,
			String memo5, String memo6, String memo7, String memo8, String memo9, String memo10) throws Exception {

		BaseResponse res = new BaseResponse();
		validateList=new ArrayList<M2FUserData>();
		if (Utils.isNullorEmpty(createDate)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数createDate不能为空!");
			return res;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			dateFormat.parse(createDate);
		} catch (Exception ex) {
			res.setStatus(0);
			res.setMessage("操作失败!参数createDate非法!请用yyyy-MM-dd HH:mm:ss格式!");
			return res;
		}
		if (Utils.isNullorEmpty(eventCode)) {
			res.setStatus(0);
			res.setMessage("操作失败! 参数eventCode值不能为空!");
			return res;
		}
		if (!Utils.isMobileStr(mobile)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数mobile值非法!");
			return res;
		}

		if (Utils.isNullorEmpty(memo1)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数memo1不能为空!");
			return res;
		}

		if (Utils.isNullorEmpty(name)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数name不能为空!");
			return res;
		}

		if (Utils.isNullorEmpty(gender)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数gender不能为空!");
			return res;
		}

		if (!Utils.isEmailStr(email1)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数email1不能为空!");
			return res;
		}

		if (Utils.isNullorEmpty(buyCarTime)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数buyCarTime不能为空!");
			return res;
		}

		if (Utils.isNullorEmpty(province)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数province不能为空!");
			return res;
		}

		if (Utils.isNullorEmpty(city)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数city不能为空!");
			return res;
		}

		if (Utils.isNullorEmpty(memo2)) {
			res.setStatus(0);
			res.setMessage("操作失败!参数memo2不能为空!");
			return res;
		}

		M2FEntrance m2fEntrance = (M2FEntrance) this.m2fEntranceMng.get(eventCode);

		if (m2fEntrance == null) {
			res.setStatus(0);
			res.setMessage("操作失败!活动入口不存在!");
			return res;
		}

		M2FUserData userdata = new M2FUserData();
		userdata.setTel(tel);
		userdata.setEmail2(email2);
		userdata.setInterested(interested);
		userdata.setBoxnum(boxNum);
		userdata.setModel(model);
		userdata.setAddress(address);
		userdata.setPostcode(postcode);
		userdata.setBooking(booking);
		userdata.setDealername(dealerName);
		userdata.setDealercode(dealerCode);
		userdata.setTestdrivetime(testDriveTime);
		userdata.setHasdrivelicense(hasDriveLicense);
		userdata.setBudgetcar(budgetCar);
		userdata.setHascarbrand(hasCarBrand);
		userdata.setCartime(carTime);
		userdata.setSource(source);
		userdata.setFricontact(friContact);
		userdata.setSeccontact(secContact);
		userdata.setOtherinterested(otherInterested);
		userdata.setOtherbrandpropaganda(otherBrandPropaganda);
		userdata.setAge(age);
		userdata.setIsmarry(isMarry);
		userdata.setBackground(background);
		userdata.setIndustry(industry);
		userdata.setProfession(profession);
		userdata.setIncome(income);
		userdata.setMemo3(memo3);
		userdata.setMemo4(memo4);
		userdata.setMemo5(memo5);
		userdata.setMemo6(memo6);
		userdata.setMemo7(memo7);
		userdata.setMemo8(memo8);
		userdata.setMemo9(memo9);
		userdata.setMemo10(memo10);
		userdata.setFlag(1);
		userdata.setEventcode(eventCode);
		userdata.setMobile(mobile);
		userdata.setMemo1(memo1);
		userdata.setName(name);
		userdata.setGender(gender);
		userdata.setEmail1(email1);
		userdata.setBuycartime(buyCarTime);
		userdata.setCity(city);
		userdata.setMemo2(memo2);
		userdata.setCreatedate(dateFormat.parse(createDate));
		userdata.setProvince(new String(province.getBytes("UTF-8"), "UTF-8"));

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		userdata.setMemo4(df.format(new Date()));
		if(eventCode!=null && eventCode.equals("1481528315862")){
			if(memo9.equals("") || memo9==null){
				validateList = this.m2fUserDataMng.getM2FUserDataByECodeMobile(memo1, mobile);
			}else{
				validateList = this.m2fUserDataMng.getM2FUserDataByECodeMobile1(memo9, mobile);
			}
		}
		if (validateList == null || validateList.size() == 0) {
			userdata = (M2FUserData) this.m2fUserDataMng.save(userdata);

			res.setStatus(1);
			res.setData(userdata.getDid());
			res.setMessage("操作成功!");
		} else {
			res.setStatus(0);
			res.setMessage("本手机号已经参加当前活动!");
		}
		return res;
	}

	private void saveErrorData(String createDate, String name, String gender, String mobile, String tel, String email1,
			String email2, String interested, String boxNum, String model, String buyCarTime, String province,
			String city, String address, String postcode, String booking, String dealerName, String dealerCode,
			String testDriveTime, String hasDriveLicense, String budgetCar, String hasCarBrand, String carTime,
			String source, String friContact, String secContact, String otherInterested, String otherBrandPropaganda,
			String eventCode, String age, String isMarry, String background, String industry, String profession,
			String income, String memo1, String memo2, String memo3, String memo5, String memo6, String memo7,
			String memo8, String memo9, String memo10) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		StringBuffer errorCode = new StringBuffer();

		if (Utils.isNullorEmpty(eventCode)) {
			errorCode.append("-9,");
		}
		if (!Utils.isMobileStr(mobile)) {
			errorCode.append("-4,");
		} else if (Utils.isNullorEmpty(memo1)) {
			errorCode.append("-11,");
		}
		try {
			dateFormat.parse(createDate);
		} catch (Exception ex) {
			errorCode.append("-1,");
		}
		if (Utils.isNullorEmpty(name)) {
			errorCode.append("-2,");
		}
		if (Utils.isNullorEmpty(gender)) {
			errorCode.append("-3,");
		}
		if (!Utils.isEmailStr(email1)) {
			errorCode.append("-5,");
		}
		if (Utils.isNullorEmpty(buyCarTime)) {
			errorCode.append("-6,");
		}
		if (Utils.isNullorEmpty(province)) {
			errorCode.append("-7,");
		}
		if (Utils.isNullorEmpty(city)) {
			errorCode.append("-8,");
		}
		if (Utils.isNullorEmpty(memo2)) {
			errorCode.append("-12,");
		}
		M2FErrorUserData errorUserData = new M2FErrorUserData();

		if (Utils.isNullorEmpty(createDate)) {
			errorUserData.setCreatedate(new Date());
		} else {
			try {
				dateFormat.parse(createDate);
			} catch (Exception ex) {
				errorUserData.setCreatedate(new Date());
			}

		}

		errorUserData.setName(name);
		errorUserData.setGender(gender);
		errorUserData.setMobile(mobile);
		errorUserData.setEmail1(email1);
		errorUserData.setBuycartime(buyCarTime);
		errorUserData.setProvince(new String(province.getBytes("UTF-8"), "UTF-8"));
		errorUserData.setCity(city);
		errorUserData.setTel(tel);
		errorUserData.setEmail2(email2);
		errorUserData.setInterested(interested);
		errorUserData.setBoxnum(boxNum);
		errorUserData.setModel(model);
		errorUserData.setAddress(address);
		errorUserData.setPostcode(postcode);
		errorUserData.setBooking(booking);
		errorUserData.setDealername(dealerName);
		errorUserData.setDealercode(dealerCode);
		errorUserData.setTestdrivetime(testDriveTime);
		errorUserData.setHasdrivelicense(hasDriveLicense);
		errorUserData.setBudgetcar(budgetCar);
		errorUserData.setHascarbrand(hasCarBrand);
		errorUserData.setCartime(carTime);
		errorUserData.setSource(source);
		errorUserData.setFricontact(friContact);
		errorUserData.setSeccontact(secContact);
		errorUserData.setOtherinterested(otherInterested);
		errorUserData.setOtherbrandpropaganda(otherBrandPropaganda);
		errorUserData.setAge(age);
		errorUserData.setIsmarry(isMarry);
		errorUserData.setBackground(background);
		errorUserData.setIndustry(industry);
		errorUserData.setProfession(profession);
		errorUserData.setIncome(income);
		errorUserData.setMemo1(memo1);
		errorUserData.setMemo2(memo2);

		errorUserData.setMemo3(memo3);
		errorUserData.setMemo4(errorCode.toString());
		errorUserData.setMemo5(memo5);
		errorUserData.setMemo6(memo6);
		errorUserData.setMemo7(memo7);
		errorUserData.setMemo8(memo8);
		errorUserData.setMemo9(memo9);
		errorUserData.setMemo10(memo10);
		errorUserData.setFlag(1);

		errorUserData.setEventcode(eventCode);
		errorUserData.setMobile(mobile);
		errorUserData = (M2FErrorUserData) this.m2fErrorUserDataMng.save(errorUserData);
	}

	public String commit(String createDate, String name, String gender, String mobile, String tel, String email1,
			String email2, String interested, String boxNum, String model, String buyCarTime, String province,
			String city, String address, String postcode, String booking, String dealerName, String dealerCode,
			String testDriveTime, String hasDriveLicense, String budgetCar, String hasCarBrand, String carTime,
			String source, String friContact, String secContact, String otherInterested, String otherBrandPropaganda,
			String eventCode, String age, String isMarry, String background, String industry, String profession,
			String income, String memo1, String memo2, String memo3, String memo4, String memo5, String memo6,
			String memo7, String memo8, String memo9, String memo10) {

		try {
			return saveData(createDate, name, gender, mobile, tel, email1, email2, interested, boxNum, model,
					buyCarTime, province, city, address, postcode, booking, dealerName, dealerCode, testDriveTime,
					hasDriveLicense, budgetCar, hasCarBrand, carTime, source, friContact, secContact, otherInterested,
					otherBrandPropaganda, eventCode, age, isMarry, background, industry, profession, income, memo1,
					memo2, memo3, memo4, memo5, memo6, memo7, memo8, memo9, memo10).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseResponse resp = new BaseResponse();
			resp.setMessage(e.getMessage());
			resp.setStatus(0);
			return resp.toString();
		}
	}

}
