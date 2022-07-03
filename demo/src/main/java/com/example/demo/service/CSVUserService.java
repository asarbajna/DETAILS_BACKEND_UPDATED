package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.UserRegistration;
import com.example.demo.helper.CSVUserHelper;
import com.example.demo.model.UserRegistrationModel;
import com.example.demo.repository.UserRegistrationRepo;

@Service
public class CSVUserService {
  @Autowired
  UserRegistrationRepo repository;
 
  public void save(MultipartFile file) {
    try {
    	System.out.println("file is: "+file);
      List<UserRegistrationModel> user = CSVUserHelper.csvToTutorials(file.getInputStream());
      //REPO
      System.out.println("user is: "+user);
      //UserRegistration userEntity = new UserRegistration();
      for(UserRegistrationModel userReg: user) {
    	  UserRegistration userEntity = new UserRegistration();
    	  userEntity.setUserId(userReg.getUserId());
    	  userEntity.setEmail(userReg.getEmail());
    	  userEntity.setFirstName(userReg.getFirstName());
    	  userEntity.setLastName(userReg.getLastName());
    	  System.out.println("user id is : "+userReg.getUserId());
    	  repository.save(userEntity);
      }
      //repository.saveAll(user);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
 /* public List<UserRegistrationModel> getAllTutorials() {
    return repository.findAll();
  } */
}
