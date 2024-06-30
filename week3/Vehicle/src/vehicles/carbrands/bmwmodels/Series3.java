package vehicles.carbrands.bmwmodels;

import vehicles.carbrands.BMW;

public class Series3 extends BMW {
    private final String chassisNumber;

    private final String modelName;

    public Series3(int availableFuel, String chassisNumber) {
        super(59, "Petrol", 8, 6.4, availableFuel, 15);

        this.chassisNumber = chassisNumber;
        this.modelName = "3 Series";

        System.out.println(this);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return (distance / 100 * this.getConsumptionPer100km()) +
                (double) this.getCurrentGear() / 10 * (distance / 100 * this.getConsumptionPer100km());
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
