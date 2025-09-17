package com.ruben.huespedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ruben.huespedes.client")
public class HuespedesApplication {
    public static void main(String[] args) {
        SpringApplication.run(HuespedesApplication.class, args);
    }
}
