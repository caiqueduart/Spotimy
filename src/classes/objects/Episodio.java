package src.classes.objects;

/**
 * Representa um episódio de áudio, que inclui um tema e um nome de convidado.
 * Extende a classe {@link Audio} para incluir informações sobre a duração e o nome do episódio.
 */
public class Episodio extends Audio {
    private String nomeConvidado;
    private String tema;

    /**
     * Construtor da classe Episodio.
     *
     * @param nome Nome do episódio.
     * @param duracao Duração do episódio em segundos.
     * @param tema Tema abordado no episódio.
     * @param nomeConvidado Nome do convidado do episódio.
     */
    public Episodio(String nome, double duracao, String tema, String nomeConvidado) {
        super(nome, duracao);
        this.tema = tema;
        this.nomeConvidado = nomeConvidado;
    }

    /**
     * Obtém o nome do convidado do episódio.
     *
     * @return Nome do convidado.
     */
    public String getNomeConvidado() {
        return nomeConvidado;
    }

    /**
     * Obtém o tema abordado no episódio.
     *
     * @return Tema do episódio.
     */
    public String getTema() {
        return tema;
    }
}
