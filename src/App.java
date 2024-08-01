package src;
import javax.swing.JOptionPane;
import src.classes.components.Home;
import src.classes.components.Playlists;
import src.classes.components.playlists.Animadas;

public class App {
    public static void main(String[] args) {
        Home home = new Home();
        Playlists playlists = new Playlists();

        home.showHome();

        if(home.getValue().equals("Playlists")) {
            Animadas playlist = new Animadas();
            playlists.showPlaylists();
            playlist.showMusics();

        } else if(home.getValue().equals("Podcasts")) {



        } else if(home.getValue().equals("Audiobooks")) {



        }
    }
}
