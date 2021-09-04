package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import com.example.dicedistributionsimulator.shared.ValidationMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.INVALID_ROLL_RESULT_INPUT_VALUE;
import static com.example.dicedistributionsimulator.shared.ValidationMessage.ROLL_RESULT_VALUE_SHOULD_BE_GREATER_THAN_ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RollResultUnitTest {

    @Test
    public void shouldFailIfInputValueIsNotDefined() {
        //given
        Integer inputValue = null;

        //when
        Throwable throwable = catchThrowable(() -> RollResult.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(INVALID_ROLL_RESULT_INPUT_VALUE);
    }

    @Test
    public void shouldFailIfInputValueIsEqualToZero() {
        //given
        Integer inputValue = 0;

        //when
        Throwable throwable = catchThrowable(() -> RollResult.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(ROLL_RESULT_VALUE_SHOULD_BE_GREATER_THAN_ZERO);
    }

    @Test
    public void shouldFailIfInputValueIsLessThanZero() {
        //given
        Integer inputValue = -1;

        //when
        Throwable throwable = catchThrowable(() -> RollResult.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(ROLL_RESULT_VALUE_SHOULD_BE_GREATER_THAN_ZERO);
    }

    @Test
    public void shouldPassIfInputValueIsGreaterThanZero() {
        //given
        Integer inputValue = 1;

        //when
        RollResult rollResult = RollResult.of(inputValue);

        //then
        assertThat(rollResult).isNotNull();
        assertThat(rollResult.getValue()).isEqualTo(1);
    }
}
