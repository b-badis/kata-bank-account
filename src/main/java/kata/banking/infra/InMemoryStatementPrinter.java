package kata.banking.infra;

import kata.banking.domain.Statement;
import kata.banking.domain.StatementPrinter;

public class InMemoryStatementPrinter implements StatementPrinter {

    private Statement statement;

    @Override
    public void print(Statement statement) {
        this.statement = statement;
    }

    public Statement getStatement() {
        return statement;
    }
}
