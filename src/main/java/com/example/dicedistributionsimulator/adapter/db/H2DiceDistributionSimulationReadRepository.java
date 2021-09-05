package com.example.dicedistributionsimulator.adapter.db;

import com.example.dicedistributionsimulator.domain.port.DiceDistributionSimulationReadRepository;
import com.example.dicedistributionsimulator.domain.port.view.DataForRelativeDistributionCalculationView;
import com.example.dicedistributionsimulator.domain.port.view.TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class H2DiceDistributionSimulationReadRepository implements DiceDistributionSimulationReadRepository {

    private final JpaDiceDistributionSimulationDBModelRepository jpaRepository;

    @Override
    public List<TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView> getSummaryGroupedByDiceNumberAndDiceSides() {
        return jpaRepository.getSummaryGroupedByDiceNumberAndDiceSides();
    }

    @Override
    public List<DataForRelativeDistributionCalculationView> getDataForRelativeDistributionCalculation(Integer numberOfDices, Integer numberOfSides) {
        return jpaRepository.getDataForRelativeDistributionCalculation(numberOfDices, numberOfSides);
    }
}
