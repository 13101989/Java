package main.java;

import main.java.vehicles.Car;
import main.java.vehicles.Vehicle;
import main.java.vehicles.carbrands.bmwmodels.Series3;
import main.java.vehicles.carbrands.bmwmodels.Series5;
import main.java.vehicles.carbrands.mercedesmodels.ClassC;
import main.java.vehicles.carbrands.mercedesmodels.ClassE;

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

        System.out.println();
        Vehicle vehicle = new Series5(30, "1987ddkshik289");
        vehicle.start();
        vehicle.drive(1);
        vehicle.stop();

        System.out.println();
        Car car1 = (Car) vehicle;
        float availableFuel1 = car1.getAvailableFuel();
        float fuelConsumedPer100Km1 = car1.getAverageFuelConsumption();

        System.out.println();
        Car series3 = new Series3(60, "series3_chassis");
        series3.start();
        series3.drive(100);
        series3.stop();
        series3.getAvailableFuel();
        series3.getAverageFuelConsumption();

        System.out.println();
        Car series5 = new Series5(60, "series5_chassis");
        series5.start();
        series5.drive(100);
        series5.stop();
        series5.getAvailableFuel();
        series5.getAverageFuelConsumption();

        System.out.println();
        Car classC = new ClassC(60, "classA_chassis");
        classC.start();
        classC.drive(100);
        classC.stop();
        classC.getAvailableFuel();
        classC.getAverageFuelConsumption();

        System.out.println();
        Car classE = new ClassE(60, "classE_chassis");
        classE.start();
        classE.drive(100);
        classE.stop();
        classE.getAvailableFuel();
        classE.getAverageFuelConsumption();
    }
}
