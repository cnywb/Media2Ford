package com.agenda.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	public static boolean isNullorEmpty(String str){
		if (str == null) {
			return true;
		} else if (str.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isNumeric (String str) {
		return (str != null) ? Utils.isStr("^[+-]?\\d*[.]?\\d*$", str) : false;
	}
	
	public static boolean isEmailStr (String str) {
		return (str != null) ? Utils.isStr("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$", str) : false;
	}
	
	public static boolean isMobileStr (String str) {
		return (str != null) ? Utils.isStr("^(12|13|14|15|16|17|18)[0-9]{9}$", str) : false;
	}
	
	public static boolean isTelStr (String str) {
		return (str != null) ? Utils.isStr("^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$", str) : false;
	}
	
	public static boolean isPostCodeStr(String str) {
		return (str != null) ? Utils.isStr("^\\d{6}$", str) : false;
	}
	
	private static boolean isStr(String regex, String str) {
		Pattern p = null;
		Matcher m = null;
		p = Pattern.compile(regex);
		m = p.matcher(str);
		return m.find();
	}
	
}
