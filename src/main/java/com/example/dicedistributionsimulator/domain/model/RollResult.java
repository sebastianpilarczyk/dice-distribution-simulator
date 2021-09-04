package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.Objects;
import java.util.StringJoiner;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.INVALID_ROLL_RESULT_INPUT_VALUE;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.ROLL_RESULT_VALUE_SHOULD_BE_GREATER_THAN_ZERO;
import static java.util.Objects.isNull;

public final class RollResult {

    private final Integer value;

    private RollResult(Integer value) {
        this.value = value;
    }

    public static RollResult of(Integer rollValue) {
        checkPreconditions(rollValue);
        return new RollResult(rollValue);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RollResult)) return false;
        RollResult that = (RollResult) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RollResult.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }

    private static void checkPreconditions(Integer rollValue) {
        if (isNull(rollValue)) {
            throw new DiceDistributionSimulatorBusinessException(INVALID_ROLL_RESULT_INPUT_VALUE);
        }
        if (rollValue <= 0) {
            throw new DiceDistributionSimulatorBusinessException(ROLL_RESULT_VALUE_SHOULD_BE_GREATER_THAN_ZERO);
        }
    }
}
