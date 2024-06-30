package vehicles.carbrands;

import vehicles.Car;

public class Mercedes extends Car {
    private final String brandName;

    public Mercedes(double fuelTankSize,
               String fuelType,
               int gears,
               double consumptionPer100km,
               double availableFuel,
               int tireSize) {

        super(fuelTankSize, fuelType, gears, consumptionPer100km, availableFuel, tireSize);

        this.brandName = "Mercedes";
    }

    public String getBrandName() {
        return this.brandName;
    }
}
