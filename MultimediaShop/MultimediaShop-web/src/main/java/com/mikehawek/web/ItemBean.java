package com.mikehawek.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.business.dto.ItemManagement.MovieNameDto;
import com.mikehawek.business.facade.MultimediaShopFacade;

@Named
@javax.enterprise.context.SessionScoped
public class ItemBean implements Serializable {
    @EJB
    private MultimediaShopFacade multimediaShopFacade;

    private String name;
    private ItemNameDto itemName;
    private ItemNameDto beforeEditItemName;
    private List<ItemNameDto> itemNames;
    boolean edit;

    @PostConstruct
    public void init() {
        itemName = new MovieNameDto();
    }

    public void add() {
        multimediaShopFacade.addItemName(this.itemName);
        setItemNames(multimediaShopFacade.listItemNames());
        itemName = new MovieNameDto();

    }

    public void resetAdd() {
        itemName = new ItemNameDto();
    }

    public List<ItemNameDto> listItems() {
        return multimediaShopFacade.listItemNames();
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
        multimediaShopFacade.editItemName(this.itemName);
        this.itemName = new ItemNameDto();
        edit = false;
    }

    public void delete(String productCode) throws IOException {
        multimediaShopFacade.deleteItemName(productCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultimediaShopFacade getMultimediaShopFacade() {
        return multimediaShopFacade;
    }

    public void setMultimediaShopFacade(MultimediaShopFacade multimediaShopFacade) {
        this.multimediaShopFacade = multimediaShopFacade;
    }

    public List<ItemNameDto> getItemNames() {
        itemNames = multimediaShopFacade.listItemNames();
        return itemNames;
    }

    public void setItemNames(List<ItemNameDto> itemNames) {
        this.itemNames = itemNames;
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
