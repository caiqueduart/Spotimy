package src;

import javax.swing.JOptionPane;
import src.classes.components.Home;
import src.classes.components.LibrarySelector;
import src.classes.components.LibrarySelector;

public class App {
    public static void main(String[] args) {

        String option = Home.showHome();

        if(option.equals("Playlists")) {
            LibrarySelector.show("playlists");
        }
        
        if(option.equals("Podcasts")) {
            LibrarySelector.show("podcasts");
        }
    }
}
