package com.mikehawek.business.dao.ItemManagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mikehawek.business.ItemFactory;
import com.mikehawek.business.LoggingSupport;
import com.mikehawek.business.criteria.ItemSearchCriteria;
import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.integration.entities.Item;

@Stateless
public class ItemDao {

    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    @Inject
    private ItemNameDao dao;

    public ItemDao() {
    }

    public void deleteItem(Item item) {
        em.remove(item);
    }

    public void deleteItem(String barCode) {
        Item item = em.find(Item.class, barCode);
        if (item != null)
            em.remove(item);
        LoggingSupport.logTimeToConsole("DELETE ITEM OPERATION FINISH");

    }

    public List<Item> findItemByBarCode(String barCode) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Item> itemRoot = cq.from(Item.class);

        Predicate predicate = cb.equal(itemRoot.get("barCode"), barCode);

        cq.select(itemRoot).where(predicate);
        return em.createQuery(cq).getResultList();

    }

    public void save(ItemDto itemDto) {
        if(itemDto != null) {
            Item item = ItemFactory.createItem(itemDto);
            item.setItemName(dao.findItemNameByProductCode(itemDto.getItemNameDto().getProductCode()).get(0));
            em.persist(item);
        }
    }

    public List<Item> findItems(ItemSearchCriteria searchCriteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Item> itemRoot = cq.from(Item.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (searchCriteria.getBarCode() != null && !searchCriteria.getBarCode().isEmpty()) {
            predicates.add(cb.equal(itemRoot.get("barCode"), searchCriteria.getBarCode()));
        }
        if (searchCriteria.getProductCode() != null && !searchCriteria.getProductCode().isEmpty()) {
            predicates.add(cb.equal(itemRoot.get("itemName").get("productCode"), searchCriteria.getProductCode()));
        }
        if (searchCriteria.getStatus() != null) {
            predicates.add(cb.equal(itemRoot.get("status"), searchCriteria.getStatus().toString()));
        }
        cq.select(itemRoot).where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(cq).getResultList();
    }

    public void edit(ItemDto itemDto) {
        Item item = ItemFactory.createItem(itemDto);
        if (itemDto.getItemNameDto().getProductCode() != null) {
            item.setItemName(dao.findItemNameByProductCode(itemDto.getItemNameDto().getProductCode()).get(0));
            em.merge(item);
            LoggingSupport.logTimeToConsole("EDIT ITEM OPERATION FINISH");
        }
    }
}