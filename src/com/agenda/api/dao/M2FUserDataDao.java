package com.agenda.api.dao;

import java.util.List;

import com.agenda.base.BaseDao;
import com.agenda.api.entity.M2FUserData;

public interface M2FUserDataDao extends BaseDao<M2FUserData>{
	
	public List<M2FUserData> getM2FUserDataByECodeMobile(String eventcode, String mobile) throws Exception;
	public List<M2FUserData> getM2FUserDataByECodeMobile1(String eventcode, String mobile) throws Exception;
}