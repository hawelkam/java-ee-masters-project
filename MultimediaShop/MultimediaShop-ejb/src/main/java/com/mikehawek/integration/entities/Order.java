package com.mikehawek.integration.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mikehawek.business.enums.ItemStatus;
import com.mikehawek.business.enums.OrderStatus;
import com.mikehawek.integration.entities.users.Customer;

@Entity
@Table(name = "orders", schema="shop")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private List<Item> items = new ArrayList<>();

    @Column(name = "STATUS")
    private OrderStatus status;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
