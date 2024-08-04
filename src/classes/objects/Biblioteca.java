package src.classes.objects;

/**
 * Classe abstrata que representa uma biblioteca genérica, com um nome.
 */
public abstract class Biblioteca {
    protected String nome;

    /**
     * Construtor da classe Biblioteca.
     *
     * @param nome Nome da biblioteca.
     */
    protected Biblioteca(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nome da biblioteca.
     *
     * @return Nome da biblioteca.
     */
    public String getNome() {
        return nome;
    }
}
