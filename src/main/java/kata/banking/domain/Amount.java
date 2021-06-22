package kata.banking.domain;

import java.math.BigDecimal;

public class Amount {

    private final BigDecimal value;

    private Amount(BigDecimal value) {
        this.value = value;
    }

    public static Amount of(BigDecimal value) {
        return new Amount(value);
    }

    public static Amount of(Long value) {
        return Amount.of(BigDecimal.valueOf(value));
    }

    public BigDecimal getValue() {
        return value;
    }
}
