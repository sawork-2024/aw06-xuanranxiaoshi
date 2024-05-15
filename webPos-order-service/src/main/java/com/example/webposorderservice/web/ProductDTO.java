package com.example.webposorderservice.web;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

/**
 * @description: 不是该服务资源，而是为了定义从 Product service 返回的数据类型
 * @author：jimi
 * @date: 2024/5/15
 * @Copyright：
 */
@Data
@JsonRootName("Account")
public class ProductDTO {

    private String id;

    private String name;

    private double price;

    private String category;

    private String img;

    private int stock;

    private int quantity;

}
