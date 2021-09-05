package com.example.dicedistributionsimulator.shared;

import com.example.dicedistributionsimulator.domain.port.view.DataForRelativeDistributionCalculationView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RelativeDistributionCalculatorUnitTest {

    public static final int NUMBER_OF_DICES = 4;
    public static final int NUMBER_OF_SIDES = 8;
    public static final int SUM = 10;

    @Test
    public void shouldReturnRightResultForFirstExample() {
        //given
        long sumOccurred = 1;
        long totalNumerOfRolls = 300;
        DataForRelativeDistributionCalculationView inputObject = new DataForRelativeDistributionCalculationView(NUMBER_OF_DICES, NUMBER_OF_SIDES, SUM, sumOccurred, totalNumerOfRolls);

        //when
        String result = RelativeDistributionCalculator.calculateInPercentage(inputObject);

        //then
        assertThat(result).isEqualTo("0.33%");
    }

    @Test
    public void shouldReturnRightResultForSecondExample() {
        //given
        long sumOccurred = 3;
        long totalNumerOfRolls = 300;
        DataForRelativeDistributionCalculationView inputObject = new DataForRelativeDistributionCalculationView(NUMBER_OF_DICES, NUMBER_OF_SIDES, SUM, sumOccurred, totalNumerOfRolls);

        //when
        String result = RelativeDistributionCalculator.calculateInPercentage(inputObject);

        //then
        assertThat(result).isEqualTo("1.0%");
    }

    @Test
    public void shouldReturnRightResultForThirdExample() {
        //given
        long sumOccurred = 7;
        long totalNumerOfRolls = 300;
        DataForRelativeDistributionCalculationView inputObject = new DataForRelativeDistributionCalculationView(NUMBER_OF_DICES, NUMBER_OF_SIDES, SUM, sumOccurred, totalNumerOfRolls);

        //when
        String result = RelativeDistributionCalculator.calculateInPercentage(inputObject);

        //then
        assertThat(result).isEqualTo("2.3%");
    }
}
