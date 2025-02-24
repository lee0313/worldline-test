package com.worldline.interview;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class WidgetMachineTest {

  @Test
  public void testProduceWidgetsWithPetrol() {
    InternalCombustionEngine engine = new InternalCombustionEngine(Collections.singletonList(FuelType.PETROL));
    engine.fill(FuelType.PETROL, 50);
    WidgetMachine machine = new WidgetMachine(engine);
    double cost = machine.produceWidgets(16);
    assertEquals(18.0, cost, 0.01);
  }

  @Test
  public void testProduceWidgetsWithDiesel() {
    InternalCombustionEngine engine = new InternalCombustionEngine(Collections.singletonList(FuelType.DIESEL));
    engine.fill(FuelType.DIESEL, 50);
    WidgetMachine machine = new WidgetMachine(engine);
    double cost = machine.produceWidgets(16);
    assertEquals(24.0, cost, 0.01);
  }

  @Test
  public void testProduceWidgetsWithWood() {
    SteamEngine engine = new SteamEngine(Collections.singletonList(FuelType.WOOD));
    engine.fill(FuelType.WOOD, 50);
    WidgetMachine machine = new WidgetMachine(engine);
    double cost = machine.produceWidgets(4);
    assertEquals(8.7, cost, 0.001);
  }

  @Test
  public void testProduceWidgetsWithCoal() {
    SteamEngine engine = new SteamEngine(Collections.singletonList(FuelType.COAL));
    engine.fill(FuelType.COAL, 50);
    WidgetMachine machine = new WidgetMachine(engine);
    double cost = machine.produceWidgets(4);
    assertEquals(11.3, cost, 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFuelTypeForInternalCombustionEngine() {
    new InternalCombustionEngine(Arrays.asList(FuelType.PETROL, FuelType.WOOD));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFuelTypeForSteamEngine() {
    new SteamEngine(Arrays.asList(FuelType.WOOD, FuelType.PETROL));
  }
}
