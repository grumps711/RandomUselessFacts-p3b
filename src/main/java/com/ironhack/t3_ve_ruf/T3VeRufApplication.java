package com.ironhack.t3_ve_ruf;

import com.ironhack.t3_ve_ruf.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class T3VeRufApplication implements CommandLineRunner {

    private final Menu menu;

    public static void main(String[] args) {
        SpringApplication.run(T3VeRufApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menu.startApp();
    }
}
