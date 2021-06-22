package kata.banking.domain;

import kata.banking.infra.InMemoryBankRepository;
import kata.banking.infra.InMemoryStatementPrinter;
import kata.banking.mock.AccountObjectMother;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class HistoryTest {

    private BankRepository bankRepository;
    private AccountObjectMother accountObjectMother;
    private Clock clock;
    private InMemoryStatementPrinter printer;

    @Before
    public void setUp() {
        bankRepository = new InMemoryBankRepository();
        clock = Clock.fixed(Instant.parse("2007-12-03T10:15:30.00Z"), ZoneId.systemDefault());
        printer = new InMemoryStatementPrinter();
        accountObjectMother = new AccountObjectMother(bankRepository, clock, printer);
    }

    @Test
    public void handleHistoryForNewAccount() {
        Account newAccount = accountObjectMother.newAccount();

        newAccount.printHistory();

        Assertions.assertThat(printer.getStatement().getStatements()).hasSize(0);
    }

    @Test
    public void handleHistoryForNewAccountWithOneStatementLine() {
        Account newAccount = accountObjectMother.newAccount();
        newAccount.deposit(Amount.of(5L));

        newAccount.printHistory();

        List<StatementLine> statementLines = printer.getStatement().getStatements();
        Assertions.assertThat(statementLines).hasSize(1);
        Assertions.assertThat(statementLines)
                .contains(new StatementLine(OperationType.DEPOSIT, LocalDateTime.now(clock), Amount.of(5L), Balance.of(5L)));
    }

    @Test
    public void handleHistoryForNewAccountWithMultipleStatementLine() {
        Account newAccount = accountObjectMother.newAccount();
        newAccount.deposit(Amount.of(5L));
        newAccount.deposit(Amount.of(5L));
        newAccount.withdraw(Amount.of(5L));

        newAccount.printHistory();

        List<StatementLine> statementLines = printer.getStatement().getStatements();
        Assertions.assertThat(statementLines).hasSize(3);
        Assertions.assertThat(statementLines)
                .contains(new StatementLine(OperationType.WITHDRAW, LocalDateTime.now(clock), Amount.of(5L), Balance.of(5L)));
    }
}
