package com.anudeesh.springapi.repository;

import com.anudeesh.springapi.entity.User;

public interface UserRepository {
	
	public User findOne(String id,String type);
//	public User findAdmin(String id);
	public User findByEmail(String email);
	public User create(User user);

}
