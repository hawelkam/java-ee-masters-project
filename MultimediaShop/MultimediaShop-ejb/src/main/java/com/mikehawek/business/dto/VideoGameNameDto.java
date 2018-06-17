package com.mikehawek.business.dto;

import com.mikehawek.business.enums.GameGenre;
import com.mikehawek.business.enums.GamePlatform;

public class VideoGameNameDto extends ItemNameDto {
    private String producer;
    private String publisher;
    private GamePlatform platform;
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

    public VideoGameNameDto() {
    }

    public VideoGameNameDto(String name, String productCode) {
        super(name, productCode);
    }

    @Override
    public VideoGameNameDto clone() throws CloneNotSupportedException {
        return new VideoGameNameDto(name, productCode);
    }
}