package com.worldline.interview;

public enum FuelType {

    PETROL(9),
    DIESEL(12),
    WOOD(4.35),
    COAL(5.65);

    double batchCost;

    FuelType(double batchCost) {
        this.batchCost = batchCost;
    }

    public double getBatchCost() {
        return batchCost;
    }

}
