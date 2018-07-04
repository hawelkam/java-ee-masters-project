package com.mikehawek.business.dao.OrderManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderDao {
    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    public OrderDao() {
    }
}
