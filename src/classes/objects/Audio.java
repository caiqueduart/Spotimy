package src.classes.objects;

public abstract class Audio {
    protected String nome;
    protected double duracaoSegundos;

    protected Audio(String nome, double duracaoSegundos) {
        this.nome = nome;
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getNome() {
        return nome;
    }

    public double getDuracaoSegundos() {
        return duracaoSegundos;
    }
}