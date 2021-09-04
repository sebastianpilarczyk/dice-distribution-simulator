package com.example.dicedistributionsimulator.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dice-distribution-simulator")
@RequiredArgsConstructor
class DiceDistributionSimulationController {

    private final DiceDistributionSimulatorFacade facade;

    @PostMapping
    public RunSimulationResponse runSimulation(@RequestBody RunSimulationRequest requestBody) {
        return facade.runSimulation(requestBody);
    }
}
