package kata.banking.domain;

import java.util.List;

public interface BankRepository {

    List<Operation> findOperations();

    void addOperation(Operation operation);
}
