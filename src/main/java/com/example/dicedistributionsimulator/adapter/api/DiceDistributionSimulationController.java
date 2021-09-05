package com.example.dicedistributionsimulator.adapter.api;

import com.example.dicedistributionsimulator.domain.port.view.TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dice-distribution-simulator")
@RequiredArgsConstructor
class DiceDistributionSimulationController {

    private final DiceDistributionSimulatorFacade facade;

    @PostMapping
    public RunSimulationResponse runSimulation(@RequestBody RunSimulationRequest requestBody) {
        return facade.runSimulation(requestBody);
    }

    @GetMapping("total-numer-of-simulations-and-rolls-made")
    public List<TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView> findAllGroupedByDiceNumberAndDiceSide() {
        return facade.getSummaryGroupedByDiceNumberAndDiceSides();
    }
}
