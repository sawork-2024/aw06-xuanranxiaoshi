package com.example.webposorderservice.mapper;

import com.example.webposorderservice.model.OrderDTO;
import com.example.webposorderservice.model.OrderDetailsDTO;
import com.example.webposorderservice.model.Order;
import com.example.webposorderservice.model.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/14
 * @Copyright：
 */

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    @Mapping(target = "orderDetails", source = "orderDetails") // 添加映射
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)                   // 忽略对 Order 中属性的设置
    @Mapping(target = "orderDetails", source = "orderDetails") // 添加映射
    // MapStruct 会查找并调用与 OrderDetails 到 OrderDetailsDTO 类型转换相关的方法，即 orderDetailsToOrderDetailsDTO 方法。
    Order orderDTOToOrder(OrderDTO orderDTO);



    OrderDetailsDTO orderDetailsToOrderDetailsDTO(OrderDetails orderDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true) // 忽略 Order 属性，因为 OrderDTO 中没有对应的属性
    OrderDetails orderDetailsDTOToOrderDetails(OrderDetailsDTO orderDetailsDTO);


    // MapStruct 会查找并调用与 OrderDetails 到 OrderDetailsDTO 类型转换相关的方法，即 orderDetailsToOrderDetailsDTO 方法。
    default List<OrderDetailsDTO> orderDetailsSetToOrderDetailsDTOSet(List<OrderDetails> orderDetails) {
        return orderDetails.stream()
                .map(this::orderDetailsToOrderDetailsDTO)
                .collect(Collectors.toList());
    }

    default List<OrderDetails> orderDetailsDTOSetToOrderDetailsSet(List<OrderDetailsDTO> orderDetailsDTO) {
        return orderDetailsDTO.stream()
                .map(this::orderDetailsDTOToOrderDetails)
                .collect(Collectors.toList());
    }
}
