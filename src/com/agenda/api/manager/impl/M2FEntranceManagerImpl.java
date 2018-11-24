package com.agenda.api.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agenda.api.dao.M2FEntranceDao;
import com.agenda.api.entity.M2FEntrance;
import com.agenda.api.manager.M2FEntranceManager;
import com.agenda.base.BaseManagerImpl;

@Service
@Transactional
public class M2FEntranceManagerImpl extends BaseManagerImpl<M2FEntrance> implements M2FEntranceManager{

	protected M2FEntranceDao getDao() {		
		return (M2FEntranceDao)super.getDao();
	}

	@Autowired
	public void setDao(M2FEntranceDao dao) {		
		super.setDao(dao);
	}
}
