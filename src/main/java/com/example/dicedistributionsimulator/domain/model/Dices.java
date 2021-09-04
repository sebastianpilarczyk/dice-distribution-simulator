package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_DICES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.isNull;

public final class Dices {

    private final List<Dice> dicesToRoll;

    private Dices(List<Dice> dicesToRoll) {
        this.dicesToRoll = dicesToRoll;
    }

    public static Dices of(NumberOfDices numberOfDices, Sides sides) {
        checkPreconditions(numberOfDices, sides);
        List<Dice> dicesToRoll = new ArrayList<>();
        for (int i = 0; i < numberOfDices.getValue(); i++) {
            dicesToRoll.add(Dice.of(sides));
        }
        return new Dices(unmodifiableList(dicesToRoll));
    }

    public List<Dice> getDicesToRoll() {
        return dicesToRoll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dices)) return false;
        Dices dices = (Dices) o;
        return dicesToRoll.equals(dices.dicesToRoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dicesToRoll);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dices.class.getSimpleName() + "[", "]")
                .add("dicesToRoll=" + dicesToRoll)
                .toString();
    }

    private static void checkPreconditions(NumberOfDices numberOfDices, Sides sides) {
        if (isNull(numberOfDices)) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_DICES_IS_REQUIRED);
        }
        if (isNull(sides)) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_SIDES_IS_REQUIRED);
        }
    }
}
