package com.mzw.service.impl;

import java.util.List;

import com.mzw.dao.TypeDao;
import com.mzw.dao.impl.TypeDaoImpl;
import com.mzw.service.TypeService;
import com.mzw.vo.VMenuInfo;
import com.mzw.vo.VTypeInfo;

public class TypeServiceImpl implements TypeService{
	private TypeDao typeDao = new TypeDaoImpl();

	@Override
	public List<VTypeInfo> findAllType() {
		// TODO Auto-generated method stub
		return typeDao.findAll();
	}

	@Override
	public List<VMenuInfo> findMenuInfo() {
		// TODO Auto-generated method stub
		return typeDao.findMenu();
	}

}
