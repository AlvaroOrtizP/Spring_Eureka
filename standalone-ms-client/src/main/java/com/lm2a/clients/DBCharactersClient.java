package com.lm2a.clients;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="db")
//valanceo de carga
@LoadBalancerClient(name="db", configuration =DBLoadBalancerConfiguration.class)
public interface DBCharactersClient {
	
	@GetMapping("/application-name")
	public ResponseEntity<String> getAppName();
	
	@GetMapping("/api/v1/dragonball/characters")
	public ResponseEntity<List<String>> getCharactersDB();

}
