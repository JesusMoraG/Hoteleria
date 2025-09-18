package com.tcg.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tcg.commons.clients")
public class MsvReservasApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsvReservasApplication.class, args);
    }
}

