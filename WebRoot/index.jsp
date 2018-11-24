<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form id="form1" action="<%=path %>/media2FordData!CommitData.action" method="get">
    	createDate<input type="text" name="createDate" /><br/>
    	name<input type="text" name="name" /><br/>
    	gender<input type="text" name="gender" /><br/>
    	mobile<input type="text" name="mobile" /><br/>
    	tel<input type="text" name="tel" /><br/>
    	email1<input type="text" name="email1" /><br/>
    	email2<input type="text" name="email2" /><br/>
    	interested<input type="text" name="interested" /><br/>
    	boxNum<input type="text" name="boxNum" /><br/>
    	model<input type="text" name="model" /><br/>
    	buyCarTime<input type="text" name="buyCarTime" /><br/>
    	province<input type="text" name="province" /><br/>
    	city<input type="text" name="city" /><br/>
    	address<input type="text" name="address" /><br/>
    	postcode<input type="text" name="postcode" /><br/>
    	booking<input type="text" name="booking" /><br/>
    	dealerName<input type="text" name="dealerName" /><br/>
    	dealerCode<input type="text" name="dealerCode" /><br/>
    	testDriveTime<input type="text" name="testDriveTime" /><br/>
    	hasDriveLicense<input type="text" name="hasDriveLicense" /><br/>
    	budgetCar<input type="text" name="budgetCar" /><br/>
    	hasCarBrand<input type="text" name="hasCarBrand" /><br/>
    	carTime<input type="text" name="carTime" /><br/>
    	source<input type="text" name="source" /><br/>
    	friContact<input type="text" name="friContact" /><br/>
    	secContact<input type="text" name="secContact" /><br/>
    	otherInterested<input type="text" name="otherInterested" /><br/>
    	otherBrandPropaganda<input type="text" name="otherBrandPropaganda" /><br/>
    	eventCode<input type="text" name="eventCode" /><br/>
    	age<input type="text" name="age" /><br/>
    	isMarry<input type="text" name="isMarry" /><br/>
    	background<input type="text" name="background" /><br/>
    	industry<input type="text" name="industry" /><br/>
    	profession<input type="text" name="profession" /><br/>
    	income<input type="text" name="income" /><br/>
    	memo1<input type="text" name="memo1" /><br/>
    	memo2<input type="text" name="memo2" /><br/>
    	memo3<input type="text" name="memo3" /><br/>
    	memo4<input type="text" name="memo4" /><br/>
    	memo5<input type="text" name="memo5" /><br/>
    	memo6<input type="text" name="memo6" /><br/>
    	memo7<input type="text" name="memo7" /><br/>
    	memo8<input type="text" name="memo8" /><br/>
    	memo9<input type="text" name="memo9" /><br/>
    	memo10<input type="text" name="memo10" /><br/>
    	<input type="submit" value="submit" />
    </form>
  </body>
</html>
