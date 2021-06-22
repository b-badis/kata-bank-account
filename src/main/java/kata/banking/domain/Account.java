package kata.banking.domain;

import java.time.Clock;
import java.time.LocalDateTime;

public class Account {

    private final BankRepository repository;
    private final Clock clock;

    public Account(BankRepository repository, Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

    public void deposit(Amount amount) {
        repository.addOperation(new Operation(OperationType.DEPOSIT, LocalDateTime.now(clock), amount));
    }


}
