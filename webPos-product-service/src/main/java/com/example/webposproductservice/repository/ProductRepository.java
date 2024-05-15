package com.example.webposproductservice.repository;

/**
 * @description:
 * @author：jimi
 * @date: 2024/3/31
 * @Copyright：
 */

import com.example.webposproductservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // 这里可以定义一些自定义的查询方法，Spring Data JPA 会根据方法名自动生成相应的 SQL 查询
}

