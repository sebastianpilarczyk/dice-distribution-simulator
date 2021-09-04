package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.SIMULATION_RESULTS_ARE_EMPTY;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SimulationResultsUnitTest {

    @Test
    public void shouldCreateEmpty() {
        //when
        SimulationResults simulationResults = SimulationResults.create();

        //then
        assertThat(simulationResults).isNotNull();
        assertThat(simulationResults.getValues()).isEmpty();
    }

    @Test
    public void shouldFailIfInputValuesAreNotDefined() {
        //given
        List<Integer> inputValues = null;

        //when
        Throwable throwable = catchThrowable(() -> SimulationResults.of(inputValues));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(SIMULATION_RESULTS_ARE_EMPTY);
    }

    @Test
    public void shouldFailIfInputValuesAreEmpty() {
        //given
        List<Integer> inputValues = emptyList();

        //when
        Throwable throwable = catchThrowable(() -> SimulationResults.of(inputValues));

        //then
        assertThat(throwable).isInstanceOf(DiceDistributionSimulatorBusinessException.class);
        assertThat(((DiceDistributionSimulatorBusinessException) throwable).getValidationMessage()).isEqualByComparingTo(SIMULATION_RESULTS_ARE_EMPTY);
    }

    @Test
    public void shouldPassIfGivenListOfValuesIsCorrect() {
        //given
        List<Integer> inputValues = Arrays.asList(4, 6, 11);

        //when
        SimulationResults simulationResults = SimulationResults.of(inputValues);

        //then
        assertThat(simulationResults).isNotNull();
        assertThat(simulationResults.getValues()).hasSize(3);
    }

    @Test
    public void shouldAllowAppendingResultToTheList() {
        //given
        List<Integer> inputValues = new ArrayList<>(){{
            add(4);
            add(6);
        }};
        SimulationResults simulationResults = SimulationResults.of(inputValues);

        //when
        simulationResults.appendSimulationResult(15);

        //then
        assertThat(simulationResults).isNotNull();
        assertThat(simulationResults.getValues()).hasSize(3);
    }
}
