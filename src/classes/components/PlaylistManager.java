package src.classes.components;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.objects.PlayList;
import src.classes.exceptions.InvalidOptionException;
import src.classes.objects.Musica;

/**
 * Classe responsável pelo gerenciamento de playlists, incluindo a exibição de músicas e adição de novas músicas.
 */
public class PlaylistManager {
    
    /**
     * Construtor da classe PlaylistManager.
     */
    public PlaylistManager() {}

    /**
     * Exibe uma playlist e permite que o usuário selecione uma música ou adicione uma nova música.
     *
     * @param playlistName O nome da playlist a ser exibida.
     * @throws InvalidOptionException Se o usuário clicar em Cancelar ou fechar a caixa de diálogo.
     */
    public static void showAndSelectMusic(String playlistName) throws InvalidOptionException {
        PlayList playlist = new PlayList(playlistName);
        String pathColaboradores = "Spotimy/src/files/playlists/" + playlistName + "/colaboradores.txt";
        String pathMusicas = "Spotimy/src/files/playlists/" + playlistName + "/musicas.txt";

        try {

            // Lê os colaboradores da playlist.
            FileReader fr = new FileReader(pathColaboradores);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                playlist.addColaborador(line);
            }

            // Lê as músicas da playlist.
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
            // Exibe uma mensagem de erro se ocorrer um problema ao ler os arquivos.
            System.out.println("Erro: " + e.getMessage());
        }

        // Cria uma lista formatada de colaboradores e músicas para exibição.
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

        valuesList.add("ADICIONAR NOVA MÚSICA");

        String[] values = valuesList.toArray(new String[0]);

        // Exibe uma caixa de diálogo para seleção de música.
        String selectedValue = (String) JOptionPane.showInputDialog(
            null,
            colabList + "\n\nQUAL MÚSICA GOSTARIA DE OUVIR?", 
            "Spotimy > " + playlist.getNome(),
            JOptionPane.PLAIN_MESSAGE, 
            null,
            values,
            values[0]
        );

        if(selectedValue == null) {
            // Lança uma exceção se o usuário clicar em Cancelar ou fechar a caixa de diálogo.
            throw new InvalidOptionException("Aplicação Encerrada!\nO usuário clicou em Cancelar ou fechou a caixa de diálogo.");

        } else {
            if(selectedValue.equals("ADICIONAR NOVA MÚSICA")) {
                addMusic(playlistName);
            } else {
                // Reproduz a música selecionada.
                String[] selectedValues = selectedValue.split(" - ");
                for (Musica musica : playlist.getMusicas()) {
                    if (musica.getNome().equals(selectedValues[0]) && musica.getArtista().equals(selectedValues[1])) {
                        AudioPlayer.playMusic(musica);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Adiciona uma nova música à playlist.
     *
     * @param playlistName O nome da playlist onde a música será adicionada.
     */
    public static void addMusic(String playlistName) {
        String path = "Spotimy/src/files/playlists/" + playlistName + "/musicas.txt";
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

            // Adiciona a nova música ao arquivo da playlist.
            bw.write("\n" + musica.getNome() + "#" + musica.getDuracaoSegundos() + "#" + musica.getArtista() + "#" + musica.getGenero());

            // Oferece opções ao usuário após adicionar a música.
            Object[] options = {"Reproduzir nova Música", "Adicionar nova música", "Encerrar"};
            int option = JOptionPane.showOptionDialog(
                null, 
                musica.getNome() + " de " + musica.getArtista() + " foi adcionada a " + playlistName + "\nO que faremos agora?", 
                "Spotimy", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            if (option == 0) {
                try {
                    LibrarySelector.show("playlists");

                } catch (InvalidOptionException e) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Aplicação encerrada!\n" + e.getMessage(),
                        "Spotimy",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
                
            } else if (option == 1) {
                // Permite adicionar mais músicas.
                PlaylistManager.addMusic(playlistName);
            } else {
                return;
            }
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro se ocorrer um problema ao escrever no arquivo.
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
