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

        System.out.println(this);
    }

    public void start() {
        if (this.availableFuel > this.fuelTankSize) {

        }
        this.driveMode = true;
        this.tachometer = 0;
        this.fuelConsumption = 0;
        this.currentGear = 0;
    }

    public void shiftGear(int newGear) {
        if (newGear <= this.gears) {
            this.currentGear = newGear;
        } else {
            System.out.println("Maximum gear allowed is " + this.gears);
        }
    }

    public void drive(int distance) {
        if (driveMode) {
            float distanceFuelConsumption = this.getAverageFuelConsumption(distance);
            if (this.availableFuel > fuelConsumption + distanceFuelConsumption) {
                this.tachometer += distance;
                this.fuelConsumption += distanceFuelConsumption;
            } else {
                System.out.println("Cannot travel distance " + distance + " " + "with the current fuel. You need another  "
                        + (fuelConsumption + distanceFuelConsumption - this.availableFuel) + "l, please fill up first!");
            }
        } else {
            System.out.println("In order to drive you need first to start the car");
        }
    }

    private float getAverageFuelConsumption(int distance) {
        return (float) (this.tachometer + distance) / 100 * this.consumptionPer100km;
    }

    public float getAverageFuelConsumption() {
        return (float) (this.tachometer) / 100 * this.consumptionPer100km;
    }

    public void stop() {
        this.driveMode = false;
    }


    public int getTireSize() {
        return this.tireSize;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    public float getAvailableFuel() {
        return this.availableFuel;
    }

    public void setAvailableFuel(float availableFuel) {
        this.availableFuel = availableFuel;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public String toString(){
        return "Car(brand=BMW; model=Series3; chassis_number=" + this.chassisNumber + ") created successfully.";
    }
}
