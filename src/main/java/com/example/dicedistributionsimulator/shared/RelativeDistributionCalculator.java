package com.example.dicedistributionsimulator.shared;

import com.example.dicedistributionsimulator.domain.port.view.DataForRelativeDistributionCalculationView;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.FLOOR;

public final class RelativeDistributionCalculator {

    public static String calculateInPercentage(DataForRelativeDistributionCalculationView input) {
        BigDecimal totalNumberOfRolls = new BigDecimal(input.getTotalNumberOfRolls().toString());
        BigDecimal sumOccurred = new BigDecimal(input.getSumOccurred().toString());
        BigDecimal multiplicand = new BigDecimal("100.00");
        BigDecimal result = sumOccurred.divide(totalNumberOfRolls, 6, FLOOR).multiply(multiplicand).round(new MathContext(2, FLOOR));
        return result + "%";
    }
}
