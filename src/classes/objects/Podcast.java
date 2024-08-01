package src.classes.objects;
import java.util.ArrayList;

import classes.Biblioteca;

public class Podcast extends Biblioteca {
    private ArrayList<String> nomeApresentadores = new ArrayList<>();
    private ArrayList<Episodio> episodios = new ArrayList<>();

    Podcast(String nome, ArrayList<String> nomeApresentadores) {
        super(nome);
        this.nomeApresentadores = new ArrayList<>(nomeApresentadores);
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

    public void removerEpisodio(Episodio ep) {
        episodios.remove(ep);
    }

    public void removerApresentador(String nome) {
        nomeApresentadores.remove(nome);
    }
}
