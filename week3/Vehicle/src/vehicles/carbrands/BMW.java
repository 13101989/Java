package vehicles.carbrands;

import vehicles.Car;

public abstract class BMW extends Car {

    public BMW(float fuelTankSize,
               String fuelType,
               int gears,
               float consumptionPer100km,
               float availableFuel,
               int tireSize) {

        super(fuelTankSize, fuelType, gears, consumptionPer100km, availableFuel, tireSize);
    }
}
