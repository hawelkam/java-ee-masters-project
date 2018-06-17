/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikehawek.integration.entities.itemnames;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mikehawek.business.enums.MovieGenre;

/**
 *
 * @author Hawek
 */
@Entity
@DiscriminatorValue("MovieName")
public class MovieName extends ItemName {
    @Column(name = "movie_director")
    private String director;

    @Column(name = "movie_genre")
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    @Column(name = "movie_duration")
    private int durationInMinutes;

    @Column(name = "movie_description")
    private String description;

    @Column(name = "movie_distributor")
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
