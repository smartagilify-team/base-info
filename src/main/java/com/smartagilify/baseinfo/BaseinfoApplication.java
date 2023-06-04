package com.smartagilify.baseinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BaseinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseinfoApplication.class, args);
    }

}
