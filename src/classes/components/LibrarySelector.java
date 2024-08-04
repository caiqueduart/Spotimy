package src.classes.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.exceptions.InvalidOptionException;

/**
 * Classe responsável pela exibição de bibliotecas (playlists ou podcasts) e seleção de itens.
 */
public class LibrarySelector {

    /**
     * Construtor da classe LibrarySelector.
     */
    public LibrarySelector() {}

    /**
     * Exibe uma lista de opções com base no tipo de biblioteca fornecido e permite que o usuário selecione uma.
     *
     * @param libraryType O tipo de biblioteca a ser exibida ("playlists" ou "podcasts").
     * @throws InvalidOptionException Se o usuário clicar em Cancelar ou fechar a caixa de diálogo.
     */
    public static void show(String libraryType) throws InvalidOptionException {
        ArrayList<String> options = new ArrayList<>();
        Object option;

        try {
            // Define o caminho do arquivo com base no tipo de biblioteca.
            String path = "Spotimy/src/files/" + libraryType + "/" + libraryType + ".txt";
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);

            // Lê as linhas do arquivo e adiciona cada linha à lista de opções.
            String line;
            while((line = bf.readLine()) != null) {
                options.add(line);
            }

            fr.close();
            bf.close();
            
        } catch (IOException e) {
            // Exibe uma mensagem de erro se ocorrer um problema ao ler o arquivo.
            JOptionPane.showMessageDialog(
                null,
                "Aplicação encerrada!\n" + e.getMessage(),
                "Spotimy",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Formata o nome da biblioteca para exibição na interface.
        String formatedLibraryName;
        if(libraryType.equals("playlists")) {
            formatedLibraryName = "Playlist";
        } else {
            formatedLibraryName = "Podcast";
        }

        // Exibe uma caixa de diálogo com a lista de opções e obtém a seleção do usuário.
        option = JOptionPane.showInputDialog(
            null,
            "Qual " + formatedLibraryName + " deseja ouvir?", 
            "Spotimy",
            JOptionPane.PLAIN_MESSAGE, 
            null,
            options.toArray(),
            options.get(0)
        );

        if(option == null) {
            // Lança uma exceção se o usuário clicar em Cancelar ou fechar a caixa de diálogo.
            throw new InvalidOptionException("Aplicação Encerrada!\nO usuário clicou em Cancelar ou fechou a caixa de diálogo.");
        }

        // Redireciona para o gerenciador apropriado com base no tipo de biblioteca.
        if(libraryType.equals("playlists")) {
            PlaylistManager.showAndSelectMusic((String)option);

        } else if(libraryType.equals("podcasts")) {
            PodcastManager.showAndSelectPodcast((String)option);
        }
    }
}
