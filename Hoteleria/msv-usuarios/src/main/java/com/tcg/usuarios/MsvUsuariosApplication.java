package com.tcg.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.tcg.commons"})
public class MsvUsuariosApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsvUsuariosApplication.class, args);
    }
}

