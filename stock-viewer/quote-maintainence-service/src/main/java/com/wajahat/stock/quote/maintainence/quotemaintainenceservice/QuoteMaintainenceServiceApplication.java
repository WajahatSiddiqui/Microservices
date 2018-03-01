package com.wajahat.stock.quote.maintainence.quotemaintainenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QuoteMaintainenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteMaintainenceServiceApplication.class, args);
	}
}
