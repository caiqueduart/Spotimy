package src.classes.exceptions;

/**
 * Exceção personalizada para indicar opções inválidas na aplicação.
 * Extende a classe {@link Exception} para permitir o lançamento e captura de erros relacionados a opções inválidas.
 */
public class InvalidOptionException extends Exception {
    /**
     * Construtor da exceção InvalidOptionException.
     *
     * @param message Mensagem detalhando o motivo da exceção.
     */
    public InvalidOptionException(String message) {
        super(message);
    }
}
