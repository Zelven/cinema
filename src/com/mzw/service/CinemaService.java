package com.mzw.service;

import java.util.List;
import java.util.Map;

import com.mzw.entity.Cinema;
import com.mzw.vo.VCinemaInfo;

public interface CinemaService {
	public void add(Cinema c);
	public void deleteCinemaById(Integer id);
	
	public Cinema update(Cinema c);
	
	public List<VCinemaInfo> findByCondition(Map<String, String[]>map);

}
