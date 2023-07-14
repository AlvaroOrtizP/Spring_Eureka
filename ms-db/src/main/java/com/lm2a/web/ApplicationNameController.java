package com.lm2a.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lm2a.config.DBConfig;

@RestController
@RequestMapping("/application-name")
public class ApplicationNameController {
	
	@Autowired
	private DBConfig config;
	
	@GetMapping
	public ResponseEntity<String> getAppName(){
		return ResponseEntity.ok(config.getApplicationName());
	}
	
	@GetMapping("/activa")
	public ResponseEntity<String> getFunctionality(){
		if(config.isFunctionalityActive()) {
			return ResponseEntity.ok("La funcionalidad esta activa");
		}else {
			return ResponseEntity.ok("La funcionalidad NO esta activa");
		}
	}

}
