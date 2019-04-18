package com.mzw.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mzw.dao.UserDao;
import com.mzw.entity.Cinema;

import com.mzw.entity.User;
import com.mzw.utils.JdbcUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		
				String sql = "select * from c_user where name=?";
				QueryRunner qr = JdbcUtils.getQueryRunner();
				User user = null;
				try {
					user = qr.query(sql, new BeanHandler<>(User.class),name);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return user;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into c_user values(null,?,?)";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		Object[] params = new Object[] {
				user.getName(),
				user.getPassword()
		};
		try {
			qRunner.update(sql,params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Cinema> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from c_info";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		
		List<Cinema> list = null;
		try {
			list = qRunner.query(sql,new BeanListHandler<>(Cinema.class));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return list;
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		String sql ="delete from c_user where id =?";
		QueryRunner qRunner = JdbcUtils.getQueryRunner();
		try {
			qRunner.update(sql,id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
