package com.mzw.dao;

import java.util.List;


import com.mzw.entity.CinemaType;
import com.mzw.vo.VMenuInfo;
import com.mzw.vo.VTypeInfo;

public interface TypeDao {
	public List<VTypeInfo> findAll();
	
	public List<VMenuInfo> findMenu();
	
	public CinemaType findByName(String name);
	//根据分类等级获取商品
	public List<CinemaType> findTypeByLevel(int level);

}
