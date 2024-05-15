package com.example.webposorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class  WebPosOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebPosOrderServiceApplication.class, args);
    }

    /**
     * 创建一个 RestTemplate 的 Bean，并在该 Bean 上使用 @LoadBalanced 注解，这样 Spring 就会自动配置它以支持负载均衡。
     * @return
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
