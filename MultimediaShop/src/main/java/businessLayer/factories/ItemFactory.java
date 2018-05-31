package businessLayer.factories;

import businessLayer.dataaccess.dto.MovieNameDto;
import businessLayer.dataaccess.dto.MusicAlbumNameDto;
import businessLayer.dataaccess.dto.VideoGameNameDto;
import businessLayer.entity.itemNames.MovieName;
import businessLayer.entity.itemNames.MusicAlbumName;
import businessLayer.entity.itemNames.VideoGameName;

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
        musicAlbumName.setArtits(dto.getArtits());
        musicAlbumName.setNoOfTracks(dto.getNoOfTracks());
        musicAlbumName.setMedium(dto.getMedium());
        musicAlbumName.setName(dto.getName());
        musicAlbumName.setPrice(dto.getPrice());
        musicAlbumName.setProductCode(dto.getProductCode());
        musicAlbumName.setReleaseDate(dto.getReleaseDate());
        return musicAlbumName;
    }
}
