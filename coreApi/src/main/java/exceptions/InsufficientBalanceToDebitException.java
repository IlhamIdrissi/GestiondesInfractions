package exceptions;

public class InsufficientBalanceToDebitException extends RuntimeException {
    public InsufficientBalanceToDebitException(String message) {
        super(message);
    }
}
