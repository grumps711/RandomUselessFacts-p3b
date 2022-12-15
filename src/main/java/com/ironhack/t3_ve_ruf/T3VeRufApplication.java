package com.ironhack.t3_ve_ruf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class T3VeRufApplication {

    public static void main(String[] args) {
        SpringApplication.run(T3VeRufApplication.class, args);
    }
}
