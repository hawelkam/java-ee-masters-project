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
    private String barCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemName itemName;

    @Column(name = "STATUS")
    private ItemStatus status;

    public String getBarCode() { return barCode; }

    public void setBarCode(String barCode) { this.barCode = barCode; }

    public ItemName getItemName() {
        return itemName;
    }

    public void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}