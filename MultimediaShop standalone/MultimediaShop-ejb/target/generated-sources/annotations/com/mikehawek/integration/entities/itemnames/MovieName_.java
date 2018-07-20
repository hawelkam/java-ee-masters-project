package com.mikehawek.integration.entities.itemnames;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MovieName.class)
public abstract class MovieName_ extends com.mikehawek.integration.entities.itemnames.ItemName_ {

	public static volatile SingularAttribute<MovieName, String> director;
	public static volatile SingularAttribute<MovieName, MovieGenre> genre;
	public static volatile SingularAttribute<MovieName, Integer> durationInMinutes;
	public static volatile SingularAttribute<MovieName, String> description;
	public static volatile SingularAttribute<MovieName, String> distributor;

}

