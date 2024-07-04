package main.java.vehicles.carbrands;

import main.java.vehicles.Car;

public class BMW extends Car {
    private final String brandName;

    public BMW(double fuelTankSize,
               String fuelType,
               int gears,
               double consumptionPer100km,
               double availableFuel,
               int tireSize) {

        super(fuelTankSize, fuelType, gears, consumptionPer100km, availableFuel, tireSize);

        this.brandName = "BMW";
    }

    public String getBrandName() {
        return this.brandName;
    }
}
