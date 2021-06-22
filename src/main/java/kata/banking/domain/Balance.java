package kata.banking.domain;

import java.math.BigDecimal;

public class Balance {

    private final BigDecimal value;

    private Balance(BigDecimal value) {
        this.value = value;
        check();
    }

    public static Balance zero() {
        return Balance.of(BigDecimal.ZERO);
    }

    public static Balance of(BigDecimal value) {
        return new Balance(value);
    }

    public static Balance of(Long value) {
        return Balance.of(BigDecimal.valueOf(value));
    }

    public BigDecimal getValue() {
        return value;
    }

    void check() {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidBalanceException("Balance must be positive");
        }
    }
}
