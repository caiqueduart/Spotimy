package src;
import javax.swing.JOptionPane;
import src.classes.components.PlaylistManager;
import src.classes.objects.Musica;
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
            Musica musica = new Musica("", 0);
            musica = playlist.showAndSelectMusic();
            System.out.println(musica.getNome() + " > " + musica.getArtista());

        } else if(home.getValue().equals("Podcasts")) {



        } else if(home.getValue().equals("Audiobooks")) {



        }
    }
}
