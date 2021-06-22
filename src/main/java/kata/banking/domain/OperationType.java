package kata.banking.domain;

import java.util.function.BiFunction;

public enum OperationType implements BiFunction<Amount, Amount, Amount> {
    DEPOSIT(Amount::addAmount), WITHDRAW(Amount::subtractAmount);

    private final BiFunction<Amount, Amount, Amount> function;

    OperationType(BiFunction<Amount, Amount, Amount> function) {
        this.function = function;
    }

    @Override
    public Amount apply(Amount amount1, Amount amount2) {
        return function.apply(amount1, amount2);
    }
}
