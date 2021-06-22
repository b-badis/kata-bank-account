package kata.banking.mock;

import kata.banking.domain.*;
import org.apache.commons.lang3.RandomUtils;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountObjectMother {

    private final BankRepository bankRepository;
    private final Clock clock;

    public AccountObjectMother(BankRepository bankRepository, Clock clock) {
        this.bankRepository = bankRepository;
        this.clock = clock;
    }

    public Account newAccount() {
        return new Account(bankRepository, clock);
    }

    public List<Operation> generateOperations(int number) {
        return Stream.generate(this::generateOperation).limit(number).peek(bankRepository::addOperation).collect(Collectors.toList());
    }

    public Operation generateOperation() {
        return new Operation(OperationType.DEPOSIT, LocalDateTime.now(clock).minusDays(RandomUtils.nextLong(1, 100)), Amount.of(RandomUtils.nextLong(1, 100)));
    }
}
