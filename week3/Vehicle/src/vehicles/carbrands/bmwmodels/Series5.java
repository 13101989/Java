package vehicles.carbrands.bmwmodels;

import vehicles.carbrands.BMW;

public class Series5 extends BMW {
    private final String chassisNumber;

    private final String modelName;

    public Series5(int availableFuel, String chassisNumber) {
        super(59, "Petrol", 8, 6.4, availableFuel, 15);

        this.chassisNumber = chassisNumber;
        this.modelName = "5 Series";

        System.out.println(this);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return (super.calculateFuelConsumption(distance) + (double) this.getTireSize() / 200)
                + (double) this.getCurrentGear() / 10 * super.calculateFuelConsumption(distance);
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

