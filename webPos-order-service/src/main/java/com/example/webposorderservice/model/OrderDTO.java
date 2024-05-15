package com.example.webposorderservice.model;

import lombok.Data;

import java.util.Set;

/**
 * @description: 定义创建订单请求中接收到的 order 参数类型( OrderDTO)
 * @author：jimi
 * @date: 2024/5/14
 * @Copyright：
 */
@Data
public class OrderDTO {
    private Long userId;
    private Integer status;
    private Set<OrderDetailsDTO> orderDetails;

    public OrderDTO() {
    }
}
