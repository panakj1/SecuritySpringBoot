package com.sepringsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sepringsecurity.config.JwtToken;
import com.sepringsecurity.model.JwtRequest;
import com.sepringsecurity.model.TokenResponse;
import com.sepringsecurity.service.CustomUserDetailsService;

@RestController
public class JwtTokenController {
	
	@Autowired
	JwtToken jwtToken;
	@Autowired
	CustomUserDetailsService  customUserDetailsService;
	@Autowired
	AuthenticationManager  authenticationManager;
	
	@PostMapping(value="/token")
	public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		 try{
			 this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getName(), jwtRequest.getPassword())); 
		 }catch(UsernameNotFoundException e) {
			 e.printStackTrace();
			 throw new Exception("Bad Request");
		 }
		UserDetails user= customUserDetailsService.loadUserByUsername(jwtRequest.getName()); 
		String token=jwtToken.generateToken(user);
		return ResponseEntity.ok(new TokenResponse(token));
	}

}
