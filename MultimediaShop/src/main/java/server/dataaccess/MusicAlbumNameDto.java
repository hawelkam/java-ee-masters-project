package server.dataaccess;

import server.business.enums.Medium;

public class MusicAlbumNameDto extends ItemNameDto {
    private String artits;
    private int noOfTracks;

    public String getArtits() {
        return artits;
    }

    public void setArtits(String artits) {
        this.artits = artits;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    public MusicAlbumNameDto(String artits, int noOfTracks, Medium medium) {
        this.artits = artits;
        this.noOfTracks = noOfTracks;
        this.medium = medium;
    }
}
