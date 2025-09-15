package com.tcg.roles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tcg.commons.feign")
public class MsvRolesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvRolesApplication.class, args);
	}

}
