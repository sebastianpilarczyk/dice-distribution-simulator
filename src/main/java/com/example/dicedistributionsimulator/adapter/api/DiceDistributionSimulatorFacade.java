package com.example.dicedistributionsimulator.adapter.api;

import com.example.dicedistributionsimulator.domain.model.NumberOfDices;
import com.example.dicedistributionsimulator.domain.model.Sides;
import com.example.dicedistributionsimulator.domain.model.TotalNumberOfRolls;
import com.example.dicedistributionsimulator.domain.port.DiceDistributionSimulationReadRepository;
import com.example.dicedistributionsimulator.domain.port.DiceDistributionSimulatorService;
import com.example.dicedistributionsimulator.domain.port.view.DiceDistributionSimulationSummaryView;
import com.example.dicedistributionsimulator.domain.port.view.TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
@Transactional
@RequiredArgsConstructor
class DiceDistributionSimulatorFacade {

    private final DiceDistributionSimulatorService service;
    private final DiceDistributionSimulationReadRepository readRepository;

    public RunSimulationResponse runSimulation(RunSimulationRequest runSimulationRequest) {
        TotalNumberOfRolls totalNumberOfRolls = TotalNumberOfRolls.of(runSimulationRequest.getTotalNumberOfRolls());
        NumberOfDices numberOfDices = NumberOfDices.of(runSimulationRequest.getNumberOfDices());
        Sides sides = Sides.of(runSimulationRequest.getNumberOfSides());
        DiceDistributionSimulationSummaryView simulation = service.createSimulation(totalNumberOfRolls, numberOfDices, sides);
        return createRunSimulationResponse(simulation);
    }

    @Transactional(readOnly = true)
    public List<TotalNumberOfSimulationsAndRollsMadeGroupedByDiceNumberAndDiceSidesView> getSummaryGroupedByDiceNumberAndDiceSides() {
        return readRepository.getSummaryGroupedByDiceNumberAndDiceSides();
    }

    private RunSimulationResponse createRunSimulationResponse(DiceDistributionSimulationSummaryView simulation) {
        Map<Integer, Long> sumOfRollToItsOccurrences = simulation.getResults().stream()
                .collect(groupingBy(identity(), counting()));
        return new RunSimulationResponse(simulation.getSimulationId(), sumOfRollToItsOccurrences);
    }
}
