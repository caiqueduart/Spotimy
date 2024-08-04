package src.classes.components;

import javax.swing.JOptionPane;
import src.classes.exceptions.InvalidOptionException;

/**
 * Classe responsável pela exibição da tela inicial do aplicativo, onde o usuário pode selecionar entre as opções disponíveis.
 */
public class Home {

    /**
     * Construtor da classe Home.
     */
    public Home() {}

    /**
     * Exibe a tela inicial com opções para o usuário selecionar.
     * 
     * @return A opção selecionada pelo usuário como uma String.
     * @throws InvalidOptionException Se o usuário clicar em Cancelar ou fechar a caixa de diálogo.
     */
    public static String showHome() throws InvalidOptionException {

        Object[] values = {"Playlists", "Podcasts"};
        Object value;

        value = JOptionPane.showInputDialog(
            null,
            "O que vamos ouvir hoje?", 
            "Spotimy",
            JOptionPane.PLAIN_MESSAGE, 
            null,
            values,
            values[0]
        );

        if(value == null) {
            throw new InvalidOptionException("A aplicação foi encerrada!\nO usuário clicou em Cancelar ou fechou a caixa de diálogo.");
        }
        
        return value.toString();
    }
}
