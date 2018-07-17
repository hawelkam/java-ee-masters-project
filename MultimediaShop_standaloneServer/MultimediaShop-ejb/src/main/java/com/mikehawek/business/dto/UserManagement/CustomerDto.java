package com.mikehawek.business.dto.UserManagement;

import java.util.List;

import com.mikehawek.business.dto.OrderManagement.BasketDto;
import com.mikehawek.business.dto.OrderManagement.OrderDto;

public class CustomerDto extends UserDto {
    private BasketDto basket;
    private List<OrderDto> orders;

    public BasketDto getBasket() {
        return basket;
    }

    public void setBasket(BasketDto basket) {
        this.basket = basket;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
