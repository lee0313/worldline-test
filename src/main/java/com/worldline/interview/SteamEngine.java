package com.worldline.interview;

import java.util.List;

public class SteamEngine extends AbstractEngine {

    private static final int BATCH_SIZE = 2;

    public SteamEngine(List<FuelType> requiredFuelTypes) {
        // Given the default batch size 2 for steam engine.
        super(requiredFuelTypes, BATCH_SIZE);
        boolean isValidFuelType = requiredFuelTypes.stream().
            allMatch(fuelType -> fuelType == FuelType.WOOD || fuelType == FuelType.COAL);
        if (!isValidFuelType) {
            throw new IllegalArgumentException("Required fuel types must include only WOOD or COAL.");
        }
    }

}
