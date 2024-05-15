package com.example.webposorderservice.mapper;

import com.example.webposorderservice.model.Order;
import com.example.webposorderservice.model.OrderDTO;
import com.example.webposorderservice.model.OrderDetails;
import com.example.webposorderservice.model.OrderDetailsDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T21:51:12+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderDetails( orderDetailsListToOrderDetailsDTOSet( order.getOrderDetails() ) );
        orderDTO.setUserId( order.getUserId() );
        orderDTO.setStatus( order.getStatus() );

        return orderDTO;
    }

    @Override
    public Order orderDTOToOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderDetails( orderDetailsDTOSetToOrderDetailsList( orderDTO.getOrderDetails() ) );
        order.setUserId( orderDTO.getUserId() );
        order.setStatus( orderDTO.getStatus() );

        return order;
    }

    @Override
    public OrderDetailsDTO orderDetailsToOrderDetailsDTO(OrderDetails orderDetails) {
        if ( orderDetails == null ) {
            return null;
        }

        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        orderDetailsDTO.setProductId( orderDetails.getProductId() );
        orderDetailsDTO.setQuantity( orderDetails.getQuantity() );
        orderDetailsDTO.setUnitPrice( orderDetails.getUnitPrice() );

        return orderDetailsDTO;
    }

    @Override
    public OrderDetails orderDetailsDTOToOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        if ( orderDetailsDTO == null ) {
            return null;
        }

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setProductId( orderDetailsDTO.getProductId() );
        orderDetails.setQuantity( orderDetailsDTO.getQuantity() );
        orderDetails.setUnitPrice( orderDetailsDTO.getUnitPrice() );

        return orderDetails;
    }

    protected Set<OrderDetailsDTO> orderDetailsListToOrderDetailsDTOSet(List<OrderDetails> list) {
        if ( list == null ) {
            return null;
        }

        Set<OrderDetailsDTO> set = new HashSet<OrderDetailsDTO>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( OrderDetails orderDetails : list ) {
            set.add( orderDetailsToOrderDetailsDTO( orderDetails ) );
        }

        return set;
    }

    protected List<OrderDetails> orderDetailsDTOSetToOrderDetailsList(Set<OrderDetailsDTO> set) {
        if ( set == null ) {
            return null;
        }

        List<OrderDetails> list = new ArrayList<OrderDetails>( set.size() );
        for ( OrderDetailsDTO orderDetailsDTO : set ) {
            list.add( orderDetailsDTOToOrderDetails( orderDetailsDTO ) );
        }

        return list;
    }
}
