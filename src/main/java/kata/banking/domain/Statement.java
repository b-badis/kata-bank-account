package kata.banking.domain;

import java.util.List;

public class Statement {

    private final List<StatementLine> statements;
    private final StatementPrinter printer;

    public Statement(List<StatementLine> statements, StatementPrinter printer) {
        this.statements = statements;
        this.printer = printer;
    }

    public void print() {
        printer.print(this);
    }

    public List<StatementLine> getStatements() {
        return statements;
    }
}
