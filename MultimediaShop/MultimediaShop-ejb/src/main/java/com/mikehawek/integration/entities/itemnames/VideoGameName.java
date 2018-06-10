package com.mikehawek.integration.entities.itemnames;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.mikehawek.business.enums.GameGenre;
import com.mikehawek.business.enums.GamePlatform;

@Entity
@DiscriminatorValue("GameName")
public class VideoGameName extends ItemName{
    @Column(name = "game_producer")
    private String producer;
    @Column(name = "game_publisher")
    private String publisher;
    @Column(name = "game_platform")
    private GamePlatform platform;
    @Column(name = "game_genre")
    private GameGenre genre;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public GamePlatform getPlatform() {
        return platform;
    }

    public void setPlatform(GamePlatform platform) {
        this.platform = platform;
    }

    public GameGenre getGenre() {
        return genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "VideoGameName{}";
    }
}