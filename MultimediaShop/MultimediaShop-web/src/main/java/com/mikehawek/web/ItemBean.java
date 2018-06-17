package com.mikehawek.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.dto.ItemNameDto;
import com.mikehawek.business.dto.MovieNameDto;
import com.mikehawek.business.facade.ItemNameFacade;

@Named
@javax.enterprise.context.SessionScoped
public class ItemBean implements Serializable {
    @EJB
    private com.mikehawek.business.facade.ItemNameFacade itemNameFacade;

    private String name;
    private ItemNameDto itemName;
    private ItemNameDto beforeEditItemName;
    boolean edit;

    @PostConstruct
    public void init() {
        itemName = new ItemNameDto();
    }

    public void add() {
        itemNameFacade.addItemName(this.itemName);
        itemName = new MovieNameDto();
    }

    public void resetAdd() {
        itemName = new ItemNameDto();
    }

    public List<ItemNameDto> listItems() {
        return itemNameFacade.listItemNames();
    }

    public void edit(ItemNameDto item) throws CloneNotSupportedException {
        beforeEditItemName = item.clone();
        this.itemName = item;
        edit = true;
    }

    public void cancelEdit() {
        this.itemName.restore(beforeEditItemName);
        this.itemName = new ItemNameDto();
        edit = false;
    }

    public void saveEdit() {
        itemNameFacade.editItemName(this.itemName);
        this.itemName = new ItemNameDto();
        edit = false;
    }

    public void delete(String productCode) throws IOException {
        itemNameFacade.deleteItemName(productCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemNameFacade getItemNameFacade() {
        return itemNameFacade;
    }

    public void setItemNameFacade(ItemNameFacade itemNameFacade) {
        this.itemNameFacade = itemNameFacade;
    }

    public List<ItemNameDto> getItemNames() {
        List<ItemNameDto> list = itemNameFacade.listItemNames();
        return list;
    }

    public void setItemNames(List<ItemNameDto> itemNames) {
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public ItemNameDto getItemName() {
        return itemName;
    }

    public void setItemName(ItemNameDto itemName) {
        this.itemName = itemName;
    }
}
