package com.example.dicedistributionsimulator.adapter.db;

import com.example.dicedistributionsimulator.domain.port.view.TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface JpaDiceDistributionSimulationDBModelRepository extends JpaRepository<DiceDistributionSimulationDBModel, Long> {

    @Query("SELECT new com.example.dicedistributionsimulator.domain.port.view.TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView(" +
            "d.numberOfDices, d.numberOfSides, " +
            "count(distinct s.diceDistributionSimulationDBModelId), " +
            "(SELECT SUM(totalNumberOfRolls) FROM DiceDistributionSimulationDBModel WHERE numberOfDices = d.numberOfDices AND numberOfSides = d.numberOfSides)" +
            ") FROM DiceDistributionSimulationDBModel d " +
            "LEFT JOIN d.sumsOfRolls s GROUP BY d.numberOfDices, d.numberOfSides")
    List<TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView> getSummaryGroupedByDiceNumberAndDiceSides();
}
