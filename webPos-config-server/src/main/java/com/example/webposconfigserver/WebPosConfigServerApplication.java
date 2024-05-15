package com.example.webposconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class WebPosConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebPosConfigServerApplication.class, args);
	}

}
