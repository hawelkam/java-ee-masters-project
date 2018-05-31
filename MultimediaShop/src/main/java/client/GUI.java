package client;

import javax.swing.JOptionPane;

import server.business.enums.MediaType;
import server.business.enums.Medium;
import server.dataaccess.MusicAlbumNameDto;
import server.business.facade.MultimediaShopFacade;

public class GUI {
    MultimediaShopFacade ap = new MultimediaShopFacade();

    public void demo() {
        MusicAlbumNameDto dto = new MusicAlbumNameDto("Behemoth", 10, Medium.CD);
        JOptionPane.showMessageDialog(null, ap.addItemName(MediaType.MusicAlbum, dto));
    }

    static public void main(String args[]) {
        GUI gui = new GUI();
        gui.demo();
    }
}
