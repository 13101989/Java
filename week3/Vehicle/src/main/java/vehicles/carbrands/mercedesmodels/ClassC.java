package main.java.vehicles.carbrands.mercedesmodels;

import main.java.vehicles.carbrands.Mercedes;

public class ClassC extends Mercedes {
    private final String chassisNumber;

    private final String modelName;

    public ClassC(int availableFuel, String chassisNumber) {
        super(66, "Petrol", 9, 6.4, availableFuel, 15);

        this.chassisNumber = chassisNumber;
        this.modelName = "Class C";

        System.out.println(this);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return super.calculateFuelConsumption(distance) +
                (double) this.getCurrentGear() / 10 * super.calculateFuelConsumption(distance);
    }

    public String getModelName() {
        return this.modelName;
    }

    public String toString() {
        return "Car(" +
                "brand=" + this.getBrandName() + "; " +
                "model=" + this.getModelName() + "; " +
                "chassis_number=" + this.chassisNumber + ") " +
                "created successfully.";
    }
}
