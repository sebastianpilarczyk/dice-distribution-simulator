package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.junit.jupiter.api.Test;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_SHOULD_BE_GREATER_OR_EQUAL_TO_FOUR;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_SIDES_SHOULD_NOT_BE_AN_ODD_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SidesUnitTest {

    @Test
    public void shouldFailIfInputValueIsNotDefined() {
        //given
        Integer numberOfSides = null;

        //when
        Throwable throwable = catchThrowable(() -> Sides.of(numberOfSides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getTracingId()).isNotNull();
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_SIDES_IS_REQUIRED);
    }

    @Test
    public void shouldFailIfInputValueIsLessThanFour() {
        //given
        Integer numberOfSides = 3;

        //when
        Throwable throwable = catchThrowable(() -> Sides.of(numberOfSides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getTracingId()).isNotNull();
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_SIDES_SHOULD_BE_GREATER_OR_EQUAL_TO_FOUR);
    }

    @Test
    public void shouldFailIfInputValueIsLessThanZero() {
        //given
        Integer numberOfSides = -1;

        //when
        Throwable throwable = catchThrowable(() -> Sides.of(numberOfSides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getTracingId()).isNotNull();
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_SIDES_SHOULD_BE_GREATER_OR_EQUAL_TO_FOUR);
    }

    @Test
    public void shouldFailIfNumberOfSidesIsAnOddNumber() {
        //given
        Integer numberOfSides = 5;

        //when
        Throwable throwable = catchThrowable(() -> Sides.of(numberOfSides));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getTracingId()).isNotNull();
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_SIDES_SHOULD_NOT_BE_AN_ODD_NUMBER);
    }

    @Test
    public void shouldPassIfNumerOfSidesIsEqualToExpectedMinimumValue() {
        //given
        Integer numberOfSides = 4;

        //when
        Sides sides = Sides.of(numberOfSides);

        //then
        assertThat(sides).isNotNull();
        assertThat(sides.getNumberOfSides()).isEqualTo(4);
    }

    @Test
    public void shouldPassIfNumerOfSidesIsAEvenNumberGreaterThanMinimumOne() {
        //given
        Integer numberOfSides = 8;

        //when
        Sides sides = Sides.of(numberOfSides);

        //then
        assertThat(sides).isNotNull();
        assertThat(sides.getNumberOfSides()).isEqualTo(8);
    }

    @Test
    public void shouldReturnOneAsAMinimumValueForSide() {
        //given
        Integer numberOfSides = 8;

        //when
        Sides sides = Sides.of(numberOfSides);

        //then
        assertThat(sides.getMinimumValueOnSide()).isEqualTo(1);
    }

    @Test
    public void shouldReturnInputNumberOfSidesAsAMaximumValueForSide() {
        //given
        Integer numberOfSides = 8;

        //when
        Sides sides = Sides.of(numberOfSides);

        //then
        assertThat(sides.getMaximumValueOnSide()).isEqualTo(8);
    }
}
