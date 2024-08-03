package src.classes.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PlaylistSelector {
   
    public PlaylistSelector() {}

    public static void showPlaylists() {
        ArrayList<String> options = new ArrayList<>();
        Object option;

        try {
            String path = "Spotimy/src/files/playlists/playlists.txt";
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);

            String line;
            while((line = bf.readLine())!= null) {
                options.add(line);
            }

            fr.close();
            bf.close();
            
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        option = JOptionPane.showInputDialog(
            null,
            "Qual playlist deseja ouvir?", 
            "Spotimy",
            JOptionPane.PLAIN_MESSAGE, 
            null,
            options.toArray(),
            options.get(0)
        );

        PlaylistManager.showAndSelectMusic((String)option);
    }
}
