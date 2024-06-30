import vehicles.Car;
import vehicles.Vehicle;
import vehicles.carbrands.Mercedes;
import vehicles.carbrands.bmwmodels.Series3;
import vehicles.carbrands.bmwmodels.Series5;
import vehicles.carbrands.mercedesmodels.ClassA;
import vehicles.carbrands.mercedesmodels.ClassE;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Car car = new Series3(27, "oiqe0934hkkadsn");
//
//        car.start();
//        car.shiftGear(1);
//        car.drive(0.01); // drives 0.01 KMs
//        car.shiftGear(2);
//        car.drive(0.02);
//        car.shiftGear(3);
//        car.drive(0.5);
//        car.shiftGear(4);
//        car.drive(0.5);
//        car.shiftGear(4);
//        car.drive(0.5);
//        car.shiftGear(5);
//        car.drive(10);
//        car.shiftGear(4);
//        car.drive(0.5);
//        car.shiftGear(3);
//        car.drive(0.1);
//        car.stop();
//
//        float availableFuel = car.getAvailableFuel();
//        float fuelConsumedPer100Km = car.getAverageFuelConsumption();
//
//
//        Vehicle vehicle = new Series3(30, "1987ddkshik289");
//
//        vehicle.start();
//        vehicle.drive(1);
//        vehicle.stop();
//
//        Car car1 = (Car) vehicle;
//
//        float availableFuel1 = car1.getAvailableFuel();
//        float fuelConsumedPer100Km1 = car1.getAverageFuelConsumption();

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
        Car classA = new ClassA(60, "classA_chassis");
        classA.start();
        classA.drive(100);
        classA.stop();
        classA.getAvailableFuel();
        classA.getAverageFuelConsumption();

        System.out.println();
        Car classE = new ClassE(60, "classE_chassis");
        classE.start();
        classE.drive(100);
        classE.stop();
        classE.getAvailableFuel();
        classE.getAverageFuelConsumption();






    }
}
