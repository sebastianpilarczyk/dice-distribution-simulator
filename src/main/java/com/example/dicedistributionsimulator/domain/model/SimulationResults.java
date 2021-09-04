package com.example.dicedistributionsimulator.domain.model;

import com.example.dicedistributionsimulator.shared.DiceDistributionSimulatorBusinessException;

import java.util.ArrayList;
import java.util.List;

import static com.example.dicedistributionsimulator.shared.ValidationMessage.SIMULATION_RESULTS_ARE_EMPTY;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.isNull;

public final class SimulationResults {

    private final List<Integer> values;

    private SimulationResults(List<Integer> values) {
        this.values = values;
    }

    public static SimulationResults create() {
        return new SimulationResults(new ArrayList<>());
    }

    public static SimulationResults of(List<Integer> values) {
        if (isNull(values) || values.isEmpty()) {
            throw new DiceDistributionSimulatorBusinessException(SIMULATION_RESULTS_ARE_EMPTY);
        }
        return new SimulationResults(values);
    }

    public List<Integer> getValues() {
        return unmodifiableList(values);
    }

    public void appendSimulationResult(Integer value) {
        if (isNull(value)) {
            return;
        }
        this.values.add(value);
    }
}
