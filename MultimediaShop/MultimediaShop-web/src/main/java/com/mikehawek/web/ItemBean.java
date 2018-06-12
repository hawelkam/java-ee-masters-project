package com.mikehawek.web;

import javax.inject.Named;

@Named("itemBean")
@javax.enterprise.context.RequestScoped
public class ItemBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
