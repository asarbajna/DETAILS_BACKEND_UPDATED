package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DAOUser;
import com.example.demo.entity.UserNewRegistration;
import com.example.demo.repository.UserUpdatedRegRepo;

@CrossOrigin
@RestController
@RequestMapping("/user/")
public class UserRegistrationController {

	@Autowired
	private UserUpdatedRegRepo repo;
	//@Autowired
	//UserNewRegistration Enuser;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@GetMapping(value="/email/{email}")
	@ResponseBody
	public UserNewRegistration getByEmail(@PathVariable String email) {
		UserNewRegistration emailadd=repo.findByEmailAddress(email);
		
	    return emailadd;
	}
	@GetMapping(value="/user/{username}")
	@ResponseBody
	public UserNewRegistration getByUserName(@PathVariable String username) {
		UserNewRegistration user=repo.findByUserName(username);
		
	    return user;
	}
	
	
	@GetMapping("/getreguser")
	public List<UserNewRegistration> getAllUserData()
	{
		return repo.findAll();
	}
	/* insert/create users */
	@PostMapping("/reguser")
	public UserNewRegistration createeUsers(@RequestBody DAOUser user) {
	UserNewRegistration Enuser=new UserNewRegistration();
	Enuser.setUserName(user.getUserName());
	Enuser.setFullName(user.getFullName());
	Enuser.setEmail(user.getEmail());
	Enuser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return repo.save(Enuser);
		
	}
}
