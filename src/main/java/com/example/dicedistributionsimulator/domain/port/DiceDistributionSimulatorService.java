package com.example.dicedistributionsimulator.domain.port;

import com.example.dicedistributionsimulator.domain.model.DiceDistributionSimulationId;
import com.example.dicedistributionsimulator.domain.model.DiceDistributionSimulator;
import com.example.dicedistributionsimulator.domain.model.NumberOfDices;
import com.example.dicedistributionsimulator.domain.model.Sides;
import com.example.dicedistributionsimulator.domain.model.TotalNumberOfRolls;
import com.example.dicedistributionsimulator.domain.port.view.DiceDistributionSimulationSummaryView;

public class DiceDistributionSimulatorService {

    private final DiceDistributionSimulatorRepository repository;

    public DiceDistributionSimulatorService(DiceDistributionSimulatorRepository repository) {
        this.repository = repository;
    }

    public DiceDistributionSimulationSummaryView createSimulation(TotalNumberOfRolls totalNumberOfRolls, NumberOfDices numberOfDices, Sides sides) {
        DiceDistributionSimulator diceDistributionSimulator = DiceDistributionSimulator.create(totalNumberOfRolls, numberOfDices, sides);
        diceDistributionSimulator.roll();
        repository.save(diceDistributionSimulator);
        return new DiceDistributionSimulationSummaryView(diceDistributionSimulator.getDiceDistributionSimulationId().getValue(), diceDistributionSimulator.getSimulationResults().getValues());
    }
}
