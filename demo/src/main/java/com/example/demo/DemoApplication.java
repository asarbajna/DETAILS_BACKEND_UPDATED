package com.example.demo;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPattern;

import com.example.demo.entity.UserNewRegistration;
import com.example.demo.service.FilesStorageService;
@SpringBootApplication
public class DemoApplication  {
	@Bean
	public  WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedHeaders("*").allowedOriginPatterns("*").allowCredentials(true);	   
	        }
		};
	}
	@Resource
	FilesStorageService storageService;
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	UserNewRegistration  userNewRegistration() {
		return new UserNewRegistration();
	}
	@Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //factory.setMaxFileSize(DataSize.ofMegabytes(5));
        //factory.setMaxRequestSize(DataSize.ofMegabytes(5));
        return factory.createMultipartConfig();
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	 //@Override
	public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
}
