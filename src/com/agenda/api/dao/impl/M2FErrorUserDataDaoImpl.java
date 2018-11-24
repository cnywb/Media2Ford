package com.agenda.api.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.agenda.api.dao.M2FErrorUserDataDao;

import com.agenda.api.entity.M2FErrorUserData;
import com.agenda.base.BaseDaoImpl;

@Repository
public class M2FErrorUserDataDaoImpl extends BaseDaoImpl<M2FErrorUserData> implements M2FErrorUserDataDao{

	public List<M2FErrorUserData> getM2FErrorUserDataByECodeMobile(
			String eventcode, String mobile) throws Exception {
		String sql = new StringBuffer()
		.append(" select ")
		.append(" b.* ")
		.append(" from m2f_error_userdata b where  ")
		.append(" b.eventcode = '")
		.append(eventcode)
		.append("' and mobile = '")
		.append(mobile)
		.append("' ")
		.toString();
		return find(sql, M2FErrorUserData.class);
	}



}
