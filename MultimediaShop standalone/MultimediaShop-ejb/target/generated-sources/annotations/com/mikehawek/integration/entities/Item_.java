package com.mikehawek.integration.entities;

import com.mikehawek.integration.entities.itemnames.ItemName;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, ItemName> itemName;
	public static volatile SingularAttribute<Item, String> barCode;
	public static volatile SingularAttribute<Item, String> status;
	public static volatile SingularAttribute<Item, Order> order;

}

