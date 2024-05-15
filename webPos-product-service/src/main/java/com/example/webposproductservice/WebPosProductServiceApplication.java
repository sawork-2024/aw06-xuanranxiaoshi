package com.example.webposproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebPosProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebPosProductServiceApplication.class, args);
    }

}
