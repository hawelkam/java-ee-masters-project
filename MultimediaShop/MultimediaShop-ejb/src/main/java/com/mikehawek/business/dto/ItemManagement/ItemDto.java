package com.mikehawek.business.dto.ItemManagement;

import java.io.Serializable;

import com.mikehawek.business.enums.ItemStatus;

public class ItemDto  implements Serializable{
    String itemName;
    String productCode;
    String barCode;
    ItemStatus status;

    boolean isEdited;

    public ItemDto() {
    }

    public ItemDto(String name, String productCode, String barCode, ItemStatus status) {
        this.itemName = name;
        this.productCode = productCode;
        this.barCode = barCode;
        this.status = status;
    }

    public String getBarCode() { return barCode; }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    @Override
    public ItemDto clone() throws CloneNotSupportedException {
        return new ItemDto(productCode, itemName, barCode, status);
    }

    public void restore(ItemDto item) {
        this.barCode = item.getBarCode();
        this.status = item.getStatus();
        this.itemName = item.getItemName();
        this.productCode = item.getProductCode();
    }
}
