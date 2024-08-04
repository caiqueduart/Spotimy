package src.classes.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.exceptions.InvalidOptionException;

public class LibrarySelector {
   
    public LibrarySelector() {}

    public static void show(String libraryType) throws InvalidOptionException {
        ArrayList<String> options = new ArrayList<>();
        Object option;

        try {
            String path = "Spotimy/src/files/" + libraryType + "/" + libraryType + ".txt";
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);

            String line;
            while((line = bf.readLine()) != null) {
                options.add(line);
            }

            fr.close();
            bf.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Aplicação encerrada!\n" + e.getMessage(),
                "Spotimy",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String formatedLibraryName;
        if(libraryType.equals("playlists")) {
            formatedLibraryName = "Playlist";
        } else {
            formatedLibraryName = "Podcast";
        }

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
            throw new InvalidOptionException("Aplicação Encerrada!\nO usuário clicou em Cancelar ou fechou a caixa de diálogo.");
        }

        if(libraryType.equals("playlists")) {
            PlaylistManager.showAndSelectMusic((String)option);

        } else if(libraryType.equals("podcasts")) {
            PodcastManager.showAndSelectPodcast((String)option);
        }
    }
}
