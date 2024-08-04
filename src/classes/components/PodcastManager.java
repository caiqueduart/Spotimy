package src.classes.components;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.objects.Episodio;
import src.classes.objects.Podcast;

public class PodcastManager {

    public PodcastManager() {}

    public static void showAndSelectPodcast(String podcastName) {
        Podcast podcast = new Podcast(podcastName);
        String pathEpisodios = "Spotimy/src/files/podcasts/" + podcastName + "/episodios.txt";
        String pathApresentadores = "Spotimy/src/files/podcasts/" + podcastName + "/apresentadores.txt";
        
        try {
            
            FileReader fr = new FileReader(pathEpisodios);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while((line = br.readLine()) != null) {
                String[] episodio = line.split("#");
                podcast.addEpisodio(new Episodio(
                    episodio[0], 
                    Double.parseDouble(episodio[1]), 
                    episodio[2], 
                    episodio[3]
                ));
            }

            fr = new FileReader(pathApresentadores);
            br = new BufferedReader(fr);

            while((line = br.readLine()) != null) {
                podcast.addApresentador(line);
            }

            br.close();
            fr.close();

        } catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        ArrayList<String> valuesList = new ArrayList<>();
        for(int i=0; i<podcast.getEpisodios().size(); i++) {
            valuesList.add(podcast.getEpisodios().get(i).getNome());
        }

        valuesList.add("ADICIONAR NOVO EPISÓDIO");
        String[] values = valuesList.toArray(new String[0]);

        String selectedValue = (String) JOptionPane.showInputDialog(
            null,
            "QUAL EPISÓDIO GOSTARIA DE OUVIR?", 
            "Spotimy > " + podcast.getNome(),
            JOptionPane.PLAIN_MESSAGE, 
            null,
            values,
            values[0]
        );

        if(selectedValue != null) {
            if(selectedValue.equals("ADICIONAR NOVO EPISÓDIO")) {
                addEpisodio(podcastName);
            } else {
                for(Episodio episodio : podcast.getEpisodios()) {
                    if(episodio.getNome().equals(selectedValue)) {
                        AudioPlayer.playEpisodio(episodio);
                        return;
                    }
                }
            }
        }
    }

    public static void addEpisodio(String podcastName) {
        String path = "Spotimy/src/files/podcasts/" + podcastName + "/episodios.txt";
        String nome = JOptionPane.showInputDialog("Qual o título do episódio?");

        if(nome==null || nome.isEmpty()) {
            return;
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            Episodio episodio = new Episodio(
                nome, 
                Double.parseDouble(JOptionPane.showInputDialog("Qual a duração de " + nome + " em segundos?")), 
                JOptionPane.showInputDialog("Qual o tema abordado em " + nome +"?"), 
                JOptionPane.showInputDialog("Qual o nome do convidado que está em " + nome + "?")
            );

            bw.write("\n" + episodio.getNome() + "#" + episodio.getDuracaoSegundos() + "#" + episodio.getTema() + "#" + episodio.getNomeConvidado());

            bw.close();

            Object[] options = {"Reproduzir novo episódio", "Adicionar novo episódio", "Encerrar"};
            int option = JOptionPane.showOptionDialog(
                null, 
                episodio.getNome() + " com o tema " + episodio.getTema() + " foi adcionada a " + podcastName + "\nO que faremos agora?", 
                "Spotimy", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            if (option == 0) {
                LibrarySelector.show("podcasts");
            } else if (option == 1) {
                PodcastManager.addEpisodio(podcastName);
            } else {
                return;
            }

        } catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
