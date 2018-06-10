package com.mikehawek.integration.entities.itemnames;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MusicAlbumName")
public class MusicAlbumName extends ItemName {

    @Column(name = "MUSIC_ARTIST")
    private String artist;
    @Column(name = "MUSIC_TRACKS")
    private int noOfTracks;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artits) {
        this.artist = artits;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    @Override
    public String toString() {
        return super.toString() + " Artysta: " + getArtist() + "Liczba utworów: " + getNoOfTracks();
    }
}