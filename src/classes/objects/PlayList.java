package src.classes.objects;

import java.util.ArrayList;

public class PlayList extends Biblioteca {
    private ArrayList<String> nomeColaboradores = new ArrayList<>();
    private ArrayList<Musica> musicas = new ArrayList<>();

    public PlayList(String nome) {
        super(nome);
    }

    public ArrayList<String> getNomeColaboradores() {
        return nomeColaboradores;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void addColaborador(String nome) {
        nomeColaboradores.add(nome);
    }

    public void addMusica(Musica musica) {
        musicas.add(musica);
    }
}
