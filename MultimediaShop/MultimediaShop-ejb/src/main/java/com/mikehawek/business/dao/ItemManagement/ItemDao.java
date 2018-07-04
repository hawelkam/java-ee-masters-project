package com.mikehawek.business.dao.ItemManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mikehawek.integration.entities.Item;

@Stateless
public class ItemDao {

    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    public ItemDao() {
    }

    public void deleteItem(Item item) {
        em.remove(item);
    }

    public List<Item> findItemByBarCode(String barCode) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Item> itemRoot = cq.from(Item.class);

        Predicate predicate = cb.equal(itemRoot.get("bar_code"), barCode);

        cq.select(itemRoot).where(predicate);
        return em.createQuery(cq).getResultList();

    }

    public void save(Object object) {
        if(object != null)
            em.persist(object);
    }
}