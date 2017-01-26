package com.anudeesh.springapi.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name="User.findOne",query="SELECT u from User u WHERE u.id=:uID AND u.role=:uType"),
		@NamedQuery(name="User.findByEmail",query="SELECT u from User u WHERE u.email=:pEmail")
})
public class User {
	
	@Id
	private String id;
	@Column(unique=true)
	private String email;
	private String name;
	private String password;
	private String role;
	
	public User() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	

}
