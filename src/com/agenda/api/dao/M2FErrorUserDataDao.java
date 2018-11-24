package com.agenda.api.dao;

import java.util.List;

import com.agenda.api.entity.M2FErrorUserData;
import com.agenda.base.BaseDao;

public interface M2FErrorUserDataDao extends BaseDao<M2FErrorUserData> {
	public List<M2FErrorUserData> getM2FErrorUserDataByECodeMobile(String eventcode, String mobile) throws Exception;

}
