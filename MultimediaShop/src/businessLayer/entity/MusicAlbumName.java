package businessLayer.entity;

public class MusicAlbumName extends ItemName {
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

    @Override
    public String toString() {
        return super.toString() + " Artysta: " + getArtits() + "Liczba utworów: " + getNoOfTracks();
    }
}
