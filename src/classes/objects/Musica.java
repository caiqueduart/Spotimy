package src.classes.objects;

public class Musica extends Audio {
    private String artista;
    private String genero;

    public Musica(String nome, double duracaoSegundos, String artista, String genero) {
        super(nome, duracaoSegundos);
        this.artista = artista;
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }
}
