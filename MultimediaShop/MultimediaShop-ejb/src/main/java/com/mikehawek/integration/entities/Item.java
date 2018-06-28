package com.mikehawek.integration.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mikehawek.business.enums.ItemStatus;
import com.mikehawek.integration.entities.itemnames.ItemName;

@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemName itemName;

    /*@ManyToOne
    private Order order;*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    private Basket basket;
*/
    @Column(name = "STATUS")
    private ItemStatus status;

    public ItemName getItemName() {
        return itemName;
    }

    public void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }

   /* public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }*/

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    /*public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }*/
}