package com.example.dicedistributionsimulator.domain.port.view;

import lombok.Value;

@Value
public class TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView {

    Integer diceNumber;
    Integer diceSide;
    Long totalNumberOfSimulations;
    Long totalNumberOfRollsMade;

}
