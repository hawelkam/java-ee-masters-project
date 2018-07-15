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
import com.mikehawek.business.criteria.ItemNameSearchCriteria;
import com.mikehawek.business.criteria.ItemSearchCriteria;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.integration.entities.itemnames.ItemName;

@Stateless
public class ItemNameDao {

    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    @Inject
    private ItemDao dao;

    public ItemNameDao() {
    }

    public void deleteItemName(ItemName itemName) {
        em.remove(itemName);
    }

    public void deleteItemName(String productCode) {
        ItemName item = em.find(ItemName.class, productCode);
        if (item != null)
            em.remove(item);
    }

    public List<ItemName> findItemNameByProductCode(String productCode) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<ItemName> itemNameRoot = cq.from(ItemName.class);

        Predicate predicate = cb.equal(itemNameRoot.get("productCode"), productCode);

        cq.select(itemNameRoot).where(predicate);
        return em.createQuery(cq).getResultList();

    }

    public List<ItemName> findItemNames(ItemNameSearchCriteria searchCriteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<ItemName> itemNameRoot = cq.from(ItemName.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (searchCriteria.getMedium() != null) {
            predicates.add(cb.equal(itemNameRoot.get("medium"), searchCriteria.getMedium().toString()));
        }
        if (searchCriteria.getName() != null) {
            predicates.add(cb.like(itemNameRoot.get("name"), "%" + searchCriteria.getName() + "%"));
        }
        if (searchCriteria.getProductCode() != null) {
            predicates.add(cb.like(itemNameRoot.get("productCode"), "%" + searchCriteria.getProductCode() + "%"));
        }
        cq.select(itemNameRoot).where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(cq).getResultList();
    }

    public void save(ItemNameDto itemDto) {
        if(itemDto != null) {
            ItemName item = ItemFactory.createItemName(itemDto);
            em.persist(item);
            LoggingSupport.logTimeToConsole("ADD ITEMNAME OPERATION FINISHED: " + System.nanoTime());
        }
    }

    public void edit(ItemNameDto itemDto) {
        ItemName item = ItemFactory.createItemName(itemDto);
        ItemSearchCriteria sc = new ItemSearchCriteria();
        sc.setProductCode(item.getProductCode());
        item.setItems(dao.findItems(sc));
        em.merge(item);
    }
}
