package com.mzw.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mzw.dao.TypeDao;
import com.mzw.entity.CinemaType;
import com.mzw.utils.JdbcUtils;
import com.mzw.vo.VMenuInfo;
import com.mzw.vo.VTypeInfo;

public class TypeDaoImpl implements TypeDao{

	@Override
	public List<VTypeInfo> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from c_type";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		
		List<VTypeInfo> list = null;
		try {
			list = qRunner.query(sql, new BeanListHandler<>(VTypeInfo.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<VMenuInfo> findMenu() {
		// TODO Auto-generated method stub
		String sql = "select id,type from c_type";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		List<VMenuInfo> menuList = null;
		try {
			menuList = qRunner.query(sql, new BeanListHandler<>(VMenuInfo.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public CinemaType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CinemaType> findTypeByLevel(int level) {
		// TODO Auto-generated method stub
		String sql = "select * from c_type where type =?";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		List<CinemaType> list = null;
		try {
			list = qRunner.query(sql, new BeanListHandler<>(CinemaType.class));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		return list;
	}

}
