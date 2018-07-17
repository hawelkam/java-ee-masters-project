package com.mikehawek.integration.entities.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mikehawek.integration.entities.Basket;
import com.mikehawek.integration.entities.Order;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends User{
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
            mappedBy = "customer")
    private Basket basket;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<Order> orders = new ArrayList<>();
}
