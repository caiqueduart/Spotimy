package src.classes.components;

import javax.swing.JOptionPane;
import src.classes.exceptions.InvalidOptionException;

public class Home {

    public Home() {}

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
