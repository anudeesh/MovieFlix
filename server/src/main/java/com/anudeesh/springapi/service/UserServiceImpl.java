package com.anudeesh.springapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anudeesh.springapi.exception.BadRequestException;
import com.anudeesh.springapi.exception.EntityNotFoundException;
import com.anudeesh.springapi.entity.User;
import com.anudeesh.springapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public User findUser(String id) {
		User user = repository.findOne(id,"user");
		if(user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public User findAdmin(String id) {
		User admin = repository.findOne(id,"admin");
		if(admin == null) {
			throw new EntityNotFoundException("Admin not found");
		}
		return admin;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null) {
			throw new BadRequestException("User already exists with the given email");
		}
		return repository.create(user);
	}

}
