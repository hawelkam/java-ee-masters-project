package businessLayer.entity;

import businessLayer.businessLayerEnums.GameGenre;
import businessLayer.businessLayerEnums.GamePlatform;

public class VideoGameName extends ItemName{
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

    @Override
    public String toString() {
        return "VideoGameName{}";
    }
}
