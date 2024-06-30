package vehicles.carbrands.bmwmodels;

import vehicles.carbrands.BMW;

public class Series3 extends BMW {
    private final float fuelTankSize;
    private final String fuelType;
    private final int gears;
    private final float consumptionPer100km;
    private final String chassisNumber;
    private float availableFuel;
    private int tireSize;

    private boolean driveMode;
    private int tachometer;
    private int currentGear;
    private float fuelConsumption;

    public Series3(int availableFuel, String chassisNumber) {
        this.availableFuel = availableFuel;
        this.chassisNumber = chassisNumber;

        this.fuelTankSize = 59;
        this.fuelType = "Petrol";
        this.gears = 8;
        this.consumptionPer100km = 6.4f;
        this.tireSize = 15;

        System.out.println(this);
    }

    public void start() {
        this.driveMode = true;
        this.tachometer = 0;
        this.fuelConsumption = 0;
        this.currentGear = 1;
        System.out.println("Started car and entered gear 1.");
    }

    public void shiftGear(int newGear) {
        if (newGear <= this.gears) {
            this.currentGear = newGear;
            System.out.println("Current gear is now: " + this.currentGear);
        } else {
            System.out.println("Maximum gear allowed is " + this.gears + " continued using gear " + this.currentGear);
        }
    }

    public void drive(int distance) {
        if (driveMode) {
            float distanceFuelConsumption = this.calculateFuelConsumption(distance);
            if (this.availableFuel > fuelConsumption + distanceFuelConsumption) {
                this.tachometer += distance;
                this.fuelConsumption += distanceFuelConsumption;
                System.out.println("Drove distance " + distance + " km and consumed an extra " + distanceFuelConsumption + " liters");
            } else {
                System.out.println("Cannot travel distance " + distance + " " + "with the current fuel. You need another  "
                        + (fuelConsumption + distanceFuelConsumption - this.availableFuel) + "liters, please fill up first!");
            }
        } else {
            System.out.println("In order to drive you need first to start the car");
        }
    }

    private float calculateFuelConsumption(int distance) {
        return ((float) distance / 100 * this.consumptionPer100km + (float) this.tireSize / 200) + (float) this.currentGear / 10;
    }

    public void getAverageFuelConsumption() {
        if (this.tachometer > 0) {
            float averageFuelConsumption = this.fuelConsumption / this.tachometer * 100;
            System.out.println("Average fuel consumption so far: "
                    + Math.round(averageFuelConsumption * 100.0f) / 100.0f + " liters/100km");
        } else {
            System.out.println("Cannot provide average fuel consumption so far because car has not drove any distance yet.");
        }
    }

    public void stop() {
        this.driveMode = false;
        System.out.println("Stopped the car.");
    }


    public int getTireSize() {
        return this.tireSize;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    public float getAvailableFuel() {
        System.out.println("Available fuel: "
                + Math.round((this.availableFuel - this.fuelConsumption) * 100.0f) / 100.0f + " liters");
        return Math.round((this.availableFuel - this.fuelConsumption) * 100.0f) / 100.0f;
    }

    public void setAvailableFuel(float availableFuel) {
        if (availableFuel < this.fuelTankSize) {
            this.availableFuel = availableFuel;
            System.out.println("New available fuel value changed successfully");
        } else {
            System.out.println("Operation failed because value provided is bigger than fuel tank size.");
        }
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public String toString() {
        return "Car(brand=BMW; model=Series3; chassis_number=" + this.chassisNumber + ") created successfully.";
    }
}
