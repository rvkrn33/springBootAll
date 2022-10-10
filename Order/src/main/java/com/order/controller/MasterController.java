package com.order.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.model.ConfigInfo;
import com.order.model.DatabaseInfo;
import com.order.model.Master;
import com.order.model.Models;

@RestController
public class MasterController {
	
	@PostMapping("/api/mapping")
	public ResponseEntity<String> mapping(@RequestBody Master master){
		try {
			System.out.println(">>>>>>>>>>>  "+master.getName());
			
			DatabaseInfo info=master.getDbInfo();
			System.out.println("*************  "+info.getH2());
			
		}catch(Exception e) {
			e.printStackTrace();
			e.toString();
		}
		
return new ResponseEntity("done",HttpStatus.OK);
	}
	
}
