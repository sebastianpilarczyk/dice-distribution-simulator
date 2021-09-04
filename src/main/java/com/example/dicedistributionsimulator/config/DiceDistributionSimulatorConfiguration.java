package com.example.dicedistributionsimulator.config;

import com.example.dicedistributionsimulator.domain.port.DiceDistributionSimulatorRepository;
import com.example.dicedistributionsimulator.domain.port.DiceDistributionSimulatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DiceDistributionSimulatorConfiguration {

    @Bean
    DiceDistributionSimulatorService diceDistributionSimulatorService(DiceDistributionSimulatorRepository repository) {
        return new DiceDistributionSimulatorService(repository);
    }
}
