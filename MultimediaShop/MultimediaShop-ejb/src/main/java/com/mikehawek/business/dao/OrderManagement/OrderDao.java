package com.mikehawek.business.dao.OrderManagement;

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

import com.mikehawek.business.OrderFactory;
import com.mikehawek.business.dao.ItemManagement.ItemDao;
import com.mikehawek.business.dao.UserManagement.UserDao;
import com.mikehawek.business.dto.OrderManagement.OrderDto;
import com.mikehawek.business.enums.OrderStatus;
import com.mikehawek.integration.entities.Item;
import com.mikehawek.integration.entities.Order;

@Stateless
public class OrderDao {
    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    @Inject
    private UserDao userDao;

    @Inject
    private ItemDao itemDao;

    public OrderDao() {
    }

    public void deleteOrder(Order order) {
        em.remove(order);
    }

    public void deleteOrder(int id) {
        Order order = em.find(Order.class, id);
        if (order != null)
            em.remove(order);
    }

    public List<Order> findOrderById(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Order> orderRoot = cq.from(Order.class);

        Predicate predicate = cb.equal(orderRoot.get("id"), id);

        cq.select(orderRoot).where(predicate);
        return em.createQuery(cq).getResultList();

    }

    public void save(OrderDto orderDto) {
        if(orderDto != null) {
            Order order = OrderFactory.createOrder(orderDto);
            order.setCustomer(userDao.findCustomerWithLogin(orderDto.getCustomerLogin()).get(0));
            em.persist(order);
            order.getItems().forEach(i -> updateItemWithOrder(i, order));
        }
    }

    private void updateItemWithOrder(Item item, Order order) {
        item.setOrder(order);
        em.merge(item);
    }

    public List<Order> findOrders(String customerLogin) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Order> orderRoot = cq.from(Order.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.equal(orderRoot.get("customer").get("login"), customerLogin));

        cq.select(orderRoot).where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(cq).getResultList();
    }

    public void edit(OrderDto orderDto) {
        Order order = OrderFactory.createOrder(orderDto);
        order.setCustomer(userDao.findCustomerWithLogin(orderDto.getCustomerLogin()).get(0));
        em.merge(order);
        System.out.println("EDIT ORDER OPERATION FINISH: " + System.nanoTime());
    }

    public void cancelOrder(int id) {
        Order order = findOrderById(id).get(0);
        order.setStatus(OrderStatus.Cancelled.toString());
        em.merge(order);
        System.out.println("CANCEL ORDER OPERATION FINISH: " + System.nanoTime());
    }
}
