package kata.banking.domain;

import java.time.LocalDateTime;

public class Operation {

    protected OperationType operationType;
    protected LocalDateTime dateTime;
    protected Amount amount;

    public Operation(OperationType operationType, LocalDateTime dateTime, Amount amount) {
        this.operationType = operationType;
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public Amount calculateBalance(Amount amount) {
        return operationType.apply(this.amount, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (operationType != operation.operationType) return false;
        if (dateTime != null ? !dateTime.equals(operation.dateTime) : operation.dateTime != null) return false;
        return amount != null ? amount.equals(operation.amount) : operation.amount == null;
    }

    @Override
    public int hashCode() {
        int result = operationType != null ? operationType.hashCode() : 0;
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
