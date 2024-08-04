package src.classes.objects;

public abstract class Biblioteca {
    protected String nome;

    protected Biblioteca(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
