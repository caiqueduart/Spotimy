package src.classes.objects;

public class Audio {
    protected String nome;
    protected double duracaoSegundos;
    protected String id;
    private static int numAudios = -1;

    protected Audio(String nome, double duracaoSegundos) {
        this.nome = nome;
        this.duracaoSegundos = duracaoSegundos;
        this.id = geraID();
    }

    private String geraID() {
        numAudios++;
        return String.format("AUD%05d", numAudios);
    }

    public String getNome() {
        return nome;
    }

    public double getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getId() {
        return id;
    }

    public String reproduzir() {
        return String.format("Reproduzindo %s...", nome);
    }
}