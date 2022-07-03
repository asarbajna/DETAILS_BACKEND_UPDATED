package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable  {

	private static final long serialVersionUID = -7858869558953243875L;
	private static final Logger logger = Logger.getLogger(JwtAuthenticationEntryPoint.class.getName());

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized access!,access denied");
		logger.info("Responding with unauthorized error. Message - {}"+authException.getMessage());
		
	}

}
