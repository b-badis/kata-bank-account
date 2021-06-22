package kata.banking.infra;

import kata.banking.domain.BankRepository;
import kata.banking.domain.Operation;

import java.util.List;

public class InMemoryBankRepository implements BankRepository {
    @Override
    public List<Operation> findOperations() {
        return null;
    }

    @Override
    public void addOperation(Operation operation) {

    }
}
