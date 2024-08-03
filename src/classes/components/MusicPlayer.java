package src.classes.components;

import javax.swing.JOptionPane;
import src.classes.objects.Musica;

public class MusicPlayer {

    MusicPlayer() {}

    public static void play(Musica music) {

        String info = (
            music.getNome() + " está tocando agora. . ."
            + "\n◊ Artista: " + music.getArtista()
            + "\n◊ Duracao: " + music.getDuracaoSegundos() + " segundos"
            + "\n◊ Genero: " + music.getGenero()
        );

        Object[] options = {"Reproduzir nova Música", "Encerrar"};
        int option = JOptionPane.showOptionDialog(
            null, 
            info, 
            "Spotimy", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.PLAIN_MESSAGE, 
            null, 
            options, 
            info
        );

        if(option == 0) {
            LibrarySelector.show("playlists");
        } else {
            return;
        }
    }
}
