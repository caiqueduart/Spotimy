package src.classes.components;

import javax.swing.JOptionPane;
import src.classes.objects.Episodio;
import src.classes.objects.Musica;

public class AudioPlayer {

    AudioPlayer() {}

    public static void playMusic(Musica music) {

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

    public static void playEpisodio(Episodio episodio) {
        String info = (
            episodio.getNome() + " está sendo reproduzido agora. . ."
            + "\n◊ Convidado: " + episodio.getNomeConvidado()
            + "\n◊ Tema: " + episodio.getTema()
            + "\n◊ Duração: " + episodio.getDuracaoSegundos()
        );

        Object[] options = {"Reproduzir novo Episódio", "Encerrar"};
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
            LibrarySelector.show("podcasts");
        } else {
            return;
        }
    }
}
