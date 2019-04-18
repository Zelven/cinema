package com.mzw.dao;



import java.util.List;
import java.util.Map;

import com.mzw.entity.Cinema;
import com.mzw.vo.VCinemaInfo;


public interface CinemaDao {
	public void add(Cinema c);
	public void deleteCinemaById(Integer id);
	
	public Cinema update(Cinema c);
	
	public List<VCinemaInfo> findByConditation(Map<String, String[]>map);

}
