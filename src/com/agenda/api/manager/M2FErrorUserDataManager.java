package com.agenda.api.manager;

import java.util.List;

import com.agenda.api.entity.M2FErrorUserData;
import com.agenda.base.BaseManager;

public interface M2FErrorUserDataManager extends BaseManager<M2FErrorUserData> {
	public List<M2FErrorUserData> getM2FErrorUserDataByECodeMobile(String eventcode, String mobile) throws Exception;

}
