package com.mzw.service;

import java.util.List;

import com.mzw.entity.Cinema;
import com.mzw.entity.User;

public interface UserService {
	public User login(String name,String password);
	
	public List<Cinema> findAll();
	
	public void register(User user);

}
