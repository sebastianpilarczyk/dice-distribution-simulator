package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.Objects;
import java.util.StringJoiner;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_DICES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMER_OF_DICES_SHOULD_BE_EQUAL_OR_GREATER_THAN_ONE;
import static java.util.Objects.isNull;

public final class NumberOfDices {

    private final Integer value;

    private NumberOfDices(Integer value) {
        this.value = value;
    }

    public static NumberOfDices of(Integer inputValue) {
        checkPreconditions(inputValue);
        return new NumberOfDices(inputValue);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberOfDices)) return false;
        NumberOfDices that = (NumberOfDices) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NumberOfDices.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }

    private static void checkPreconditions(Integer inputValue) {
        if (isNull(inputValue)) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_DICES_IS_REQUIRED);
        }
        if (inputValue < 1) {
            throw new DiceDistributionSimulatorBusinessException(NUMER_OF_DICES_SHOULD_BE_EQUAL_OR_GREATER_THAN_ONE);
        }
    }
}
