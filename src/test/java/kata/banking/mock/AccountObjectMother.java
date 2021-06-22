package kata.banking.mock;

import kata.banking.domain.Account;
import kata.banking.domain.BankRepository;

public class AccountObjectMother {

    private final BankRepository bankRepository;

    public AccountObjectMother(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Account newAccount() {
        return new Account(bankRepository);
    }
}
