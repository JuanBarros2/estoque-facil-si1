package exceptions;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(String err) {
        super("ExcecaoDados: " + err);
    }
}