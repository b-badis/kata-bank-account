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

    public static Amount zero() {
        return Amount.of(BigDecimal.ZERO);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Amount addAmount(Amount amount) {
        return Amount.of(value.add(amount.getValue()));
    }

    public Amount subtractAmount(Amount amount) {
        return Amount.of(value.subtract(amount.getValue()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return getValue() != null ? getValue().equals(amount.getValue()) : amount.getValue() == null;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }
}
