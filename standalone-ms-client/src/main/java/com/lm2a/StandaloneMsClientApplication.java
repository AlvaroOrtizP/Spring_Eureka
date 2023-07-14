package com.lm2a;

import java.util.List;
import java.util.Objects;

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
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@SpringBootApplication
@EnableFeignClients
public class StandaloneMsClientApplication implements ApplicationRunner{

	private static final Logger log = LoggerFactory.getLogger(StandaloneMsClientApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StandaloneMsClientApplication.class, args);
	}

	@Autowired
	private EurekaClient eurekaClient;
	
	
// Extraer datos de los MS desde Eureka	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		Application application = eurekaClient.getApplication("db");
//		log.info("Application name {}", application.getName());
//		
//		List<InstanceInfo> instances = application.getInstances();
//		
//		for(InstanceInfo ii: instances) {
//			log.info("Direccion IP {}:{}", ii.getIPAddr(), ii.getPort());
//		}
//		log.info("xxxxxx");
//	}
	
	@Autowired
	private DBCharactersClient dbCharactersClient;
	
	
//Conectar con el MS (nombre)
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		ResponseEntity<String> appName = dbCharactersClient.getAppName();
//		log.info("Status code {}", appName.getStatusCode());
//		String body = appName.getBody();
//		log.info("Body {}", body);
//	}
	
//Conectar con el MS (characters)	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		ResponseEntity<List<String>> charactersDB = dbCharactersClient.getCharactersDB();
		log.info("Personajes DB:");
		charactersDB.getBody().stream().forEach(ch -> log.info(ch));
		}

}
