package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.junit.jupiter.api.Test;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_DICES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DiceDistributionSimulatorUnitTest {

    private static final int CORRECT_TOTAL_NUMBER_OF_ROLLS = 5;
    private static final int CORRECT_NUMBER_OF_DICES = 3;
    private static final int CORRECT_NUMBER_OF_SIDES = 6;

    @Test
    public void shouldFailIfTotalNumberOfRollsIsNotDefined() {
        //given
        TotalNumberOfRolls totalNumberOfRolls = null;
        NumberOfDices numberOfDices = NumberOfDices.of(CORRECT_NUMBER_OF_DICES);
        Sides sides = Sides.of(CORRECT_NUMBER_OF_SIDES);

        //when
        Throwable throwable = catchThrowable(() -> DiceDistributionSimulator.create(totalNumberOfRolls, numberOfDices, sides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED);
    }

    @Test
    public void shouldFailIfNumberOfDicesIsNotDefined() {
        //given
        TotalNumberOfRolls totalNumberOfRolls = TotalNumberOfRolls.of(CORRECT_TOTAL_NUMBER_OF_ROLLS);
        NumberOfDices numberOfDices = null;
        Sides sides = Sides.of(CORRECT_NUMBER_OF_SIDES);

        //when
        Throwable throwable = catchThrowable(() -> DiceDistributionSimulator.create(totalNumberOfRolls, numberOfDices, sides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_DICES_IS_REQUIRED);
    }

    @Test
    public void shouldFailIfSidesIsNotDefined() {
        //given
        TotalNumberOfRolls totalNumberOfRolls = TotalNumberOfRolls.of(CORRECT_TOTAL_NUMBER_OF_ROLLS);
        NumberOfDices numberOfDices = NumberOfDices.of(CORRECT_NUMBER_OF_DICES);
        Sides sides = null;

        //when
        Throwable throwable = catchThrowable(() -> DiceDistributionSimulator.create(totalNumberOfRolls, numberOfDices, sides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_SIDES_IS_REQUIRED);
    }

    @Test
    public void shouldPassIfInputParametersHaveBeenDefinedCorrectly() {
        //given
        TotalNumberOfRolls totalNumberOfRolls = TotalNumberOfRolls.of(CORRECT_TOTAL_NUMBER_OF_ROLLS);
        NumberOfDices numberOfDices = NumberOfDices.of(CORRECT_NUMBER_OF_DICES);
        Sides sides = Sides.of(CORRECT_NUMBER_OF_SIDES);

        //when
        DiceDistributionSimulator diceDistributionSimulator = DiceDistributionSimulator.create(totalNumberOfRolls, numberOfDices, sides);

        //then
        assertThat(diceDistributionSimulator).isNotNull();
    }

    @Test
    public void shouldCreateFiveSimulationResults() {
        //given
        TotalNumberOfRolls totalNumberOfRolls = TotalNumberOfRolls.of(CORRECT_TOTAL_NUMBER_OF_ROLLS);
        NumberOfDices numberOfDices = NumberOfDices.of(CORRECT_NUMBER_OF_DICES);
        Sides sides = Sides.of(CORRECT_NUMBER_OF_SIDES);
        DiceDistributionSimulator diceDistributionSimulator = DiceDistributionSimulator.create(totalNumberOfRolls, numberOfDices, sides);

        //when
        diceDistributionSimulator.roll();

        //then
        assertThat(diceDistributionSimulator.getSimulationResults().getValues()).isNotNull();
        assertThat(diceDistributionSimulator.getSimulationResults().getValues().size()).isEqualTo(CORRECT_TOTAL_NUMBER_OF_ROLLS);
    }
}
