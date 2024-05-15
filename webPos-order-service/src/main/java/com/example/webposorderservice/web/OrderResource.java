package com.example.webposorderservice.web;

import com.example.webposorderservice.model.OrderDTO;
import com.example.webposorderservice.mapper.OrderMapper;
import com.example.webposorderservice.model.Order;
import com.example.webposorderservice.model.OrderDetails;
import com.example.webposorderservice.repository.OrderDetailsRepository;
import com.example.webposorderservice.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/10
 * @Copyright：
 */

@RestController
public class OrderResource {

    private final OrderRepository orderRepository;



    public OrderResource(OrderDetailsRepository orderDetailsRepository, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @GetMapping("/hello")
    public String hello(){
        return "hello order service";
    }

    /**
     * post 请求创建 Order
     * @param userId
     * @param orderDTO
     * @return
     */
    @PostMapping("users/{userId}/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@PathVariable("userId") long userId, @RequestBody OrderDTO orderDTO){
        Order order = OrderMapper.INSTANCE.orderDTOToOrder(orderDTO);
        order.setDate(new Date());
        order.setUserId(userId);

        for (OrderDetails orderDetails : order.getOrderDetails()){
            orderDetails.setOrder(order);
        }

        // 关联的 orderDetails 会跟着被插入
        orderRepository.save(order);

        return OrderMapper.INSTANCE.orderToOrderDTO(order);
    }

    /**
     * get 请求查询 Order
     * @param orderId
     * @return
     */
    @GetMapping("users/*/orders/{orderId}")
    public OrderDTO getOrder(@PathVariable("orderId") long orderId){

        // 没有相应的 order 返回异常
        // 这里因为设置了 order 中 oderDetails 的 OneToMany 关系，查询 Order 的时候关联的 OrderDetails 也会自动查询
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Owner " + orderId + " not found"));

        return OrderMapper.INSTANCE.orderToOrderDTO(order);
    }
}
