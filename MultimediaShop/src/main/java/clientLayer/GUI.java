package clientLayer;

import javax.swing.JOptionPane;

import businessLayer.businessLayerEnums.MediaType;
import businessLayer.businessLayerEnums.Medium;
import businessLayer.dataaccess.dto.MusicAlbumNameDto;
import businessLayer.facade.MultimediaShopFacade;

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
