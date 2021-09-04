package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.Objects;
import java.util.StringJoiner;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.TOTAL_NUMER_OF_ROLLS_SHOULD_BE_GREATER_OR_EQUAL_TO_ONE;
import static java.util.Objects.isNull;

public final class TotalNumberOfRolls {

    private final Integer value;

    private TotalNumberOfRolls(Integer value) {
        this.value = value;
    }

    public static TotalNumberOfRolls of(Integer inputValue) {
        checkPreconditions(inputValue);
        return new TotalNumberOfRolls(inputValue);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotalNumberOfRolls)) return false;
        TotalNumberOfRolls that = (TotalNumberOfRolls) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TotalNumberOfRolls.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }

    private static void checkPreconditions(Integer inputValue) {
        if (isNull(inputValue)) {
            throw new DiceDistributionSimulatorBusinessException(TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED);
        }
        if (inputValue < 1) {
            throw new DiceDistributionSimulatorBusinessException(TOTAL_NUMER_OF_ROLLS_SHOULD_BE_GREATER_OR_EQUAL_TO_ONE);
        }
    }
}
