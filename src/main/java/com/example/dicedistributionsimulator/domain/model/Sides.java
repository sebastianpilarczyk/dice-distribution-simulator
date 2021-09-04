package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.Objects;
import java.util.StringJoiner;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_SHOULD_BE_GREATER_OR_EQUAL_TO_FOUR;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_SHOULD_NOT_BE_AN_ODD_NUMBER;
import static java.util.Objects.isNull;

public final class Sides {

    private static final int MINIMUM_VALUE_FOR_SIDE = 1;
    private static final int MINIMUM_NUMBER_OF_SIDES = 4;

    private final Integer value;

    private Sides(Integer value) {
        this.value = value;
    }

    public static Sides of(Integer numberOfSides) {
        checkPreconditions(numberOfSides);
        return new Sides(numberOfSides);
    }

    public int getNumberOfSides() {
        return value;
    }

    public int getMinimumValueOnSide() {
        return MINIMUM_VALUE_FOR_SIDE;
    }

    public int getMaximumValueOnSide() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sides)) return false;
        Sides sides = (Sides) o;
        return value.equals(sides.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Sides.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }

    private static void checkPreconditions(Integer numberOfSides) {
        if (isNull(numberOfSides)) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_SIDES_IS_REQUIRED);
        }
        if (numberOfSides < MINIMUM_NUMBER_OF_SIDES) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_SIDES_SHOULD_BE_GREATER_OR_EQUAL_TO_FOUR);
        }
        if (numberOfSides % 2 != 0) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_SIDES_SHOULD_NOT_BE_AN_ODD_NUMBER);
        }
    }
}
