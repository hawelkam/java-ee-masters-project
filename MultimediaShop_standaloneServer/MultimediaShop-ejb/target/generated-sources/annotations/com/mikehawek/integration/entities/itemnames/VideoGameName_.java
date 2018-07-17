package com.mikehawek.integration.entities.itemnames;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VideoGameName.class)
public abstract class VideoGameName_ extends com.mikehawek.integration.entities.itemnames.ItemName_ {

	public static volatile SingularAttribute<VideoGameName, GameGenre> genre;
	public static volatile SingularAttribute<VideoGameName, String> producer;
	public static volatile SingularAttribute<VideoGameName, String> publisher;
	public static volatile SingularAttribute<VideoGameName, GamePlatform> platform;

}

