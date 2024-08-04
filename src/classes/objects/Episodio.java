package src.classes.objects;

public class Episodio extends Audio{
    private String nomeConvidado;
    private String tema;

    public Episodio(String nome, double duracao, String tema, String nomeConvidado) {
        super(nome, duracao);
        this.tema = tema;
        this.nomeConvidado = nomeConvidado;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public String getTema() {
        return tema;
    }
}
