package com.mzw.dao;

import java.util.List;

import com.mzw.entity.Cinema;
import com.mzw.entity.User;

public interface UserDao {
	public User findByName(String name);
	
	public void add(User user);
	
	public List<Cinema> findAll();
	
	public void deleteUserById(Integer id);

}
