package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.junit.jupiter.api.Test;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMBER_OF_DICES_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.NUMER_OF_DICES_SHOULD_BE_EQUAL_OR_GREATER_THAN_ONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NumberOfDicesUnitTest {

    @Test
    public void shouldFailIfInputValueIsNotDefined() {
        //given
        Integer inputValue = null;

        //when
        Throwable throwable = catchThrowable(() -> NumberOfDices.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMBER_OF_DICES_IS_REQUIRED);
    }

    @Test
    public void shouldFailIfInputValueIsLessThanOne() {
        //given
        Integer inputValue = 0;

        //when
        Throwable throwable = catchThrowable(() -> NumberOfDices.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(NUMER_OF_DICES_SHOULD_BE_EQUAL_OR_GREATER_THAN_ONE);
    }

    @Test
    public void shouldPassIfInputValueIsEqualToOne() {
        //given
        Integer inputValue = 1;

        //when
        NumberOfDices numberOfDices = NumberOfDices.of(inputValue);

        //then
        assertThat(numberOfDices).isNotNull();
        assertThat(numberOfDices.getValue()).isEqualTo(1);
    }

    @Test
    public void shouldPassIfInputValueIsGreaterThanOne() {
        //given
        Integer inputValue = 3;

        //when
        NumberOfDices numberOfDices = NumberOfDices.of(inputValue);

        //then
        assertThat(numberOfDices).isNotNull();
        assertThat(numberOfDices.getValue()).isEqualTo(3);
    }
}
