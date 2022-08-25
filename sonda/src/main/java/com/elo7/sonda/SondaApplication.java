package com.elo7.sonda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.elo7.sonda.example")
public class SondaApplication {
        public static void main(String[] args) {
            SpringApplication.run(SondaApplication.class, args);
        }

}
