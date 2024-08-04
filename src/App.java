package src;

import javax.swing.JOptionPane;
import src.classes.components.Home;
import src.classes.components.LibrarySelector;
import src.classes.exceptions.InvalidOptionException;

/**
 * Classe principal da aplicação que gerencia a navegação entre as opções disponíveis.
 * 
 * @author Caique Duarte
 */
public class App {

    /**
     * Método principal que inicializa o aplicativo.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {

        try {
            // Exibe a tela inicial e obtém a opção selecionada pelo usuário.
            String option = Home.showHome();
    
            // Processa a opção selecionada pelo usuário.
            switch (option) {
    
                case "Playlists": {
                    LibrarySelector.show("playlists");
                    break;
                }
                    
                case "Podcasts": {
                    LibrarySelector.show("podcasts");
                    break;
                }
                    
                default: {
                    Home.showHome();
                    break;
                } 
            }

        } catch (InvalidOptionException e) {
            // Exibe uma mensagem de erro caso uma exceção InvalidOptionException ocorra.
            JOptionPane.showMessageDialog(
                null, e.getMessage(), 
                "Spotimy", 
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
