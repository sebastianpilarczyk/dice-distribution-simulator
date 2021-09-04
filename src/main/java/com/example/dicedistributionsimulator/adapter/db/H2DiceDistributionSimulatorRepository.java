package com.example.dicedistributionsimulator.adapter.db;

import com.example.dicedistributionsimulator.domain.model.DiceDistributionSimulator;
import com.example.dicedistributionsimulator.domain.port.DiceDistributionSimulatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class H2DiceDistributionSimulatorRepository implements DiceDistributionSimulatorRepository {

    private final JpaDiceDistributionSimulationDBModelRepository jpaRepository;

    @Override
    public void save(DiceDistributionSimulator diceDistributionSimulator) {
        DiceDistributionSimulationDBModel diceDistributionSimulationDBModel = DiceDistributionSimulationDBModel.toDbModel(diceDistributionSimulator);
        jpaRepository.save(diceDistributionSimulationDBModel);
    }
}
