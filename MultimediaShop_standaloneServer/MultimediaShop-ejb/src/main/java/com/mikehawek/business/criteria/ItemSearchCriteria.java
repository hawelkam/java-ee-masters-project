package com.mikehawek.business.criteria;

import com.mikehawek.business.enums.ItemStatus;

public class ItemSearchCriteria {
    private String productCode;
    private String barCode;
    private ItemStatus status;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBarCode() {
        return barCode;
    }

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
