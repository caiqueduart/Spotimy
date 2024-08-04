package src.classes.components;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import src.classes.exceptions.InvalidOptionException;
import src.classes.objects.Episodio;
import src.classes.objects.Podcast;

/**
 * Classe responsável pelo gerenciamento de podcasts, incluindo a exibição de episódios e adição de novos episódios.
 */
public class PodcastManager {

    /**
     * Construtor da classe PodcastManager.
     */
    public PodcastManager() {}

    /**
     * Exibe um podcast e permite que o usuário selecione um episódio ou adicione um novo episódio.
     *
     * @param podcastName O nome do podcast a ser exibido.
     * @throws InvalidOptionException Se o usuário clicar em Cancelar ou fechar a caixa de diálogo.
     */
    public static void showAndSelectPodcast(String podcastName) throws InvalidOptionException {
        Podcast podcast = new Podcast(podcastName);
        String pathEpisodios = "Spotimy/src/files/podcasts/" + podcastName + "/episodios.txt";
        String pathApresentadores = "Spotimy/src/files/podcasts/" + podcastName + "/apresentadores.txt";
        
        try {
            
            // Lê os episódios do podcast.
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

            // Lê os apresentadores do podcast.
            fr = new FileReader(pathApresentadores);
            br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                podcast.addApresentador(line);
            }

            br.close();
            fr.close();

        } catch(IOException e) {
            // Exibe uma mensagem de erro se ocorrer um problema ao ler os arquivos.
            System.out.println("Erro: " + e.getMessage());
        }

        // Cria uma lista de episódios e adiciona a opção de adicionar um novo episódio.
        ArrayList<String> valuesList = new ArrayList<>();
        for(int i = 0; i < podcast.getEpisodios().size(); i++) {
            valuesList.add(podcast.getEpisodios().get(i).getNome());
        }

        valuesList.add("ADICIONAR NOVO EPISÓDIO");
        String[] values = valuesList.toArray(new String[0]);

        // Exibe uma caixa de diálogo para seleção de episódio.
        String selectedValue = (String) JOptionPane.showInputDialog(
            null,
            "QUAL EPISÓDIO GOSTARIA DE OUVIR?", 
            "Spotimy > " + podcast.getNome(),
            JOptionPane.PLAIN_MESSAGE, 
            null,
            values,
            values[0]
        );

        if(selectedValue == null) {
            // Lança uma exceção se o usuário clicar em Cancelar ou fechar a caixa de diálogo.
            throw new InvalidOptionException("Aplicação Encerrada!\nO usuário clicou em Cancelar ou fechou a caixa de diálogo.");
            
        } else {
            if(selectedValue.equals("ADICIONAR NOVO EPISÓDIO")) {
                addEpisodio(podcastName);
            } else {
                // Reproduz o episódio selecionado.
                for(Episodio episodio : podcast.getEpisodios()) {
                    if(episodio.getNome().equals(selectedValue)) {
                        AudioPlayer.playEpisodio(episodio);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Adiciona um novo episódio a um podcast.
     *
     * @param podcastName O nome do podcast onde o episódio será adicionado.
     */
    public static void addEpisodio(String podcastName) {
        String path = "Spotimy/src/files/podcasts/" + podcastName + "/episodios.txt";
        String nome = JOptionPane.showInputDialog("Qual o título do episódio?");

        if(nome == null || nome.isEmpty()) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            Episodio episodio = new Episodio(
                nome, 
                Double.parseDouble(JOptionPane.showInputDialog("Qual a duração de " + nome + " em segundos?")), 
                JOptionPane.showInputDialog("Qual o tema abordado em " + nome + "?"), 
                JOptionPane.showInputDialog("Qual o nome do convidado que está em " + nome + "?")
            );

            // Adiciona o novo episódio ao arquivo do podcast.
            bw.write("\n" + episodio.getNome() + "#" + episodio.getDuracaoSegundos() + "#" + episodio.getTema() + "#" + episodio.getNomeConvidado());

            // Oferece opções ao usuário após adicionar o episódio.
            Object[] options = {"Reproduzir novo episódio", "Adicionar novo episódio", "Encerrar"};
            int option = JOptionPane.showOptionDialog(
                null, 
                episodio.getNome() + " com o tema " + episodio.getTema() + " foi adicionado a " + podcastName + "\nO que faremos agora?", 
                "Spotimy", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            if (option == 0) {
                try {
                    LibrarySelector.show("podcasts");

                } catch (InvalidOptionException e) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Aplicação encerrada!\n" + e.getMessage(),
                        "Spotimy",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
                
            } else if (option == 1) {
                // Permite adicionar mais episódios.
                PodcastManager.addEpisodio(podcastName);
            } else {
                return;
            }

        } catch(IOException e) {
            // Exibe uma mensagem de erro se ocorrer um problema ao escrever no arquivo.
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
