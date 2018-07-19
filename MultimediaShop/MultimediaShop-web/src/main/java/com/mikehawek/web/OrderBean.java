package com.mikehawek.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;

import com.mikehawek.business.LoggingSupport;
import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.dto.OrderManagement.OrderDto;
import com.mikehawek.business.dto.UserManagement.CustomerDto;
import com.mikehawek.business.enums.ItemStatus;
import com.mikehawek.business.facade.MultimediaShopFacade;

@Named
@javax.enterprise.context.SessionScoped
public class OrderBean implements Serializable {
    @EJB
    private MultimediaShopFacade multimediaShopFacade;

    private List<OrderDto> orders = new ArrayList<>();

    @ManagedProperty("#{customerLoginBean.loggedUser}")
    private CustomerDto customer;

    private boolean detailsEnabled;
    private OrderDto details;

    public List<OrderDto> listOrders(String customerId) {
        return multimediaShopFacade.listOrders(customerId);
    }

    public boolean isDetailsEnabled() {
        return detailsEnabled;
    }

    public void setDetailsEnabled(boolean detailsEnabled) {
        this.detailsEnabled = detailsEnabled;
    }

    public OrderDto getDetails() {
        return details;
    }

    public void setDetails(OrderDto details) {
        this.details = details;
    }

    private void changeStatusToAvailable(ItemDto itemDto) {
        itemDto.setStatus(ItemStatus.Available);
        multimediaShopFacade.editItem(itemDto);
    }

    public void cancelOrder(OrderDto order) {
        LoggingSupport.logTimeToConsole("CANCEL ORDER START");
        multimediaShopFacade.cancelOrder(order.getId());
        order.getItems().forEach(this::changeStatusToAvailable);
    }

    public void orderDetails(OrderDto orderDto) {
        this.details = orderDto;
        this.detailsEnabled = true;
    }

    public void disableDetails() {
        this.details = new OrderDto();
        this.detailsEnabled = false;
    }


}
