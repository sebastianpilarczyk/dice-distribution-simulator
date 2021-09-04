package com.example.dicedistributionsimulator.adapter.api;

import lombok.Value;

import java.util.Map;
import java.util.UUID;

@Value
class RunSimulationResponse {

    UUID simulationId;
    Map<Integer, Long> sumOfRollToItsOccurrences;

}
