package com.mzw.service;

import java.util.List;

import com.mzw.vo.VMenuInfo;
import com.mzw.vo.VTypeInfo;

public interface TypeService {
	public List<VTypeInfo> findAllType();
	
	public List<VMenuInfo> findMenuInfo();

}
