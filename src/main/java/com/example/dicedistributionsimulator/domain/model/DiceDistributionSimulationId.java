package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import com.example.dicedistributionsimulator.shared.ValidationMessage;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.INVALID_INPUT_VALUE_FOR_ID;
import static java.util.Objects.isNull;

public final class DiceDistributionSimulationId {

    private final UUID value;

    private DiceDistributionSimulationId(UUID value) {
        this.value = value;
    }

    public static DiceDistributionSimulationId create() {
        return new DiceDistributionSimulationId(UUID.randomUUID());
    }

    public static DiceDistributionSimulationId of(UUID value) {
        checkPreconditions(value);
        return new DiceDistributionSimulationId(value);
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiceDistributionSimulationId)) return false;
        DiceDistributionSimulationId that = (DiceDistributionSimulationId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DiceDistributionSimulationId.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }

    private static void checkPreconditions(UUID value) {
        if (isNull(value)) {
            throw new DiceDistributionSimulatorBusinessException(INVALID_INPUT_VALUE_FOR_ID);
        }
    }
}
