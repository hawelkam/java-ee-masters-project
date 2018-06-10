/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikehawek.business.facade;

import com.mikehawek.integration.entities.itemnames.ItemName;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hawek
 */
@Stateless
public class ItemNameFacade extends AbstractFacade<ItemName> {

    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemNameFacade() {
        super(ItemName.class);
    }
    
}
