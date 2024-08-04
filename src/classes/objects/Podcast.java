package src.classes.objects;

import java.util.ArrayList;

public class Podcast extends Biblioteca {
    private ArrayList<String> nomeApresentadores = new ArrayList<>();
    private ArrayList<Episodio> episodios = new ArrayList<>();

    public Podcast(String nome) {
        super(nome);
    }

    public ArrayList<Episodio> getEpisodios() {
        return episodios;
    }

    public ArrayList<String> getNomeApresentadores() {
        return nomeApresentadores;
    }

    public void addApresentador(String nome) {
        nomeApresentadores.add(nome);
    }

    public void addEpisodio(Episodio ep) {
        episodios.add(ep);
    }
}
