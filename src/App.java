package src;
import javax.swing.JOptionPane;
import src.classes.components.PlaylistManager;
import src.classes.components.Home;
import src.classes.components.PlaylistSelector;

public class App {
    public static void main(String[] args) {
        Home home = new Home();
        String selectedPlaylist;

        PlaylistSelector playlists = new PlaylistSelector();
        home.showHome();

        if(home.getValue().equals("Playlists")) {
            selectedPlaylist = playlists.showPlaylists();
            PlaylistManager playlist = new PlaylistManager(selectedPlaylist);
            playlist.showMusics();

        } else if(home.getValue().equals("Podcasts")) {



        } else if(home.getValue().equals("Audiobooks")) {



        }
    }
}
