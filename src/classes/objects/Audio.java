package src.classes.objects;

/**
 * Classe abstrata que representa um áudio genérico, com um nome e uma duração em segundos.
 */
public abstract class Audio {
    protected String nome;
    protected double duracaoSegundos;

    /**
     * Construtor da classe Audio.
     *
     * @param nome Nome do áudio.
     * @param duracaoSegundos Duração do áudio em segundos.
     */
    protected Audio(String nome, double duracaoSegundos) {
        this.nome = nome;
        this.duracaoSegundos = duracaoSegundos;
    }

    /**
     * Obtém o nome do áudio.
     *
     * @return Nome do áudio.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a duração do áudio em segundos.
     *
     * @return Duração do áudio em segundos.
     */
    public double getDuracaoSegundos() {
        return duracaoSegundos;
    }
}
