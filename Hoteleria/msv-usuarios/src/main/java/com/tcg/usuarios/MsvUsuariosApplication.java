package com.tcg.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tcg.commons.feign")
public class MsvUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvUsuariosApplication.class, args);
	}

}
