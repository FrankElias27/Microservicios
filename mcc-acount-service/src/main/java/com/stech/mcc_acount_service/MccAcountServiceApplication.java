package com.stech.mcc_acount_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MccAcountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MccAcountServiceApplication.class, args);
	}

}
