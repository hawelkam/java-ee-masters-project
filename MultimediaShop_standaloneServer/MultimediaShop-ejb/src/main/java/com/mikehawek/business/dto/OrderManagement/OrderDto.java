package com.mikehawek.business.dto.OrderManagement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.enums.OrderStatus;

public class OrderDto implements Serializable {
    private int id;
    private List<ItemDto> items;
    private OrderStatus status;
    private double value;
    private Date placementDate;
    private String customerLogin;
    private boolean isEdited;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }
}
