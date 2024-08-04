package src;

import javax.swing.JOptionPane;
import src.classes.components.Home;
import src.classes.components.LibrarySelector;
import src.classes.exceptions.InvalidOptionException;

public class App {
    public static void main(String[] args) {

        try{
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

        } catch(InvalidOptionException e) {
            JOptionPane.showMessageDialog(
                null, e.getMessage(), 
                "Spotimy", 
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
