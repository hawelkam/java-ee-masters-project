package businessLayer.facade;

import businessLayer.businessLayerEnums.MediaType;
import businessLayer.dataaccess.dto.ItemNameDto;
import businessLayer.dataaccess.dto.MovieNameDto;
import businessLayer.dataaccess.dto.MusicAlbumNameDto;
import businessLayer.dataaccess.dto.VideoGameNameDto;
import businessLayer.entity.ItemName;
import businessLayer.entity.MovieName;
import businessLayer.entity.MusicAlbumName;
import businessLayer.entity.VideoGameName;

public class MultimediaShopFacade {

    private ItemName itemName;

    public MultimediaShopFacade() {

    }

    public void addItemName(MediaType mediaType, ItemNameDto dto) {
        switch (mediaType) {
            case Movie:
                itemName = createMovieName((MovieNameDto) dto);
                break;
            case VideoGame:
                itemName = createVideoGameName((VideoGameNameDto) dto);
                break;
            case MusicAlbum:
                itemName = createMusicAlbumName((MusicAlbumNameDto) dto);
                break;
            default:
        }
    }

    public ItemName getItemName() {
        return itemName;
    }

    public void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }

    private MusicAlbumName createMusicAlbumName(MusicAlbumNameDto dto) {
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

    private MovieName createMovieName(MovieNameDto dto) {
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

    private VideoGameName createVideoGameName(VideoGameNameDto dto) {
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
}
