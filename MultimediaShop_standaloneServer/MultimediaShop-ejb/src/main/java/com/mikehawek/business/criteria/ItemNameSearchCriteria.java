package com.mikehawek.business.criteria;

import com.mikehawek.business.enums.Medium;

public class ItemNameSearchCriteria {
    private String productCode;
    private String name;
    private Medium medium;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }
}
