package com.online.retail.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.online.retail.store")
public class InventoryWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryWsApplication.class, args);
	}

}
