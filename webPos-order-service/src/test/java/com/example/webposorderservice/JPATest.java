package com.example.webposorderservice;

import com.example.webposorderservice.model.Order;
import com.example.webposorderservice.model.OrderDetails;
import com.example.webposorderservice.repository.OrderRepository;
import com.example.webposorderservice.web.OrderResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/14
 * @Copyright：
 */
@SpringBootTest
public class JPATest {

    @Autowired
    OrderRepository orderRepository;
    @Test
    public void test(){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(1L);
        orderDetails.setQuantity(2);
        orderDetails.setUnitPrice(10);
        orderDetails.setProductId("pd1");

//        OrderDetails orderDetails1 = new OrderDetails();
//        orderDetails1.setId(2L);
//        orderDetails1.setQuantity(3);
//        orderDetails1.setUnitPrice(30);
//        orderDetails1.setProductId("pd2");

        List<OrderDetails> details = new LinkedList<>();
        details.add(orderDetails);
//        details.add(orderDetails1);

        Order order = new Order();
        order.setDate(new Date());
        order.setStatus(1);
        order.setId(1l);
        order.setUserId(1l);
        order.setOrderDetails(details);

        orderRepository.save(order);

        System.out.println("save order");

        Optional<Order> orderFind = orderRepository.findById(1l);
        System.out.println(orderFind);
    }
}
