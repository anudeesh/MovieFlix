package com.anudeesh.springapi.service;


import com.anudeesh.springapi.entity.User;

public interface UserService {
	
	public User findUser(String id);
	public User findAdmin(String id);
	public User create(User user);
}
