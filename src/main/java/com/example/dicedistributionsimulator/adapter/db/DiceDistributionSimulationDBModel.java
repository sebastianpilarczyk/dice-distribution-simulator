package com.example.dicedistributionsimulator.adapter.db;

import com.example.dicedistributionsimulator.domain.model.DiceDistributionSimulator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "dice_distribution_simulations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class DiceDistributionSimulationDBModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dice_distribution_simulation_id", nullable = false)
    private UUID diceDistributionSimulationId;

    @Column(name = "total_number_of_rolls")
    private Integer totalNumberOfRolls;

    @Column(name = "number_of_dices")
    private Integer numberOfDices;

    @Column(name = "number_of_sides")
    private Integer numberOfSides;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "dice_distribution_simulation_db_model_id", nullable = false)
    private List<SumOfRollDbModel> sumsOfRolls = new ArrayList<>();

    private DiceDistributionSimulationDBModel(Builder builder) {
        this.id = builder.id;
        this.diceDistributionSimulationId = builder.diceDistributionSimulationId;
        this.totalNumberOfRolls = builder.totalNumberOfRolls;
        this.numberOfDices = builder.numberOfDices;
        this.numberOfSides = builder.numberOfSides;
        this.sumsOfRolls = builder.sumsOfRolls;
    }

    static DiceDistributionSimulationDBModel toDbModel(DiceDistributionSimulator domainModel) {
        return new Builder()
                .id(null)
                .diceDistributionSimulationId(domainModel.getDiceDistributionSimulationId().getValue())
                .totalNumberOfRolls(domainModel.getTotalNumberOfRolls().getValue())
                .numberOfDices(domainModel.getNumberOfDices().getValue())
                .numberOfSides(findNumberOfSides(domainModel))
                .sumsOfRolls(SumOfRollDbModel.toDbModel(domainModel.getSimulationResults()))
                .build();
    }

    static class Builder {

        private Long id;
        private UUID diceDistributionSimulationId;
        private Integer totalNumberOfRolls;
        private Integer numberOfDices;
        private Integer numberOfSides;
        private List<SumOfRollDbModel> sumsOfRolls;

        Builder id(Long id) {
            this.id = id;
            return this;
        }

        Builder diceDistributionSimulationId(UUID diceDistributionSimulationId) {
            this.diceDistributionSimulationId = diceDistributionSimulationId;
            return this;
        }

        Builder totalNumberOfRolls(Integer totalNumberOfRolls) {
            this.totalNumberOfRolls = totalNumberOfRolls;
            return this;
        }

        Builder numberOfDices(Integer numberOfDices) {
            this.numberOfDices = numberOfDices;
            return this;
        }

        Builder numberOfSides(Integer numberOfSides) {
            this.numberOfSides = numberOfSides;
            return this;
        }

        Builder sumsOfRolls(List<SumOfRollDbModel> sumsOfRolls) {
            this.sumsOfRolls = sumsOfRolls;
            return this;
        }

        DiceDistributionSimulationDBModel build() {
            return new DiceDistributionSimulationDBModel(this);
        }

    }

    private static Integer findNumberOfSides(DiceDistributionSimulator domainModel) {
        return domainModel.getDices().getDicesToRoll().stream().findFirst().get().getSides();
    }
}
