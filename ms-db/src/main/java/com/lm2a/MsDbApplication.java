package com.lm2a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDbApplication.class, args);
	}

}
