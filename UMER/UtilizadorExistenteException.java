


public class UtilizadorExistenteException extends Exception implements java.io.Serializable {
    public UtilizadorExistenteException() {
        super("O utilizador já existe.");
    }
}