package kata.banking.domain;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

public class Account {

    private final BankRepository repository;
    private final Clock clock;
    private final StatementPrinter printer;

    public Account(BankRepository repository, Clock clock, StatementPrinter printer) {
        this.repository = repository;
        this.clock = clock;
        this.printer = printer;
    }

    public void deposit(Amount amount) {
        repository.addOperation(new Operation(OperationType.DEPOSIT, LocalDateTime.now(clock), amount));
    }

    public void withdraw(Amount amount) {
        calculateBalance(Amount.of(amount.getValue().negate()));
        repository.addOperation(new Operation(OperationType.WITHDRAW, LocalDateTime.now(clock), amount));
    }

    private Balance calculateBalance(Amount newAmount) {
        AtomicReference<Amount> amount = new AtomicReference<>(newAmount);
        repository.findOperations()
                .forEach(operation -> amount.set(operation.operationType.apply(amount.get(), operation.amount)));
        return Balance.of(amount.get().getValue());
    }

    public void printHistory() {

    }

}
