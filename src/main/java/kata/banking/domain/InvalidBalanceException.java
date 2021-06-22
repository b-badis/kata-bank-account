package kata.banking.domain;

public class InvalidBalanceException extends RuntimeException {

    public InvalidBalanceException(String message) {
        super(message);
    }
}
