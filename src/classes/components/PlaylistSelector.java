package src.classes.components;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PlaylistSelector {
    public ArrayList<String> values = new ArrayList<>();
    Object value;
    
    public PlaylistSelector() {
        try {

            String path = "Spotimy/src/files/playlists/playlists.txt";
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);

            String line;
            while((line = bf.readLine())!= null) {
                values.add(line);
            }

            fr.close();
            bf.close();
            
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public String showPlaylists() {

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
