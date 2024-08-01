package src.classes.components;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.objects.PlayList;
import src.classes.objects.Musica;

public class PlaylistManager {
    private String playlistName;
    public PlayList playlist = new PlayList(playlistName);
    private String pathColaboradores;
    private String pathMusicas;
    private FileReader fr;
    private BufferedReader br;
    
    public PlaylistManager(String playlistName) {
        
        this.playlistName = playlistName;

        pathColaboradores = "Spotimy/src/files/playlists/" + playlistName + "/colaboradores.txt";
        pathMusicas = "Spotimy/src/files/playlists/" + playlistName + "/musicas.txt";

        try {

            fr = new FileReader(pathColaboradores);
            br = new BufferedReader(fr);

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

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void showMusics() {

        StringBuilder colaboradoresList = new StringBuilder("COLABORADORES\n");
        ArrayList<String> valuesList = new ArrayList<>();

        for (int i = 0; i < playlist.getNomeColaboradores().size(); i++) {

            colaboradoresList.append(playlist.getNomeColaboradores().get(i));

            if (i < (playlist.getNomeColaboradores().size() - 1)) {
                colaboradoresList.append(" | ");
            }
        }

        for (int i = 0; i < playlist.getMusicas().size(); i++) {

            Musica musica = playlist.getMusicas().get(i);
            valuesList.add(musica.getNome() + " - " + musica.getArtista());
        }

        String[] values = valuesList.toArray(new String[0]);

        String selectedValue = (String) JOptionPane.showInputDialog(
            null,
            "Qual música você gostaria de ouvir?", 
            "Spotimy",
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            values,
            values[0]
        );
    }
}
