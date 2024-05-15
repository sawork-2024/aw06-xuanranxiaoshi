package com.example.webposorderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/10
 * @Copyright：
 */

@Data
@Entity
@AllArgsConstructor
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    // @JoinColumn 注释的是保存表与表之间关系的字段，它要标注在实体属性上(相当于外键)
    @JsonIgnore
    private Order order;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    public OrderDetails() {
    }
}
