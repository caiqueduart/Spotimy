package src.classes.components;

import javax.swing.JOptionPane;
import src.classes.exceptions.InvalidOptionException;
import src.classes.objects.Episodio;
import src.classes.objects.Musica;

/**
 * Classe responsável pela reprodução de músicas e episódios.
 */
public class AudioPlayer {

    /**
     * Construtor da classe AudioPlayer.
     */
    AudioPlayer() {}

    /**
     * Reproduz a música fornecida e exibe opções para o usuário.
     *
     * @param music A música a ser reproduzida.
     */
    public static void playMusic(Musica music) {

        String info = (
            music.getNome() + " está tocando agora. . ."
            + "\n◊ Artista: " + music.getArtista()
            + "\n◊ Duração: " + music.getDuracaoSegundos() + " segundos"
            + "\n◊ Gênero: " + music.getGenero()
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
            try{
                LibrarySelector.show("playlists");

            } catch (InvalidOptionException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Aplicação encerrada!\n" + e.getMessage(),
                    "Spotimy",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        } else {
            return;
        }
    }

    /**
     * Reproduz o episódio fornecido e exibe opções para o usuário.
     *
     * @param episodio O episódio a ser reproduzido.
     */
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
            try {
                LibrarySelector.show("podcasts");
                
            } catch(InvalidOptionException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Aplicação encerrada!\n" + e.getMessage(),
                    "Spotimy",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        } else {
            return;
        }
    }
}
