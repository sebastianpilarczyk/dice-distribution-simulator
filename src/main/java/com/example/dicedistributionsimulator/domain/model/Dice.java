package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static java.util.Objects.isNull;

public class Dice {

    private final Sides sides;
    private RollResult rollResult;

    private Dice(Sides sides, RollResult rollResult) {
        this.sides = sides;
        this.rollResult = rollResult;
    }

    public static Dice of(Sides sides) {
        if (isNull(sides)) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_SIDES_IS_REQUIRED);
        }
        return new Dice(sides, null);
    }

    public int getSides() {
        return sides.getNumberOfSides();
    }

    public int getRollResult() {
        return rollResult.getValue();
    }

    public void roll() {
        rollResult = RollResult.of(getNextRollValue());
    }

    private Integer getNextRollValue() {
        return ThreadLocalRandom.current().nextInt(sides.getMinimumValueOnSide(), sides.getMaximumValueOnSide() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dice)) return false;
        Dice dice = (Dice) o;
        return sides.equals(dice.sides) && Objects.equals(rollResult, dice.rollResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides, rollResult);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dice.class.getSimpleName() + "[", "]")
                .add("sides=" + sides)
                .add("rollResult=" + rollResult)
                .toString();
    }
}
