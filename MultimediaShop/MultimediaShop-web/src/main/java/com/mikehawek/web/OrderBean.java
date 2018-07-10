package com.mikehawek.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.dto.OrderManagement.OrderDto;
import com.mikehawek.business.enums.ItemStatus;
import com.mikehawek.business.enums.OrderStatus;
import com.mikehawek.business.facade.MultimediaShopFacade;

@Named
@javax.enterprise.context.SessionScoped
public class OrderBean implements Serializable {
    @EJB
    private MultimediaShopFacade multimediaShopFacade;

    private List<OrderDto> orders = new ArrayList<>();

    public List<OrderDto> listOrders(String customerId) {
        return multimediaShopFacade.listOrders(customerId);
    }

    private void changeStatusToAvailable(ItemDto itemDto) {
        itemDto.setStatus(ItemStatus.Available);
        multimediaShopFacade.editItem(itemDto);
    }

    public void cancelOrder(OrderDto order) {
        order.getItems().forEach(this::changeStatusToAvailable);
        order.setStatus(OrderStatus.Cancelled);
        multimediaShopFacade.cancelOrder(order);
    }
}
