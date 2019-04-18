package com.mzw.service.impl;

import java.util.List;

import com.mzw.dao.UserDao;
import com.mzw.dao.impl.UserDaoImpl;
import com.mzw.entity.Cinema;
import com.mzw.entity.User;
import com.mzw.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		User user = userDao.findByName(name);
		if (user == null) {
			throw new RuntimeException("用户不存在");
			
		}
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("密码错误");
		}

		return user;
	}
	@Override
	public List<Cinema> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
	}

}
