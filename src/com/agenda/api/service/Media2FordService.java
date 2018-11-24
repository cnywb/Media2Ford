package com.agenda.api.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import com.agenda.api.model.BaseResponse;

@WebService(targetNamespace="www.agenda.com")
@SOAPBinding(style=SOAPBinding.Style.RPC, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.BARE)
public interface Media2FordService {
	
	@WebMethod
    @WebResult
    public long CommitData(@WebParam(name="createDate") String createDate, 
							@WebParam(name="name") String name, 
							@WebParam(name="gender") String gender,
							@WebParam(name="mobile") String mobile, 
							@WebParam(name="tel") String tel, 
							@WebParam(name="email1") String email1, 
							@WebParam(name="email2") String email2,
							@WebParam(name="interested") String interested, 
							@WebParam(name="boxNum") String boxNum, 
							@WebParam(name="model") String model, 
							@WebParam(name="buyCarTime") String buyCarTime,
							@WebParam(name="province") String province, 
							@WebParam(name="city") String city, 
							@WebParam(name="address") String address, 
							@WebParam(name="postcode") String postcode,
							@WebParam(name="booking") String booking, 
							@WebParam(name="dealerName") String dealerName, 
							@WebParam(name="dealerCode") String dealerCode,
							@WebParam(name="testDriveTime") String testDriveTime, 
							@WebParam(name="hasDriveLicense") String hasDriveLicense, 
							@WebParam(name="budgetCar") String budgetCar,
							@WebParam(name="hasCarBrand") String hasCarBrand, 
							@WebParam(name="carTime") String carTime, 
							@WebParam(name="source") String source,
							@WebParam(name="friContact") String friContact, 
							@WebParam(name="secContact") String secContact, 
							@WebParam(name="otherInterested") String otherInterested,
							@WebParam(name="otherBrandPropaganda") String otherBrandPropaganda, 
							@WebParam(name="eventCode") String eventCode, 
							@WebParam(name="age") String age,
							@WebParam(name="isMarry") String isMarry, 
							@WebParam(name="background") String background, 
							@WebParam(name="industry") String industry,
							@WebParam(name="profession") String profession, 
							@WebParam(name="income") String income, 
							@WebParam(name="memo1") String memo1, 
							@WebParam(name="memo2") String memo2,
							@WebParam(name="memo3") String memo3, 
							@WebParam(name="memo4") String memo4, 
							@WebParam(name="memo5") String memo5, 
							@WebParam(name="memo6") String memo6,
							@WebParam(name="memo7") String memo7, 
							@WebParam(name="memo8") String memo8, 
							@WebParam(name="memo9") String memo9, 
							@WebParam(name="memo10") String memo10);
	
	
	
	@WebMethod
    @WebResult
    public String commit(@WebParam(name="createDate") String createDate, 
							@WebParam(name="name") String name, 
							@WebParam(name="gender") String gender,
							@WebParam(name="mobile") String mobile, 
							@WebParam(name="tel") String tel, 
							@WebParam(name="email1") String email1, 
							@WebParam(name="email2") String email2,
							@WebParam(name="interested") String interested, 
							@WebParam(name="boxNum") String boxNum, 
							@WebParam(name="model") String model, 
							@WebParam(name="buyCarTime") String buyCarTime,
							@WebParam(name="province") String province, 
							@WebParam(name="city") String city, 
							@WebParam(name="address") String address, 
							@WebParam(name="postcode") String postcode,
							@WebParam(name="booking") String booking, 
							@WebParam(name="dealerName") String dealerName, 
							@WebParam(name="dealerCode") String dealerCode,
							@WebParam(name="testDriveTime") String testDriveTime, 
							@WebParam(name="hasDriveLicense") String hasDriveLicense, 
							@WebParam(name="budgetCar") String budgetCar,
							@WebParam(name="hasCarBrand") String hasCarBrand, 
							@WebParam(name="carTime") String carTime, 
							@WebParam(name="source") String source,
							@WebParam(name="friContact") String friContact, 
							@WebParam(name="secContact") String secContact, 
							@WebParam(name="otherInterested") String otherInterested,
							@WebParam(name="otherBrandPropaganda") String otherBrandPropaganda, 
							@WebParam(name="eventCode") String eventCode, 
							@WebParam(name="age") String age,
							@WebParam(name="isMarry") String isMarry, 
							@WebParam(name="background") String background, 
							@WebParam(name="industry") String industry,
							@WebParam(name="profession") String profession, 
							@WebParam(name="income") String income, 
							@WebParam(name="memo1") String memo1, 
							@WebParam(name="memo2") String memo2,
							@WebParam(name="memo3") String memo3, 
							@WebParam(name="memo4") String memo4, 
							@WebParam(name="memo5") String memo5, 
							@WebParam(name="memo6") String memo6,
							@WebParam(name="memo7") String memo7, 
							@WebParam(name="memo8") String memo8, 
							@WebParam(name="memo9") String memo9, 
							@WebParam(name="memo10") String memo10);
	
	  public BaseResponse saveData(String createDate, String name, String gender, String mobile, String tel, String email1, String email2, String interested, String boxNum, String model, String buyCarTime, String province, String city, String address, String postcode, String booking, String dealerName, String dealerCode, String testDriveTime, String hasDriveLicense, String budgetCar, String hasCarBrand, String carTime, String source, String friContact, String secContact, String otherInterested, String otherBrandPropaganda, String eventCode, String age, String isMarry, String background, String industry, String profession, String income, String memo1, String memo2, String memo3, String memo4, String memo5, String memo6, String memo7, String memo8, String memo9, String memo10) throws Exception;
	
}
