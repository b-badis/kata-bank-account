package kata.banking.domain;

import kata.banking.infra.InMemoryBankRepository;
import kata.banking.mock.AccountObjectMother;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class WithdrawalTest {

    private BankRepository bankRepository;
    private AccountObjectMother accountObjectMother;
    private Clock clock;

    @Before
    public void setUp() {
        bankRepository = new InMemoryBankRepository();
        clock = Clock.fixed(Instant.parse("2007-12-03T10:15:30.00Z"), ZoneId.systemDefault());
        accountObjectMother = new AccountObjectMother(bankRepository, clock);
    }

    @Test
    public void handleNewAccountWithdrawCommandWithInsufficientBalance() {
        Account newAccount = accountObjectMother.newAccount();

        Assertions.assertThatThrownBy(() -> newAccount.withdraw(Amount.of(5L))).isInstanceOf(InvalidBalanceException.class);
    }

    @Test
    public void handleOldAccountWithdrawCommandWithInsufficientBalance() {
        Account newAccount = accountObjectMother.newAccount();
        accountObjectMother.generateOperations(5);

        newAccount.deposit(Amount.of(5L));

        Assertions.assertThatThrownBy(() -> newAccount.withdraw(Amount.of(50L))).isInstanceOf(InvalidBalanceException.class);
    }

    @Test
    public void handleOldAccountWithdrawCommandWithSufficientBalance() {
        Account newAccount = accountObjectMother.newAccount();
        accountObjectMother.generateOperations(5);

        newAccount.withdraw(Amount.of(5L));

        List<Operation> operations = bankRepository.findOperations();
        Assertions.assertThat(operations).hasSize(6);
        Assertions.assertThat(operations)
                .contains(new Operation(OperationType.WITHDRAW, LocalDateTime.now(clock), Amount.of(5L)));
    }
}
