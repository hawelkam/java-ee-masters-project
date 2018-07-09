package com.mikehawek.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.business.enums.ItemStatus;
import com.mikehawek.business.facade.MultimediaShopFacade;

@Named
@javax.enterprise.context.SessionScoped
public class BasketBean implements Serializable {
    @EJB
    private MultimediaShopFacade multimediaShopFacade;

    private List<ItemDto> basket = new ArrayList<>();
    private double value;

    public double calculateValue() {
        value = basket.stream().map(i -> i.getItemNameDto().getPrice()).collect(Collectors.summingDouble(Double::doubleValue));
        return value;
    }

    public List<ItemDto> getBasket() {
        return basket;
    }

    public void setBasket(List<ItemDto> basket) {
        this.basket = basket;
    }

    public void add(ItemNameDto itemNameDto) {
        ItemDto itemDto = multimediaShopFacade.findFirstAvailable(itemNameDto);
        if (itemDto == null) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ten przedmiot jest niedostępny!", ""));
            return;
        }
        itemDto.setStatus(ItemStatus.InBasket);
        this.basket.add(itemDto);
        multimediaShopFacade.editItem(itemDto);
        calculateValue();
    }

    public void removeFromBasket(ItemDto itemDto) {
        changeStatusToAvailable(itemDto);
        this.basket.remove(itemDto);
        calculateValue();
    }

    private void changeStatusToAvailable(ItemDto itemDto) {
        itemDto.setStatus(ItemStatus.Available);
        multimediaShopFacade.editItem(itemDto);
    }

    private void changeStatusToOrdered(ItemDto itemDto) {
        itemDto.setStatus(ItemStatus.Ordered);
        multimediaShopFacade.editItem(itemDto);
    }

    public void clean() {
        this.basket.stream().forEach(this::changeStatusToAvailable);
        this.basket.clear();
    }

    public void placeOrder(String customerId) {
        this.basket.stream().forEach(this::changeStatusToOrdered);
        multimediaShopFacade.placeOrder(basket, value, customerId);
        this.basket.clear();
    }

    @PreDestroy
    public void cleanBasket() {
        clean();
    }
}
