package server.integration.entity.itemNames;

import server.business.enums.MovieGenre;

public class MovieName extends ItemName{
    private String director;
    private MovieGenre genre;
    private int durationInMinutes;
    private String description;
    private String distributor;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    @Override
    public String toString() {
        return "MovieName{" +
                "director='" + director + '\'' +
                ", genre=" + genre +
                ", durationInMinutes=" + durationInMinutes +
                ", description='" + description + '\'' +
                ", distributor='" + distributor + '\'' +
                '}';
    }
}
