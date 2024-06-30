package vehicles.carbrands.bmwmodels;

import vehicles.carbrands.BMW;

public class Series3 extends BMW {
    private final String chassisNumber;

    public Series3(int availableFuel, String chassisNumber) {
        super(59, "Petrol", 8, 6.4f, availableFuel, 15);
        this.chassisNumber = chassisNumber;

        System.out.println(this);
    }

    public String toString() {
        return "Car(brand=BMW; model=Series3; chassis_number=" + this.chassisNumber + ") created successfully.";
    }
}
