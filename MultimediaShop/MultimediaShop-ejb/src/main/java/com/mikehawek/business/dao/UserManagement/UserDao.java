package com.mikehawek.business.dao.UserManagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mikehawek.integration.entities.users.User;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "DBConnection")
    private EntityManager em;

    public UserDao() {
    }

    public List<User> findUserWithLogin(String login) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<User> userRoot = cq.from(User.class);

        Predicate predicate = cb.equal(userRoot.get("login"), login);

        cq.select(userRoot).where(predicate);
        return em.createQuery(cq).getResultList();
    }

    public List<User> findUserWithCredentials(String login, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<User> userRoot = cq.from(User.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.equal(userRoot.get("login"), login));
        predicates.add(cb.equal(userRoot.get("password"), password));

        cq.select(userRoot).where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(cq).getResultList();
    }

    public void save(Object object) {
        if(object != null)
            em.persist(object);
    }
}
