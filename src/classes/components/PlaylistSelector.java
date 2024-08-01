package src.classes.components;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PlaylistSelector {
    Object value;
    FileReader fr;
    BufferedReader bf;
    public ArrayList<String> values = new ArrayList<>();
    String path = "Spotimy/src/files/playlists/playlists.txt";

    public PlaylistSelector() {
        try {
            fr = new FileReader(path);
            bf = new BufferedReader(fr);

            String line;
            while((line = bf.readLine())!= null) {
                values.add(line);
            }
            
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public String showPlaylists() {

        if (values.isEmpty()) {
            JOptionPane.showMessageDialog(
                null, 
                "Nenhuma playlist disponível", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);

            return null;
        }

        value = JOptionPane.showInputDialog(
            null,
            "O que vamos ouvir hoje?", 
            "Spotimy",
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            values.toArray(),
            values.get(0)
        );

        return (String)value;
    }

    public String getValue() {
        return value.toString();
    }
}
