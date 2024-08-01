package src.classes.components.playlists;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.objects.PlayList;
import src.classes.objects.Musica;

public class Animadas {
    private ArrayList<String> colaboradores = new ArrayList<>();
    public PlayList animadas = new PlayList("Animadas", colaboradores);
    private String pathColaboradores = "Spotimy/src/files/playlists/animadas/colaboradores.txt";
    private String pathMusicas = "Spotimy/src/files/playlists/animadas/musicas.txt";
    private FileReader fr;
    private BufferedReader br;

    public Animadas() {
        try {
            fr = new FileReader(pathColaboradores);
            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                colaboradores.add(line);
            }

            fr = new FileReader(pathMusicas);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] musica = line.split("#");

                animadas.addMusica(new Musica(
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
        StringBuilder musicasList = new StringBuilder("MÚSICAS\n");
        ArrayList<String> valuesList = new ArrayList<>();

        for (int i = 0; i < colaboradores.size(); i++) {
            colaboradoresList.append(colaboradores.get(i));
            if (i < (colaboradores.size() - 1)) {
                colaboradoresList.append(" | ");
            }
        }

        for (int i = 0; i < animadas.getMusicas().size(); i++) {
            Musica musica = animadas.getMusicas().get(i);
            musicasList.append(musica.getNome() + " - " + musica.getArtista() + "\n");
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
