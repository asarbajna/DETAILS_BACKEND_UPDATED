package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DAOUser;
import com.example.demo.entity.UserNewRegistration;


@Repository
public interface UserUpdatedRegRepo extends JpaRepository<UserNewRegistration,Long> {

	@Query(value = "SELECT * FROM user_new_registration WHERE email = ?1", nativeQuery = true)
	UserNewRegistration findByEmailAddress(String email);
	
	
	
	UserNewRegistration findByUserName(String userName);
}
