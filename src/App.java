package src;

import src.classes.components.Home;
import src.classes.components.LibrarySelector;

public class App {
    public static void main(String[] args) {

        String option = Home.showHome();

        switch (option) {

            case "Playlists": {
                LibrarySelector.show("playlists");
                break;
            }
                
            case "Podcasts": {
                LibrarySelector.show("podcasts");
                break;
            }
                
            default: {
                Home.showHome();
                break;
            } 
        }
    }
}
