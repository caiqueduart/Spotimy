package src;

import javax.swing.JOptionPane;
import src.classes.components.Home;
import src.classes.components.PlaylistSelector;

public class App {
    public static void main(String[] args) {

        String option = Home.showHome();

        if(option.equals("Playlists")) {
            PlaylistSelector.showPlaylists();
        }
        
        if(option.equals("Podcasts")) {
            
        }
    }
}
