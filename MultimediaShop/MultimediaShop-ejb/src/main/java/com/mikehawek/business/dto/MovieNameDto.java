package com.mikehawek.business.dto;

import com.mikehawek.business.enums.MovieGenre;

public class MovieNameDto extends ItemNameDto {
    private String director;
    private MovieGenre genre;
    private int durationInMinutes;
    private String description;
    private String distributor;

    public MovieNameDto() {
    }

    public MovieNameDto(String name, String productCode) {
        super(name, productCode);
    }

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
    public MovieNameDto clone() throws CloneNotSupportedException {
        return new MovieNameDto(name, productCode);
    }
}