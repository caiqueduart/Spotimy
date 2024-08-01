package src.classes.components;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.objects.PlayList;
import src.classes.objects.Musica;

public class PlaylistManager {
    
    public PlaylistManager() {}

    public static Musica showAndSelectMusic(String playlistName) {
        PlayList playlist;

        playlist = new PlayList(playlistName);
        String pathColaboradores = "Spotimy/src/files/playlists/" + playlistName + "/colaboradores.txt";
        String pathMusicas = "Spotimy/src/files/playlists/" + playlistName + "/musicas.txt";

        try {

            FileReader fr = new FileReader(pathColaboradores);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                playlist.addColaborador(line);
            }

            fr = new FileReader(pathMusicas);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {

                String[] musica = line.split("#");

                playlist.addMusica(new Musica(
                    musica[0],
                    Double.parseDouble(musica[1]),
                    musica[2],
                    musica[3]
                ));
            }

            fr.close();
            br.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        StringBuilder colabList = new StringBuilder("PLAYLIST POR:\n");
        ArrayList<String> valuesList = new ArrayList<>();

        for (int i = 0; i < playlist.getNomeColaboradores().size(); i++) {

            colabList.append(playlist.getNomeColaboradores().get(i));

            if (i < (playlist.getNomeColaboradores().size() - 1)) {
                colabList.append(", ");
            }
        }

        for (int i = 0; i < playlist.getMusicas().size(); i++) {

            Musica musica = playlist.getMusicas().get(i);
            valuesList.add(musica.getNome() + " - " + musica.getArtista());
        }

        String[] values = valuesList.toArray(new String[0]);

        String selectedValue = (String) JOptionPane.showInputDialog(
            null,
            colabList + "\n\nQUAL MÚSICA GOSTARIA DE OUVIR?", 
            "Spotimy > " + playlist.getNome(),
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            values,
            values[0]
        );

        String[] selectedValues = selectedValue.split(" - ");
        
        for(int i = 0; i<playlist.getMusicas().size(); i++) {
            Musica musica = playlist.getMusicas().get(i);
            if(musica.getNome().equals(selectedValues[0]) && musica.getArtista().equals(selectedValues[1])) {
                MusicPlayer.play(musica);
            } 
        }

        return null;
    }
}
