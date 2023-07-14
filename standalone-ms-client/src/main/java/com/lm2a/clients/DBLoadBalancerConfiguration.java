package com.lm2a.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBLoadBalancerConfiguration {
	private static final Logger log = LoggerFactory.getLogger(DBLoadBalancerConfiguration.class);

	@Bean
	public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(ConfigurableApplicationContext context ) {
		log.info("Configurando el load balancer para balanceo de carga");
		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient()
				.withSameInstancePreference().build(context);
	}
}
