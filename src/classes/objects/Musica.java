package src.classes.objects;

/**
 * Representa uma música, que inclui informações sobre o artista e o gênero.
 * Extende a classe {@link Audio} para incluir informações sobre a duração e o nome da música.
 */
public class Musica extends Audio {
    private String artista;
    private String genero;

    /**
     * Construtor da classe Musica com artista e gênero.
     *
     * @param nome Nome da música.
     * @param duracaoSegundos Duração da música em segundos.
     * @param artista Nome do artista da música.
     * @param genero Gênero da música.
     */
    public Musica(String nome, double duracaoSegundos, String artista, String genero) {
        super(nome, duracaoSegundos);
        this.artista = artista;
        this.genero = genero;
    }

    /**
     * Obtém o nome do artista da música.
     *
     * @return Nome do artista.
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Obtém o gênero da música.
     *
     * @return Gênero da música.
     */
    public String getGenero() {
        return genero;
    }
}
