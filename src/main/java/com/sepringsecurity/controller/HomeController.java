package com.sepringsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sepringsecurity.model.MenuCard;
import com.sepringsecurity.service.MenuCardService;
import com.sepringsecurityresponseVo.RequestMenuVo;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	MenuCardService   menuCardService;
	
	@GetMapping(value = "/menuCards")
	public ResponseEntity<List<MenuCard>> getAllMenuCardDetail(){
		List<MenuCard> list=menuCardService.getAllMenuCardDetails();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping(value="/getRecordById")
	public ResponseEntity<MenuCard> getRecord(@RequestBody RequestMenuVo menuVo) throws Exception{
		
		return new ResponseEntity<MenuCard>(menuCardService.getMenuID(menuVo.getMenuId()), HttpStatus.OK); 
	}

}
