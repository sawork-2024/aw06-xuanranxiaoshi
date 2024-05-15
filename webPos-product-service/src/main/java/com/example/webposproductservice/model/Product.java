package com.example.webposproductservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author：jimi
 * @date: 2024/4/20
 * @Copyright：
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @NotEmpty
    private String id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    private String category;

    @Column(name = "img")
    private String img;

    @Column(name = "stock")
    private int stock;

    @Column(name = "quantity")
    private int quantity;

    public Product() {
    }

    public Product(String id, String title, double parseDouble, String img) {
        this.id = id;
        this.name = title;
        this.price = parseDouble;
        this.img = img;
    }
}