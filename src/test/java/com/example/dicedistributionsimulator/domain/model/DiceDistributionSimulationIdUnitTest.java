package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.INVALID_INPUT_VALUE_FOR_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DiceDistributionSimulationIdUnitTest {

    @Test
    public void shouldPassIfCreatingNewId() {
        //when
        DiceDistributionSimulationId diceDistributionSimulationId = DiceDistributionSimulationId.create();

        //then
        assertThat(diceDistributionSimulationId).isNotNull();
        assertThat(diceDistributionSimulationId.getValue()).isNotNull();
    }

    @Test
    public void shouldFailIfInputValueIsNotDefined() {
        //given
        UUID inputValue = null;

        //when
        Throwable throwable = catchThrowable(() -> DiceDistributionSimulationId.of(inputValue));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(INVALID_INPUT_VALUE_FOR_ID);
    }

    @Test
    public void shouldPassIfInputValueIsCorrect() {
        //given
        UUID inputValue = UUID.randomUUID();

        //when
        DiceDistributionSimulationId diceDistributionSimulationId = DiceDistributionSimulationId.of(inputValue);

        //then
        assertThat(diceDistributionSimulationId).isNotNull();
        assertThat(diceDistributionSimulationId.getValue()).isNotNull();
    }
}
