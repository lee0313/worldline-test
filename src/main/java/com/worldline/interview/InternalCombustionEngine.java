package com.worldline.interview;

import java.util.List;

public class InternalCombustionEngine extends AbstractEngine {

    private static final int BATCH_SIZE = 8;

    public InternalCombustionEngine(List<FuelType> requiredFuelTypes) {
        // Given the default batch size 8 for original engine.
        super(requiredFuelTypes, BATCH_SIZE);
        boolean isValidFuelType = requiredFuelTypes.stream().
            allMatch(fuelType -> fuelType == FuelType.PETROL || fuelType == FuelType.DIESEL);
        if (!isValidFuelType) {
            throw new IllegalArgumentException("Required fuel types must include only PETROL or DIESEL.");
        }
    }

}
