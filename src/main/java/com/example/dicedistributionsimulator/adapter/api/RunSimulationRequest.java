package com.example.dicedistributionsimulator.adapter.api;

import lombok.Value;

@Value
class RunSimulationRequest {

    Integer totalNumberOfRolls;
    Integer numberOfDices;
    Integer numberOfSides;

}
