package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserRegistration;
import com.example.demo.service.UserInfoService;
import com.example.demo.utility.PDFGeneratorUserInfo;
import com.lowagie.text.DocumentException;

@RestController
@CrossOrigin
@RequestMapping("/pdf")
public class PdfController {
	

	 @Autowired
	 private UserInfoService userInfoService;
	 @GetMapping("/download")
	 public void generator(HttpServletResponse response) throws DocumentException, IOException {
	  response.setContentType("application/pdf");
	  DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	  String currentDateTime = dateFormat.format(new Date());
	  String headerkey = "Content-Disposition";
	  String headervalue = "attachment; filename=pdf_"+currentDateTime+".pdf";
	  response.setHeader(headerkey, headervalue);
	  List<UserRegistration> userList = userInfoService.getAllUser();
	  PDFGeneratorUserInfo generetorUser = new PDFGeneratorUserInfo();
	  generetorUser.setUserInfo(userList);
	  generetorUser.generate(response);
}
}
