package com.wedding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.dao.IUserDao;
import com.wedding.meta.User;
@Service
public class UserServiceImpl {
	@Autowired
	IUserDao iUserDao;
	public User findLatestByUsername(String firstName, String password) {
		
		return iUserDao.findLatestByUsername(firstName, password);
	}

}
