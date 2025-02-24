package com.worldline.interview;

import java.util.Collections;

public class WidgetMachine {
    private AbstractEngine engine;

    public WidgetMachine() {
        // Given default engine supports original WidgetMachine.
        this.engine = new InternalCombustionEngine(Collections.singletonList(FuelType.PETROL));
    }

    public WidgetMachine(AbstractEngine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        this.engine.start();
        double cost = 0;

        if (this.engine.isRunning()) {
            cost = produce(quantity);
        }

        this.engine.stop();

        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;

        while (batch < quantity) {

            batch = batch + this.engine.getBatchSize();
            batchCount++;
        }

        double costPerBatch = this.engine.getFuelType().getBatchCost();

        return batchCount * costPerBatch;
    }

}
