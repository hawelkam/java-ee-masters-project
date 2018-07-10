package com.mikehawek.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
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

    private ItemDto item;
    private ItemDto beforeEditItem;
    private List<ItemDto> items;
    boolean specificItemEdit;

    @PostConstruct
    public void init() {
        itemName = new ItemNameDto();
        item = new ItemDto();
    }

    public void add() {
        System.out.println("ADD ITEMNAME OPERATION START: " + System.nanoTime());
        boolean result = multimediaShopFacade.addItemName(itemName);
        if (!result) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item name with code " + itemName.getProductCode() + " already exists!", ""));
            return;
        }
        setItemNames(multimediaShopFacade.listItemNames());
        resetAdd();

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

    public void addSpecificItem(ItemNameDto itemName) {
        this.itemName = itemName;
        specificItemEdit = true;
    }

    public void editSpecificItem(ItemDto item) throws CloneNotSupportedException {
        beforeEditItem = item.clone();
        this.item = item;
        specificItemEdit = true;
    }

    public void cancelSpecificItemEdit() {
        this.item.restore(beforeEditItem);
        this.item = new ItemDto();
        specificItemEdit = false;
    }

    public void saveSpecificItemEdit() {
        System.out.println("EDIT ITEM OPERATION START: " + System.nanoTime());
        this.item.setItemNameDto(this.itemName);
        multimediaShopFacade.editItem(this.item);
        this.item = new ItemDto();
        specificItemEdit = false;
    }

    public void saveSpecificItemAddition() {
        this.item.setItemNameDto(this.itemName);
        multimediaShopFacade.addItem(this.item);
        this.item = new ItemDto();
        specificItemEdit = false;
    }

    public void deleteSpecificItem(String barCode) throws IOException {
        System.out.println("DELETE ITEM OPERATION START: " + System.nanoTime());
        multimediaShopFacade.deleteItem(barCode);
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

    public boolean isSpecificItemEdit() {
        return specificItemEdit;
    }

    public void setSpecificItemEdit(boolean specificItemEdit) {
        this.specificItemEdit = specificItemEdit;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public String getAvailability(ItemNameDto itemNameDto) {
        return multimediaShopFacade.checkAvailability(itemNameDto.getProductCode());
    }
}
