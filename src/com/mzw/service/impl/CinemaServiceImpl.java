package com.mzw.service.impl;

import java.util.List;
import java.util.Map;

import com.mzw.dao.CinemaDao;
import com.mzw.dao.impl.CinemaDaoImpl;
import com.mzw.entity.Cinema;
import com.mzw.service.CinemaService;
import com.mzw.vo.VCinemaInfo;

public class CinemaServiceImpl implements CinemaService{
	CinemaDao cDao = new CinemaDaoImpl();

	@Override
	public void add(Cinema c) {
		// TODO Auto-generated method stub
		cDao.add(c);
	}

	@Override
	public void deleteCinemaById(Integer id) {
		// TODO Auto-generated method stub
		cDao.deleteCinemaById(id);
	}

	@Override
	public Cinema update(Cinema c) {
		// TODO Auto-generated method stub
		return cDao.update(c);
	}

	@Override
	public List<VCinemaInfo> findByCondition(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return cDao.findByConditation(map);
	}

}
