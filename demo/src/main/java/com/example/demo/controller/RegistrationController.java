package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.UserRegistrationRepo;
import com.example.demo.service.CSVUserService;
import com.example.demo.entity.*;
import com.example.demo.helper.CSVHelper;
import com.example.demo.model.ResponseMessage;

@CrossOrigin
//(origins = "http://localhost:4200")
@RestController
@RequestMapping("/test/")
public class RegistrationController {
@Autowired
private UserRegistrationRepo userRegistrationRepo;
@Autowired
CSVUserService csvUserService;

/* get list of users */
//@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/userdata")
public List<UserRegistration> getAllUserData()
{
	return userRegistrationRepo.findAll();
}
/* insert/create users */
@PostMapping("/createuser")
public UserRegistration createUsers(@RequestBody UserRegistration user) {
	return userRegistrationRepo.save(user);
	
}

@PostMapping("/upload")
public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
  String message = "";
  if (CSVHelper.hasCSVFormat(file)) {
	  System.out.println("file is : "+file);
    try {
      csvUserService.save(file);
      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  message = "Please upload a csv file!";
  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
}

}

