package com.example.dicedistributionsimulator.domain.port;

import com.example.dicedistributionsimulator.domain.model.DiceDistributionSimulator;

public interface DiceDistributionSimulatorRepository {

    void save(DiceDistributionSimulator diceDistributionSimulator);

}
