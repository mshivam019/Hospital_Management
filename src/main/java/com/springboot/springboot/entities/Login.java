package com.springboot.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userid;
	 private String username;
	 private String password;
	 
	 
	 public Login() {
	  super();
	  // TODO Auto-generated constructor stub
	 }
	 
	 public Login(String username, String password) {
	  super();
	  this.username = username;
	  this.password = password;
	 }
	 public String getUsername() {
	  return username;
	 }
	 public void setUsername(String username) {
	  this.username = username;
	 }
	 public String getPassword() {
	  return password;
	 }
	 public void setPassword(String password) {
	  this.password = password;
	 }
	 
	}
