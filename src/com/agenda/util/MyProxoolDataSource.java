package com.agenda.util;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 此类主要是为了对配置文件中的数据库连接密码进行解密操作而继承的数据库连接池类
 * @author xuw
 *
 */
public class MyProxoolDataSource extends ProxoolDataSource {
	
	private static Logger log = LoggerFactory.getLogger(MyProxoolDataSource.class); 

	@Override
	public void setPassword(String password) {
		try {
			log.info("connection database");
			password = Encrypt.decryptString(Encrypt.ENCRY_STYLE_DES, password);
			super.setPassword(password);
		} catch (Exception exception) {
			log.error("",exception);
		}
	}
}
