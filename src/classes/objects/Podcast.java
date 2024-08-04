package src.classes.objects;

import java.util.ArrayList;

/**
 * Representa um podcast, que inclui uma lista de apresentadores e uma lista de episódios.
 * Extende a classe {@link Biblioteca} para incluir o nome do podcast.
 */
public class Podcast extends Biblioteca {
    private ArrayList<String> nomeApresentadores = new ArrayList<>();
    private ArrayList<Episodio> episodios = new ArrayList<>();

    /**
     * Construtor da classe Podcast.
     *
     * @param nome Nome do podcast.
     */
    public Podcast(String nome) {
        super(nome);
    }

    /**
     * Obtém a lista de episódios do podcast.
     *
     * @return Lista de episódios.
     */
    public ArrayList<Episodio> getEpisodios() {
        return episodios;
    }

    /**
     * Obtém a lista de apresentadores do podcast.
     *
     * @return Lista de nomes dos apresentadores.
     */
    public ArrayList<String> getNomeApresentadores() {
        return nomeApresentadores;
    }

    /**
     * Adiciona um apresentador ao podcast.
     *
     * @param nome Nome do apresentador a ser adicionado.
     */
    public void addApresentador(String nome) {
        nomeApresentadores.add(nome);
    }

    /**
     * Adiciona um episódio ao podcast.
     *
     * @param ep Episódio a ser adicionado.
     */
    public void addEpisodio(Episodio ep) {
        episodios.add(ep);
    }
}
