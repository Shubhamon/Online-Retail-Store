package com.wipro.cart.online.retail.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CartWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartWsApplication.class, args);
	}

}
