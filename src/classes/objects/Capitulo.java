package src.classes.objects;

public class Capitulo extends Audio {
    private int numCapitulo;

    Capitulo(String nome, double duracaoSegundos, int numCapitulo) {
        super(nome, duracaoSegundos);
        this.numCapitulo = numCapitulo;
    }

    public int getNumCapitulo() {
        return numCapitulo;
    }
}
