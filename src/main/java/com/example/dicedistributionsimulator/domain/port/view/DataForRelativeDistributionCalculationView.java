package com.example.dicedistributionsimulator.domain.port.view;

import lombok.Value;

@Value
public class DataForRelativeDistributionCalculationView {

    Integer numberOfDices;
    Integer numberOfSides;
    Integer sum;
    Long sumOccurred;
    Long totalNumberOfRolls;

}
