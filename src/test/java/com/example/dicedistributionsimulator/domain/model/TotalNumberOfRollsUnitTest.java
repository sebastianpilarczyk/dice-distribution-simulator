package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.junit.jupiter.api.Test;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.TOTAL_NUMER_OF_ROLLS_SHOULD_BE_GREATER_OR_EQUAL_TO_ONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class TotalNumberOfRollsUnitTest {

    @Test
    public void shouldFailIfInputValueIsNotDefined() {
        //given
        Integer inputValue = null;

        //when
        Throwable throwable = catchThrowable(() -> TotalNumberOfRolls.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(TOTAL_NUMBER_OF_ROLLS_IS_REQUIRED);
    }

    @Test
    public void shouldFailIfInputValueIsLessThanOne() {
        //given
        Integer inputValue = 0;

        //when
        Throwable throwable = catchThrowable(() -> TotalNumberOfRolls.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(TOTAL_NUMER_OF_ROLLS_SHOULD_BE_GREATER_OR_EQUAL_TO_ONE);
    }

    @Test
    public void shouldPassIfInputValueIsEqualToOne() {
        //given
        Integer inputValue = 1;

        //when
        TotalNumberOfRolls totalNumberOfRolls = TotalNumberOfRolls.of(inputValue);

        //then
        assertThat(totalNumberOfRolls).isNotNull();
        assertThat(totalNumberOfRolls.getValue()).isEqualTo(1);
    }

    @Test
    public void shouldPassIfInputValueIsGreaterThanOne() {
        //given
        Integer inputValue = 4;

        //when
        TotalNumberOfRolls totalNumberOfRolls = TotalNumberOfRolls.of(inputValue);

        //then
        assertThat(totalNumberOfRolls).isNotNull();
        assertThat(totalNumberOfRolls.getValue()).isEqualTo(4);
    }
}
