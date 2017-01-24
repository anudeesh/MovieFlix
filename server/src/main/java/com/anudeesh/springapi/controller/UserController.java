package com.anudeesh.springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anudeesh.springapi.entity.User;
import com.anudeesh.springapi.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User findUser(@PathVariable("id") String uid) {
		return service.findUser(uid);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin/{id}")
	public User findAdmin(@PathVariable("id") String aid) {
		return service.findAdmin(aid);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public User create(@RequestBody User user) {
		return service.create(user);
	}
}
