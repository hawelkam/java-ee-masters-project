package com.mikehawek.integration.entities.itemnames;

import com.mikehawek.integration.entities.Item;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemName.class)
public abstract class ItemName_ {

	public static volatile SingularAttribute<ItemName, String> productCode;
	public static volatile SingularAttribute<ItemName, Date> releaseDate;
	public static volatile SingularAttribute<ItemName, Double> price;
	public static volatile SingularAttribute<ItemName, String> author;
	public static volatile SingularAttribute<ItemName, String> name;
	public static volatile SingularAttribute<ItemName, String> description;
	public static volatile SingularAttribute<ItemName, String> mediaType;
	public static volatile SingularAttribute<ItemName, String> medium;
	public static volatile SingularAttribute<ItemName, String> distributor;
	public static volatile ListAttribute<ItemName, Item> items;

}

