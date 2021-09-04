package com.example.dicedistributionsimulator.domain.port.view;

import java.util.List;
import java.util.UUID;

public class DiceDistributionSimulationSummaryView {

    private UUID simulationId;
    private List<Integer> results;

    public DiceDistributionSimulationSummaryView(UUID simulationId, List<Integer> results) {
        this.simulationId = simulationId;
        this.results = results;
    }

    public UUID getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(UUID simulationId) {
        this.simulationId = simulationId;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }
}
