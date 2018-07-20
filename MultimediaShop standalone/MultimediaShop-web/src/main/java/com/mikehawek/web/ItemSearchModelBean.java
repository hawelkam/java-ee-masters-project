package com.mikehawek.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import com.mikehawek.business.criteria.ItemSearchCriteria;
import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.business.facade.MultimediaShopFacade;

@Named
@javax.enterprise.context.SessionScoped
public class ItemSearchModelBean implements Serializable {
    @EJB
    private MultimediaShopFacade multimediaShopFacade;

    private ItemSearchCriteria itemSearchCriteria;

    private List<ItemDto> searchResult;

    @PostConstruct
    public void init() {
        itemSearchCriteria = new ItemSearchCriteria();
    }

    public void search() {
        searchResult = multimediaShopFacade.searchItems(this.itemSearchCriteria);
        return;
    }

    public void resetSearch() {
        this.itemSearchCriteria = new ItemSearchCriteria();
        this.searchResult = new ArrayList<>();
    }

    public MultimediaShopFacade getMultimediaShopFacade() {
        return multimediaShopFacade;
    }

    public void setMultimediaShopFacade(MultimediaShopFacade multimediaShopFacade) {
        this.multimediaShopFacade = multimediaShopFacade;
    }

    public ItemSearchCriteria getItemSearchCriteria() {
        return itemSearchCriteria;
    }

    public void setItemSearchCriteria(ItemSearchCriteria ItemSearchCriteria) {
        this.itemSearchCriteria = ItemSearchCriteria;
    }

    public List<ItemDto> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<ItemDto> searchResult) {
        this.searchResult = searchResult;
    }
}
