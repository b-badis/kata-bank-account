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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatementLine that = (StatementLine) o;

        if (getOperationType() != that.getOperationType()) return false;
        if (getDateTime() != null ? !getDateTime().equals(that.getDateTime()) : that.getDateTime() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
        return getBalance() != null ? getBalance().equals(that.getBalance()) : that.getBalance() == null;
    }

    @Override
    public int hashCode() {
        int result = getOperationType() != null ? getOperationType().hashCode() : 0;
        result = 31 * result + (getDateTime() != null ? getDateTime().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        return result;
    }
}
