package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DAOUser;
import com.example.demo.entity.Formdetails;
import com.example.demo.entity.UserNewRegistration;
import com.example.demo.model.FormdetailsModel;
import com.example.demo.repository.FormDetailsRepository;


@RestController
@CrossOrigin
@RequestMapping("/formDetails")
public class FormSubmitController {
	@Autowired
	private FormDetailsRepository formRepo;
	
	@PostMapping("/submit")
	public Formdetails insertFormDetails(@RequestBody FormdetailsModel details) {
		System.out.println("this is personal details upload file controller");
		Formdetails details1=new Formdetails();
		details1.setFormType(details.getFormType());
		details1.setFormDesc(details.getFormDesc());
		details1.setFileId(details.getFileId());
		details1.setUserName(details.getUserName());
		details1.setFileName(details.getFileName());
		return formRepo.save(details1);
		
		
	}
	@GetMapping(value="/gets/{formType}")
	@ResponseBody
	public List<Formdetails> getAllformDetails(@PathVariable String formType)
	{
		String[] splitted=formType.split("-");
		System.out.println(splitted[0]+"and"+splitted[1]);
		return formRepo.findByFormTypeAndUser(splitted[0],splitted[1]);
	}
	
	@PostMapping("/update")
	public void updateFormDetails(@RequestBody FormdetailsModel details) {
		System.out.println("this is personal details upload file controller");
		Formdetails details1=new Formdetails();
		details1.setFormId(details.getFormId());
		details1.setFormType(details.getFormType());
		details1.setFormDesc(details.getFormDesc());
		details1.setFileId(details.getFileId());
		details1.setUserName(details.getUserName());
		details1.setFileName(details.getFileName());
		formRepo.setUserInfoById(details.getFileId(), details.getFormDesc(), details.getFormType(), details.getFileName(), details.getFormId());
		
	}
}
