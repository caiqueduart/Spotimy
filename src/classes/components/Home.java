package src.classes.components;
import javax.swing.JOptionPane;

public class Home {

    public Home() {}

    public static String showHome() {

        Object[] values = {"Playlists", "Podcasts", "Áudio Books"};
        Object value;

        value = JOptionPane.showInputDialog(
            null,
            "O que vamos ouvir hoje?", 
            "Spotimy",
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            values,
            values[0]
        );
        
        return value.toString();
    }
}
