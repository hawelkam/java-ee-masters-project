package com.mikehawek.integration.entities;

import com.mikehawek.integration.entities.users.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Basket.class)
public abstract class Basket_ {

	public static volatile SingularAttribute<Basket, Integer> id;
	public static volatile ListAttribute<Basket, Item> items;
	public static volatile SingularAttribute<Basket, Customer> customer;

}

