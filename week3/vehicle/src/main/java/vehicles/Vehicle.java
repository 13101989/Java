package main.java.vehicles;

public abstract class Vehicle implements Runnable {
    private final String vehicleType;

    public Vehicle(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void start() {
    }

    public void stop() {
    }

    public void drive(double distance) {
    }

    public String getVehicleType() {
        return this.vehicleType;
    }
}
