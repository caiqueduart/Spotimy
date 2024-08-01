package src.classes.objects;
import java.util.ArrayList;

public class Episodio extends Audio{
    private int numEpisodio;
    private String descricao;
    private ArrayList<String> nomeConvidados = new ArrayList<>();
    private String tema;
    private String dataPublicacao;
    private static int qtdEpisodios = 0;

    Episodio(String nome, double duracao, String dataPublicacao) {
        super(nome, duracao);
        this.dataPublicacao = dataPublicacao;
        this.numEpisodio = qtdEpisodios;
        qtdEpisodios++;
    }

    Episodio(String nome, double duracao, String dataPublicacao, String tema) {
        super(nome, duracao);
        this.dataPublicacao = dataPublicacao;
        this.tema = tema;
        this.numEpisodio = qtdEpisodios;
        qtdEpisodios++;
    }

    Episodio(String nome, double duracao, String dataPublicacao, String tema, ArrayList<String> convidados) {
        super(nome, duracao);
        this.dataPublicacao = dataPublicacao;
        this.tema = tema;
        this.nomeConvidados = new ArrayList<>(convidados);
        this.numEpisodio = qtdEpisodios;
        qtdEpisodios++;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumEpisodio() {
        return numEpisodio;
    }

    public String getDescricao() {
        return descricao;
    }

    public ArrayList<String> getNomeConvidados() {
        return nomeConvidados;
    }

    public String getTema() {
        return tema;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void addConvidado(String nome) {
        nomeConvidados.add(nome);
    }
}
