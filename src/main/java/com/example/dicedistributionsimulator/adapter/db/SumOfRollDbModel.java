package com.example.dicedistributionsimulator.adapter.db;

import com.example.dicedistributionsimulator.domain.model.SimulationResults;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "sums_of_rolls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class SumOfRollDbModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer sum;

    @Column(name = "dice_distribution_simulation_db_model_id", nullable = false, insertable = false, updatable = false)
    private Long diceDistributionSimulationDBModelId;

    static List<SumOfRollDbModel> toDbModel(SimulationResults simulationResults) {
        return simulationResults.getValues().stream()
                .map(sum -> new SumOfRollDbModel(null, sum, null))
                .collect(toList());
    }
}

