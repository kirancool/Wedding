package com.wedding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedding.meta.User;




@Service
public class LoginServiceImpl {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	public Boolean findLatestByUsername(String firstName, String password) {
		boolean status = true;
		User us=userServiceImpl.findLatestByUsername(firstName, password);
		if (us != null) {
		
			return status;
		}
		@SuppressWarnings("null")
		String username=us.getFirstName();
		String pass=us.getPassword();
		if(username.equals(firstName)&& pass.equals(password))
		{
			System.out.println("Login sucess");
		}else
		{
			System.out.println("Login fail");
		}
		return status;
		
	}
	
	
	

}
