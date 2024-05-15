package com.example.webposorderservice.web;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @description:  使用 RestTemplate 调用 Product 的服务
 * @author：jimi
 * @date: 2024/5/15
 * @Copyright：
 */
@Service
public class ProductService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl = "http://webPos-product-service";

    protected Logger logger = Logger.getLogger(ProductService.class.getName());


    /**
     * The RestTemplate works because it uses a custom request-factory that uses
     * Ribbon to look-up the service to use. This method simply exists to show this.
     */
    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        logger.warning("The RestTemplate request factory is " + restTemplate.getRequestFactory().getClass());
    }

    /**
     * 通过 ResTemplate 调用 Product 服务获取 Product 信息
     * @param id
     * @return
     */
    public ProductDTO getProduct(String id){
        return restTemplate.getForObject(serviceUrl + "/product/{id}", ProductDTO.class, id);
    }

    public Long getPi(){
        return restTemplate.getForObject(serviceUrl + "/product/pi", Long.class);
    }

}
