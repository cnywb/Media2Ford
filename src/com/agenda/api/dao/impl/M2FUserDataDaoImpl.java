package com.agenda.api.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.agenda.base.BaseDaoImpl;
import com.agenda.api.dao.M2FUserDataDao;
import com.agenda.api.entity.M2FUserData;

@Repository
public class M2FUserDataDaoImpl extends BaseDaoImpl<M2FUserData> implements M2FUserDataDao{

	public List<M2FUserData> getM2FUserDataByECodeMobile(String memo1,
			String mobile) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select b.* from m2f_userdata b where b.memo1='"+memo1+"' and mobile='"+mobile+"' and eventcode='1481528315862'" );
//		.append(" select ")
//		.append(" b.* ")
//		.append(" from m2f_userdata b where  ")
//		.append(" b.memo1 = '")
//		.append(memo1)
//		.append("' and mobile = '")
//		.append(mobile)
//		.append("' ")
//		.toString();
		return find(sql.toString(), M2FUserData.class);
	}
	public List<M2FUserData> getM2FUserDataByECodeMobile1(String memo9,
			String mobile) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select b.* from m2f_userdata b where b.memo9='"+memo9+"' and mobile='"+mobile+"' and eventcode='1481528315862'" );
//		.append(" select ")
//		.append(" b.* ")
//		.append(" from m2f_userdata b where  ")
//		.append(" b.memo9 = '")
//		.append(memo1)
//		.append("' and mobile = '")
//		.append(mobile)
//		.append("' ")
//		.toString();
		return find(sql.toString(), M2FUserData.class);
	}
	
}
