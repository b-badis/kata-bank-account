package kata.banking.domain;

import java.time.LocalDateTime;

public class StatementLine {
    private final OperationType operationType;
    private final LocalDateTime dateTime;
    private final Amount amount;
    private final Balance balance;

    public StatementLine(OperationType operationType, LocalDateTime dateTime, Amount amount, Balance balance) {
        this.operationType = operationType;
        this.dateTime = dateTime;
        this.amount = amount;
        this.balance = balance;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Amount getAmount() {
        return amount;
    }

    public Balance getBalance() {
        return balance;
    }
}
