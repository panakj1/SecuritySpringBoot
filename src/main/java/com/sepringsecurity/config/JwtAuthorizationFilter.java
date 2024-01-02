package com.sepringsecurity.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sepringsecurity.service.CustomUserDetailsService;


@Component
//Autanitication
public class JwtAuthorizationFilter extends OncePerRequestFilter{

	@Autowired
	 private JwtToken jwtToken;
	@Autowired
	CustomUserDetailsService  CustomUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationToken=request.getHeader("Authorization");
		System.out.println(authorizationToken+"---------");
		String userName=null;
		String jwtToken=null;
		if(authorizationToken !=null && authorizationToken.startsWith("Bearer ")) {
			jwtToken=authorizationToken.substring(7);
			try {
				userName=this.jwtToken.extractUsername(jwtToken);
			}catch(Exception e) {
				
			}
			System.out.println("userName-----"+userName+"----"+jwtToken);
			UserDetails userdetails=this.CustomUserDetailsService.loadUserByUsername(userName);
			if(userName !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UsernamePasswordAuthenticationToken upToken=new UsernamePasswordAuthenticationToken(userdetails,null, userdetails.getAuthorities());
				upToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upToken);
			}
			
		}	
		filterChain.doFilter(request, response);
	}

}
