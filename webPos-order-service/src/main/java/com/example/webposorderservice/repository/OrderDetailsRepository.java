package com.example.webposorderservice.repository;

import com.example.webposorderservice.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/14
 * @Copyright：
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByOrderId(long orderId);
}
