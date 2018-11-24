package com.agenda.api.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agenda.api.dao.M2FErrorUserDataDao;
import com.agenda.api.entity.M2FErrorUserData;
import com.agenda.api.manager.M2FErrorUserDataManager;
import com.agenda.base.BaseManagerImpl;

@Service
@Transactional
public class M2FErrorUserDataManagerImpl extends BaseManagerImpl<M2FErrorUserData> implements M2FErrorUserDataManager {

	protected M2FErrorUserDataDao getDao() {		
		return (M2FErrorUserDataDao)super.getDao();
	}

	@Autowired
	public void setDao(M2FErrorUserDataDao dao) {		
		super.setDao(dao);
	}
	
	public List<M2FErrorUserData> getM2FErrorUserDataByECodeMobile(
			String eventcode, String mobile) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
