package src.classes.components;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.objects.PlayList;
import src.classes.objects.Musica;

public class PlaylistManager {
    
    public PlaylistManager() {}

    public static Musica showAndSelectMusic(String podcastName) {
        PlayList playlist;

        playlist = new PlayList(podcastName);
        String pathColaboradores = "Spotimy/src/files/playlists/" + podcastName + "/colaboradores.txt";
        String pathMusicas = "Spotimy/src/files/playlists/" + podcastName + "/musicas.txt";

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

            br.close();
            fr.close();

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

        valuesList.add("[ ADICIONAR NOVA MÚSICA ]");

        String[] values = valuesList.toArray(new String[0]);

        String selectedValue = (String) JOptionPane.showInputDialog(
            null,
            colabList + "\n\nQUAL MÚSICA GOSTARIA DE OUVIR?", 
            "Spotimy > " + playlist.getNome(),
            JOptionPane.PLAIN_MESSAGE, 
            null,
            values,
            values[0]
        );

        if (selectedValue != null) {
            if (selectedValue.equals("[ ADICIONAR NOVA MÚSICA ]")) {
                addMusic(podcastName);
            } else {
                String[] selectedValues = selectedValue.split(" - ");
                for (Musica musica : playlist.getMusicas()) {
                    if (musica.getNome().equals(selectedValues[0]) && musica.getArtista().equals(selectedValues[1])) {
                        MusicPlayer.play(musica);
                        return musica;
                    }
                }
            }
        }

        return null;
    }

    public static void addMusic(String podcastName) {
        String path = "Spotimy/src/files/playlists/" + podcastName + "/musicas.txt";
        String nome = JOptionPane.showInputDialog("Qual o nome da música?");

        if (nome == null || nome.isEmpty()) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            Musica musica = new Musica(
                nome,
                Double.parseDouble(JOptionPane.showInputDialog("Qual a duração de " + nome + " em segundos?")),
                JOptionPane.showInputDialog("Qual o artista por trás de " + nome + "?"),
                JOptionPane.showInputDialog("Qual o gênero de " + nome + "?")
            );

            bw.write("\n" + musica.getNome() + "#" + musica.getDuracaoSegundos() + "#" + musica.getArtista() + "#" + musica.getGenero());
            bw.close();

            Object[] options = {"Reproduzir nova Música", "Adicionar nova música", "Encerrar"};
            int option = JOptionPane.showOptionDialog(
                null, 
                musica.getNome() + " de " + musica.getArtista() + " foi adcionada a " + podcastName + "\nO que faremos agora?", 
                "Spotimy", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            if (option == 0) {
                PlaylistSelector.showPlaylists();
            } else if (option == 1) {
                PlaylistManager.addMusic(podcastName);
            } else {
                return;
            }
            
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
