package com.example.dicedistributionsimulator.domain.port;

import com.example.dicedistributionsimulator.domain.port.view.DataForRelativeDistributionCalculationView;
import com.example.dicedistributionsimulator.domain.port.view.TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView;

import java.util.List;

public interface DiceDistributionSimulationReadRepository {

    List<TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView> getSummaryGroupedByDiceNumberAndDiceSides();

    List<DataForRelativeDistributionCalculationView> getDataForRelativeDistributionCalculation(Integer numberOfDices, Integer numberOfSides);

}
