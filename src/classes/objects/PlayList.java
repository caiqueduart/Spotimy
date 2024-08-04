package src.classes.objects;

import java.util.ArrayList;

/**
 * Representa uma playlist, que inclui uma lista de colaboradores e uma lista de músicas.
 * Extende a classe {@link Biblioteca} para incluir o nome da playlist.
 */
public class PlayList extends Biblioteca {
    private ArrayList<String> nomeColaboradores = new ArrayList<>();
    private ArrayList<Musica> musicas = new ArrayList<>();

    /**
     * Construtor da classe PlayList.
     *
     * @param nome Nome da playlist.
     */
    public PlayList(String nome) {
        super(nome);
    }

    /**
     * Obtém a lista de colaboradores da playlist.
     *
     * @return Lista de nomes dos colaboradores.
     */
    public ArrayList<String> getNomeColaboradores() {
        return nomeColaboradores;
    }

    /**
     * Obtém a lista de músicas da playlist.
     *
     * @return Lista de músicas.
     */
    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    /**
     * Adiciona um colaborador à playlist.
     *
     * @param nome Nome do colaborador a ser adicionado.
     */
    public void addColaborador(String nome) {
        nomeColaboradores.add(nome);
    }

    /**
     * Adiciona uma música à playlist.
     *
     * @param musica Música a ser adicionada.
     */
    public void addMusica(Musica musica) {
        musicas.add(musica);
    }
}
