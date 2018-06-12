package com.mikehawek.business.dto;

import com.mikehawek.business.enums.Medium;

public class MusicAlbumNameDto extends ItemNameDto {
    private String artist;
    private int noOfTracks;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    public MusicAlbumNameDto(String artits, int noOfTracks, Medium medium) {
        this.artist = artits;
        this.noOfTracks = noOfTracks;
        this.medium = medium;
    }

    public MusicAlbumNameDto() {
    }
}