package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DiceUnitTest {

    @Test
    public void shouldFailIfNumberOfSidesIsNotDefined() {
        //given
        Sides sides = null;

        //when
        Throwable throwable = catchThrowable(() -> Dice.of(sides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_SIDES_IS_REQUIRED);
    }

    @Test
    public void shouldPassIfGivenNumberOfSidesIsInRightCondition() {
        //given
        Sides sides = Sides.of(6);

        //when
        Dice dice = Dice.of(sides);

        //then
        assertThat(dice).isNotNull();
        assertThat(dice.getSides()).isEqualTo(6);
    }

    @Test
    public void shouldSaveRollResultAfterRollAction() {
        //given
        Sides sides = Sides.of(6);
        Dice dice = Dice.of(sides);

        //when
        dice.roll();

        //then
        assertThat(dice.getRollResult()).isBetween(sides.getMinimumValueOnSide(), sides.getMaximumValueOnSide());
    }
}
