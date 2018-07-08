package com.mikehawek.integration.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mikehawek.business.enums.ItemStatus;
import com.mikehawek.integration.entities.itemnames.ItemName;

@Entity
@Table(name = "items", schema="shop")
public class Item implements Serializable {
    @Id
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