package src.classes.objects;

public class Biblioteca {
    protected String nome;
    protected String id;
    private static int qtdBibliotecas = 0;

    protected Biblioteca(String nome) {
        this.nome = nome;
        this.id = gerarID();
    }

    private String gerarID() {
        qtdBibliotecas++;
        return String.format("BIB%03d", qtdBibliotecas);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
