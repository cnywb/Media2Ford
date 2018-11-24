package com.agenda.api.manager;

import java.util.List;

import com.agenda.api.entity.M2FUserData;
import com.agenda.base.BaseManager;

public interface M2FUserDataManager extends BaseManager<M2FUserData>{

	public List<M2FUserData> getM2FUserDataByECodeMobile(String memo1, String mobile) throws Exception;
	public List<M2FUserData> getM2FUserDataByECodeMobile1(String memo9, String mobile) throws Exception;
}
