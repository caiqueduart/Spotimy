package src.classes.components;
import javax.swing.JOptionPane;

public class Home {

    Object[] values = {"Playlists", "Podcasts", "Áudio Books"};
    Object value;

    public Home() {}

    public void showHome() {
        value = JOptionPane.showInputDialog(
            null,
            "O que vamos ouvir hoje?", 
            "Spotimy",
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            values,
            values[0]
        );
    }

    public String getValue() {
        return value.toString();
    }
}
