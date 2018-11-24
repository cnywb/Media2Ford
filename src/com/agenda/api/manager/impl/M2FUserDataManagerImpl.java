package com.agenda.api.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agenda.api.dao.M2FUserDataDao;
import com.agenda.api.entity.M2FUserData;
import com.agenda.api.manager.M2FUserDataManager;
import com.agenda.base.BaseManagerImpl;

@Service
@Transactional
public class M2FUserDataManagerImpl extends BaseManagerImpl<M2FUserData> implements M2FUserDataManager{

	protected M2FUserDataDao getDao() {		
		return (M2FUserDataDao)super.getDao();
	}

	@Autowired
	public void setDao(M2FUserDataDao dao) {		
		super.setDao(dao);
	}
	
	public List<M2FUserData> getM2FUserDataByECodeMobile(String memo1,
			String mobile) throws Exception {
		// TODO Auto-generated method stub
		return getDao().getM2FUserDataByECodeMobile(memo1, mobile);
	}
	
	public List<M2FUserData> getM2FUserDataByECodeMobile1(String memo9,String mobile) throws Exception {
		return getDao().getM2FUserDataByECodeMobile1(memo9, mobile);
	}
}
