package com.mikehawek.business;

import com.mikehawek.business.dto.ItemNameDto;
import com.mikehawek.business.dto.MovieNameDto;
import com.mikehawek.business.dto.MusicAlbumNameDto;
import com.mikehawek.business.dto.VideoGameNameDto;
import com.mikehawek.integration.entities.itemnames.ItemName;
import com.mikehawek.integration.entities.itemnames.MovieName;
import com.mikehawek.integration.entities.itemnames.MusicAlbumName;
import com.mikehawek.integration.entities.itemnames.VideoGameName;

public class ItemFactory {

    public static MovieName createMovieName(MovieNameDto dto) {
        MovieName movieName = new MovieName();
        movieName.setDescription(dto.getDescription());
        movieName.setDirector(dto.getDirector());
        movieName.setDistributor(dto.getDistributor());
        movieName.setDurationInMinutes(dto.getDurationInMinutes());
        movieName.setGenre(dto.getGenre());
        movieName.setMedium(dto.getMedium());
        movieName.setName(dto.getName());
        movieName.setPrice(dto.getPrice());
        movieName.setProductCode(dto.getProductCode());
        movieName.setReleaseDate(dto.getReleaseDate());
        //add Mapping for Items
        return movieName;
    }

    public static VideoGameName createVideoGameName(VideoGameNameDto dto) {
        VideoGameName videoGameName = new VideoGameName();
        videoGameName.setGenre(dto.getGenre());
        videoGameName.setPlatform(dto.getPlatform());
        videoGameName.setProducer(dto.getProducer());
        videoGameName.setPublisher(dto.getPublisher());
        videoGameName.setMedium(dto.getMedium());
        videoGameName.setName(dto.getName());
        videoGameName.setPrice(dto.getPrice());
        videoGameName.setProductCode(dto.getProductCode());
        videoGameName.setReleaseDate(dto.getReleaseDate());
        return videoGameName;
    }

    public static MusicAlbumName createMusicAlbumName(MusicAlbumNameDto dto) {
        MusicAlbumName musicAlbumName = new MusicAlbumName();
        musicAlbumName.setArtist(dto.getArtist());
        musicAlbumName.setNoOfTracks(dto.getNoOfTracks());
        musicAlbumName.setMedium(dto.getMedium());
        musicAlbumName.setName(dto.getName());
        musicAlbumName.setPrice(dto.getPrice());
        musicAlbumName.setProductCode(dto.getProductCode());
        musicAlbumName.setReleaseDate(dto.getReleaseDate());
        return musicAlbumName;
    }

    public static ItemNameDto createItemNameDto(ItemName entity) {
        if(entity instanceof MovieName) {
            return createMovieNameDto((MovieName) entity);
        } else if (entity instanceof MusicAlbumName){
            return createMusicAlbumNameDto((MusicAlbumName) entity);
        } else if (entity instanceof VideoGameName) {
            return createVideoGameNameDto((VideoGameName) entity);
        } else {
            return null;
        }
    }

    private static VideoGameNameDto createVideoGameNameDto(VideoGameName entity) {
        VideoGameNameDto videoGameName = new VideoGameNameDto();
        videoGameName.setGenre(entity.getGenre());
        videoGameName.setPlatform(entity.getPlatform());
        videoGameName.setProducer(entity.getProducer());
        videoGameName.setPublisher(entity.getPublisher());
        videoGameName.setMedium(entity.getMedium());
        videoGameName.setName(entity.getName());
        videoGameName.setPrice(entity.getPrice());
        videoGameName.setProductCode(entity.getProductCode());
        videoGameName.setReleaseDate(entity.getReleaseDate());
        return videoGameName;
    }

    private static MusicAlbumNameDto createMusicAlbumNameDto(MusicAlbumName entity) {
        MusicAlbumNameDto musicAlbumName = new MusicAlbumNameDto();
        musicAlbumName.setArtist(entity.getArtist());
        musicAlbumName.setNoOfTracks(entity.getNoOfTracks());
        musicAlbumName.setMedium(entity.getMedium());
        musicAlbumName.setName(entity.getName());
        musicAlbumName.setPrice(entity.getPrice());
        musicAlbumName.setProductCode(entity.getProductCode());
        musicAlbumName.setReleaseDate(entity.getReleaseDate());
        return musicAlbumName;
    }

    private static MovieNameDto createMovieNameDto(MovieName entity) {
        MovieNameDto movieName = new MovieNameDto();
        movieName.setDescription(entity.getDescription());
        movieName.setDirector(entity.getDirector());
        movieName.setDistributor(entity.getDistributor());
        movieName.setDurationInMinutes(entity.getDurationInMinutes());
        movieName.setGenre(entity.getGenre());
        movieName.setMedium(entity.getMedium());
        movieName.setName(entity.getName());
        movieName.setPrice(entity.getPrice());
        movieName.setProductCode(entity.getProductCode());
        movieName.setReleaseDate(entity.getReleaseDate());
        //add Mapping for Items
        return movieName;
    }

    public static ItemName createItemName(ItemNameDto itemNameDto) {
        if(itemNameDto instanceof MovieNameDto) {
            return createMovieName((MovieNameDto) itemNameDto);
        } else if (itemNameDto instanceof MusicAlbumNameDto){
            return createMusicAlbumName((MusicAlbumNameDto) itemNameDto);
        } else if (itemNameDto instanceof VideoGameNameDto) {
            return createVideoGameName((VideoGameNameDto) itemNameDto);
        } else {
            return null;
        }
    }
}
