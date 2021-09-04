package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.function.Function;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_DICES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED;
import static java.util.Objects.isNull;

public class DiceDistributionSimulator {

    private final DiceDistributionSimulationId diceDistributionSimulationId;
    private final TotalNumberOfRolls totalNumberOfRolls;
    private final NumberOfDices numberOfDices;
    private final Dices dices;
    private final SimulationResults simulationResults;

    private DiceDistributionSimulator(DiceDistributionSimulationId diceDistributionSimulationId, TotalNumberOfRolls totalNumberOfRolls, NumberOfDices numberOfDices, Dices dices, SimulationResults simulationResults) {
        this.diceDistributionSimulationId = diceDistributionSimulationId;
        this.totalNumberOfRolls = totalNumberOfRolls;
        this.numberOfDices = numberOfDices;
        this.dices = dices;
        this.simulationResults = simulationResults;
    }

    public static DiceDistributionSimulator create(TotalNumberOfRolls totalNumberOfRolls, NumberOfDices numberOfDices, Sides sides) {
        checkPreconditions(totalNumberOfRolls, numberOfDices, sides);
        return new DiceDistributionSimulator(DiceDistributionSimulationId.create(), totalNumberOfRolls, numberOfDices, Dices.of(numberOfDices, sides), SimulationResults.create());
    }

    public DiceDistributionSimulationId getDiceDistributionSimulationId() {
        return diceDistributionSimulationId;
    }

    public TotalNumberOfRolls getTotalNumberOfRolls() {
        return totalNumberOfRolls;
    }

    public NumberOfDices getNumberOfDices() {
        return numberOfDices;
    }

    public Dices getDices() {
        return dices;
    }

    public SimulationResults getSimulationResults() {
        return simulationResults;
    }

    public void roll() {
        for (int i = 0; i < totalNumberOfRolls.getValue(); i++) {
            Integer sumOfOneRoll = dices.getDicesToRoll().stream()
                    .map(runDiceRollOnly())
                    .map(Dice::getRollResult)
                    .reduce(Integer::sum)
                    .orElseThrow(IllegalStateException::new);
            simulationResults.appendSimulationResult(sumOfOneRoll);
        }
    }

    private static void checkPreconditions(TotalNumberOfRolls totalNumberOfRolls, NumberOfDices numberOfDices, Sides sides) {
        if (isNull(totalNumberOfRolls)) {
            throw new DiceDistributionSimulatorBusinessException(TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED);
        }
        if (isNull(numberOfDices)) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_DICES_IS_REQUIRED);
        }
        if (isNull(sides)) {
            throw new DiceDistributionSimulatorBusinessException(NUMBER_OF_SIDES_IS_REQUIRED);
        }
    }

    private Function<Dice, Dice> runDiceRollOnly() {
        return dice -> {
            dice.roll();
            return dice;
        };
    }
}
