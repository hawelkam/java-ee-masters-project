package com.mikehawek.business.dto.ItemManagement;

import java.io.Serializable;

import com.mikehawek.business.enums.ItemStatus;

public class ItemDto  implements Serializable{
    String barCode;
    ItemStatus status;
    ItemNameDto itemNameDto;

    boolean isEdited;

    public ItemDto() {
    }

    public ItemDto(ItemNameDto itemNameDto, String barCode, ItemStatus status) {
        this.itemNameDto = itemNameDto;
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

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public ItemNameDto getItemNameDto() {
        return itemNameDto;
    }

    public void setItemNameDto(ItemNameDto itemNameDto) {
        this.itemNameDto = itemNameDto;
    }

    @Override
    public ItemDto clone() throws CloneNotSupportedException {
        return new ItemDto(itemNameDto, barCode, status);
    }

    public void restore(ItemDto item) {
        this.barCode = item.getBarCode();
        this.status = item.getStatus();
        this.itemNameDto = item.getItemNameDto();
    }
}
