package com.customer.online.retail.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.customer.online.retail.store")
@EnableFeignClients("com.customer.online.retail.store")
public class CustomerWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerWsApplication.class, args);
	}

}
