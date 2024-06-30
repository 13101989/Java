import vehicles.Car;
import vehicles.Vehicle;
import vehicles.carbrands.bmwmodels.Series3;

public class Main {
    public static void main(String[] args) {

        Car car = new Series3(27, "oiqe0934hkkadsn");

        car.start();
        car.shiftGear(1);
        car.drive(0.01); // drives 0.01 KMs
        car.shiftGear(2);
        car.drive(0.02);
        car.shiftGear(3);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(5);
        car.drive(10);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(3);
        car.drive(0.1);
        car.stop();

        float availableFuel = car.getAvailableFuel();
        float fuelConsumedPer100Km = car.getAverageFuelConsumption();


        Vehicle vehicle = new Series3(30, "1987ddkshik289");

        vehicle.start();
        vehicle.drive(1);
        vehicle.stop();

        Car car1 = (Car) vehicle;

        float availableFuel1 = car1.getAvailableFuel();
        float fuelConsumedPer100Km1 = car1.getAverageFuelConsumption();
    }
}
