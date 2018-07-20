package com.mikehawek.business;

import java.util.stream.Collectors;

import com.mikehawek.business.dto.OrderManagement.OrderDto;
import com.mikehawek.business.enums.OrderStatus;
import com.mikehawek.integration.entities.Order;

public class OrderFactory {

    public static OrderDto createOrderDto(Order entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerLogin(entity.getCustomer().getLogin());
        orderDto.setValue(entity.getValue());
        orderDto.setStatus(OrderStatus.valueOf(entity.getStatus()));
        orderDto.setId(entity.getId());
        orderDto.setPlacementDate(entity.getPlacementDate());
        if(entity.getItems() != null) {
            orderDto.setItems(entity.getItems().stream().map(i -> ItemFactory.createItemDto(i)).collect(Collectors.toList()));
        }
        return orderDto;
    }

    public static Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setValue(orderDto.getValue());
        order.setPlacementDate(orderDto.getPlacementDate());
        if (orderDto.getStatus() != null)
            order.setStatus(orderDto.getStatus().toString());
        order.setItems(orderDto.getItems().stream().map(i -> ItemFactory.createItem(i)).collect(Collectors.toList()));
        return order;
    }
}
