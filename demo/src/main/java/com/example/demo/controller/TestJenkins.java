package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jenkins/")
public class TestJenkins {
	@GetMapping("/test")
	public String hello()
	{
		return "hello, you jenkins ci cd works!";
	}
}
