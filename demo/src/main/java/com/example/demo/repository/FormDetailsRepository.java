package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Formdetails;
@Repository
public interface FormDetailsRepository extends JpaRepository<Formdetails,Long>{
	
	@Query(value="select * from formdetails where form_type=?1 and user_name=?2",nativeQuery = true)
	List<Formdetails>findByFormTypeAndUser(String formtype,String username);
	@Modifying
	@Transactional
	@Query(value="update formdetails u set u.file_id = ?1,u.form_desc= ?2, u.form_type= ?3,u.file_name = ?4 where u.form_id = ?5",nativeQuery = true)
	void setUserInfoById(String fileid,String formdesc,String formtype,String filename,Long formid);
}
