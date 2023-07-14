package com.lm2a;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import com.lm2a.clients.DBCharactersClient;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableFeignClients
public class ApiRestMsClientApplication implements ApplicationRunner{
	
	private static final Logger log = LoggerFactory.getLogger(ApiRestMsClientApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ApiRestMsClientApplication.class, args);
	}

	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DBCharactersClient dbCharactersClient;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		ResponseEntity<List<String>> charactersDB = dbCharactersClient.getCharactersDB();
		log.info("Personajes DB:");
		charactersDB.getBody().stream().forEach(ch -> log.info(ch));
		
	}

}
