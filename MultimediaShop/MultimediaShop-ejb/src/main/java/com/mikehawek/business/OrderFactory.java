package com.mikehawek.business;

import java.util.stream.Collectors;

import com.mikehawek.business.dto.OrderManagement.OrderDto;
import com.mikehawek.integration.entities.Order;

public class OrderFactory {

    public static OrderDto createOrderDto(Order entity) {
        OrderDto orderDto = new OrderDto();
        /*orderDto.setName(entity.getName());
        orderDto.setProductCode(entity.getProductCode());
        orderDto.setPrice(entity.getPrice());
        if (entity.getMedium() != null)
            orderDto.setMedium(Medium.valueOf(entity.getMedium()));
        orderDto.setReleaseDate(entity.getReleaseDate());
        orderDto.setDescription(entity.getDescription());
        orderDto.setAuthor(entity.getAuthor());
        orderDto.setDistributor(entity.getDistributor());
        if (entity.getMediaType() != null)
            orderDto.setMediaType(MediumType.valueOf(entity.getMediaType()));
        if(entity.getItems() != null) {
            orderDto.setItems(entity.getItems().stream().map(i -> createItemDto(i)).collect(Collectors.toList()));
        }*/
        return orderDto;
    }

    public static OrderDto createItemNameDtoWithoutItems(Order entity) {
        OrderDto orderDto = new OrderDto();
        /*orderDto.setName(entity.getName());
        orderDto.setProductCode(entity.getProductCode());
        orderDto.setPrice(entity.getPrice());
        if (entity.getMedium() != null)
            orderDto.setMedium(Medium.valueOf(entity.getMedium()));
        orderDto.setReleaseDate(entity.getReleaseDate());
        orderDto.setDescription(entity.getDescription());
        orderDto.setAuthor(entity.getAuthor());
        orderDto.setDistributor(entity.getDistributor());
        if (entity.getMediaType() != null)
            orderDto.setMediaType(MediumType.valueOf(entity.getMediaType()));*/
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
