package com.example.webposorderservice.repository;

import com.example.webposorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/14
 * @Copyright：
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
