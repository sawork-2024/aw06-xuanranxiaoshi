package com.example.webposorderservice;

import com.example.webposorderservice.model.OrderDTO;
import com.example.webposorderservice.model.OrderDetailsDTO;
import com.example.webposorderservice.mapper.OrderMapper;
import com.example.webposorderservice.model.Order;
import com.example.webposorderservice.model.OrderDetails;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/14
 * @Copyright：
 */
public class MapperTest {
    @Test
    public void testDetailsMapper(){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(1L);
        orderDetails.setQuantity(2);
        orderDetails.setUnitPrice(10);
        orderDetails.setProductId("pd1");

        System.out.println(orderDetails);

        OrderDetailsDTO orderDetailsDTO = OrderMapper.INSTANCE.orderDetailsToOrderDetailsDTO(orderDetails);
        System.out.println(orderDetailsDTO);

        System.out.println("-------------------------");

        OrderDetailsDTO orderDetailsDTO1 = new OrderDetailsDTO();
        orderDetailsDTO1.setProductId("pd2");
        orderDetailsDTO1.setQuantity(3);
        orderDetailsDTO1.setUnitPrice(30);

        System.out.println(orderDetailsDTO1);
        OrderDetails orderDetails1 = OrderMapper.INSTANCE.orderDetailsDTOToOrderDetails(orderDetailsDTO1);
        System.out.println(orderDetails1);
    }

    @Test
    public void  testOrderMapper(){



        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(1L);
        orderDetails.setQuantity(2);
        orderDetails.setUnitPrice(10);
        orderDetails.setProductId("pd1");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setId(2L);
        orderDetails1.setQuantity(3);
        orderDetails1.setUnitPrice(30);
        orderDetails1.setProductId("pd2");

        List<OrderDetails> details = new LinkedList<>();
        details.add(orderDetails);
        details.add(orderDetails1);

        Order order = new Order();
        order.setDate(new Date());
        order.setStatus(1);
        order.setId(1l);
        order.setUserId(1l);
        order.setOrderDetails(details);

        System.out.println(order);

        OrderDTO orderDTO = OrderMapper.INSTANCE.orderToOrderDTO(order);
        System.out.println(orderDTO);
    }
}
