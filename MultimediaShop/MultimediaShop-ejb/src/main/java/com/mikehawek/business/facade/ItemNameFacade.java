/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikehawek.business.facade;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mikehawek.business.ItemFactory;
import com.mikehawek.business.dto.ItemDto;
import com.mikehawek.business.dto.ItemNameDto;
import com.mikehawek.integration.entities.itemnames.ItemName;
import com.mikehawek.integration.producer.AddItemProducer;

/**
 *
 * @author Hawek
 */
@Stateless
public class ItemNameFacade extends AbstractFacade<ItemNameDto> {

    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    @Inject
    private AddItemProducer addItemProducer;



    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemNameFacade() {
        super(ItemNameDto.class);

    }

    public void addItemName(ItemNameDto itemToAdd) {
        //validate dto
        addItemProducer.sendAddItemMessage(itemToAdd);
    }

    public void addItem(ItemDto itemDto) {

    }

    public List<ItemNameDto> listItemNames() {
        List<ItemName> itemNames = listAllItems();
        return itemNames.stream()
                .map(in -> ItemFactory.createItemNameDto(in))
                .collect(Collectors.toList());
    }

    private List<ItemName> listAllItems() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(ItemName.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
