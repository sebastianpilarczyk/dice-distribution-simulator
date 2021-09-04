package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.junit.jupiter.api.Test;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_DICES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DicesUnitTest {

    @Test
    public void shouldFailIfNumberOfDicesIsNotDefined() {
        //given
        NumberOfDices numberOfDices = null;
        Sides sides = Sides.of(6);

        //when
        Throwable throwable = catchThrowable(() -> Dices.of(numberOfDices, sides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_DICES_IS_REQUIRED);
    }

    @Test
    public void shouldFailIfNumberOfSidesIsNotDefined() {
        //given
        NumberOfDices numberOfDices = NumberOfDices.of(3);
        Sides sides = null;

        //when
        Throwable throwable = catchThrowable(() -> Dices.of(numberOfDices, sides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_SIDES_IS_REQUIRED);
    }

    @Test
    public void shouldCreateFourDices() {
        //given
        NumberOfDices numberOfDices = NumberOfDices.of(3);
        Sides sides = Sides.of(6);

        //when
        Dices dices = Dices.of(numberOfDices, sides);

        //then
        assertThat(dices).isNotNull();
        assertThat(dices.getDicesToRoll()).isNotNull();
        assertThat(dices.getDicesToRoll().size()).isEqualTo(3);
    }
}
