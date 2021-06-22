package kata.banking.domain;

import kata.banking.infra.InMemoryBankRepository;
import kata.banking.mock.AccountObjectMother;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class DepositionTest {

    private BankRepository bankRepository;
    private AccountObjectMother accountObjectMother;

    @Before
    public void setUp() {
        bankRepository = new InMemoryBankRepository();
        accountObjectMother = new AccountObjectMother(bankRepository);
    }

    @Test
    public void handleNewAccountDepositCommand() {
        Account newAccount = accountObjectMother.newAccount();

        newAccount.deposit(Amount.of(5L));

        List<Operation> operations = bankRepository.findOperations();
        Assertions.assertThat(operations).hasSize(1);
        Assertions.assertThat(operations)
                .containsExactly(new Operation(OperationType.DEPOSIT, LocalDateTime.parse("2021-06-22 00:00"), Amount.of(5L)));
    }
}
