package com.worldline.interview;

import java.util.List;
import java.util.Objects;

public abstract class AbstractEngine {

    private boolean running;
    private int fuelLevel;
    private List<FuelType> requiredFuelTypes;
    private FuelType fuelType;

    private int batchSize;

    protected AbstractEngine(List<FuelType> requiredFuelTypes, int batchSize) {
        this.requiredFuelTypes = requiredFuelTypes;
        this.running = false;
        this.fuelLevel = 0;
        this.batchSize = batchSize;
    }

    public void start() {
        if (fuelType == null) {
            throw new IllegalStateException("Fuel type is not set.");
        }
        if (fuelLevel > 0 && requiredFuelTypes.contains(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (Objects.isNull(fuelType) || !requiredFuelTypes.contains(fuelType)) {
            throw new IllegalArgumentException("Fuel type is not supported.");
        }
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return  this.fuelType;
    }

    public List<FuelType> getRequiredFuelTypes() {
        return this.requiredFuelTypes;
    }

    public int getFuelLevel() {
        return this.fuelLevel;
    }

    public int getBatchSize() {
        return this.batchSize;
    }
}
