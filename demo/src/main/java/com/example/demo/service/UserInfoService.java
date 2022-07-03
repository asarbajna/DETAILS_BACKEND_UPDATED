package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRegistration;
import com.example.demo.repository.UserRegistrationRepo;

@Service
public class UserInfoService {
	@Autowired
	private UserRegistrationRepo userRegRepo;
	
	 public List<UserRegistration> getAllUser(){
		  return userRegRepo.findAll();
		 }

}
