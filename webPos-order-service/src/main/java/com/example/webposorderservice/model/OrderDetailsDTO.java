package com.example.webposorderservice.model;

import lombok.Data;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/14
 * @Copyright：
 */
@Data
public class OrderDetailsDTO {
    private String productId;
    private Integer quantity;
    private double unitPrice;

    public OrderDetailsDTO() {
    }
}