package src.classes.objects;
import java.util.ArrayList;

import classes.Biblioteca;

public class AudioLivro extends Biblioteca {
    private String nomeAutor;
    private ArrayList<String> nomeNarradores = new ArrayList<>();
    private String sinopse;
    private String genero;
    private String nomeEditora;

    AudioLivro(String nome, String nomeAutor, String genero, String nomeEditora, ArrayList<String> nomeNarradores) {
        super(nomeAutor);
        this.nomeAutor = nomeAutor;
        this.genero = genero;
        this.nomeEditora = nomeEditora;
        this.nomeNarradores = new ArrayList<>(nomeNarradores);
    }

    AudioLivro(String nome, String nomeAutor, String genero, String nomeEditora, ArrayList<String> nomeNarradores, String sinopse) {
        super(nomeAutor);
        this.nomeAutor = nomeAutor;
        this.genero = genero;
        this.nomeEditora = nomeEditora;
        this.nomeNarradores = new ArrayList<>(nomeNarradores);
        this.sinopse = sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public ArrayList<String> getNomeNarradores() {
        return nomeNarradores;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void addNarrador(String nome) {
        nomeNarradores.add(nome);
    }
}
