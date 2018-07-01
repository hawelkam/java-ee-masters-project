package com.mikehawek.business.dto;

import com.mikehawek.business.enums.ItemStatus;

public class ItemDto {
    ItemNameDto itemNameDto;
    String barCode;
    ItemStatus status;

    public ItemNameDto getItemNameDto() {
        return itemNameDto;
    }

    public void setItemNameDto(ItemNameDto itemNameDto) {
        this.itemNameDto = itemNameDto;
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
}
