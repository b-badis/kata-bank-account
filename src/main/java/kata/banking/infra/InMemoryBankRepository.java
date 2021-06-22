package kata.banking.infra;

import kata.banking.domain.BankRepository;
import kata.banking.domain.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBankRepository implements BankRepository {

    List<Operation> operations = new ArrayList<>();

    @Override
    public List<Operation> findOperations() {
        return operations;
    }

    @Override
    public void addOperation(Operation operation) {
        operations.add(operation);
    }
}
