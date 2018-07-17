package com.mikehawek.integration.entities;

import com.mikehawek.integration.entities.users.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Date> placementDate;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile ListAttribute<Order, Item> items;
	public static volatile SingularAttribute<Order, Double> value;
	public static volatile SingularAttribute<Order, String> status;
	public static volatile SingularAttribute<Order, Customer> customer;

}

