package main.java;

import main.java.phones.Phone;
import main.java.phones.manufacturer.applemodels.iPhone15;
import main.java.phones.manufacturer.applemodels.iPhone15Pro;
import main.java.phones.manufacturer.samsungmodels.S24;
import main.java.phones.manufacturer.samsungmodels.S24Ultra;

public class Main {
    public static void main(String[] args) {

//        Phone phone = new Apple(); // shouldn't compile

//        Phone phone = new iPhone15();
//
//        phone.addContact("1", "1111111111", "John", "First");
//        phone.addContact("2", "2222222222", "John", "Second");
//        System.out.println();
//        phone.getFirstContact();
//        phone.getLastContact();
//        System.out.println();
//
//        phone.sendMessage("1111111111", "Let's go outside!");
//        System.out.println();
//        phone.getFirstMessage("1111111111");
//        phone.getSecondMessage("1111111111");
//        System.out.println();
//
//        phone.call("2222222222");
//        System.out.println();
//        phone.viewHistory();
//        System.out.println();


//        S24Ultra phone = new S24Ultra();
//        S24 phone = new S24();
//        iPhone15 phone = new iPhone15();
        iPhone15Pro phone = new iPhone15Pro();

        System.out.println("Manufacturer = " + phone.getManufacturerName());
        System.out.println("Model = " + phone.getModelName());
        System.out.println("Material = " + phone.getMaterial());
        System.out.println("Colour = " + phone.getColor());
        System.out.println("IMEI = " + phone.getIMEI());
        System.out.println("Battery left = " + phone.getBatteryLeft() + " hours");
        System.out.println();

        phone.addContact("1", "1111111111", "John", "First");
        phone.addContact("2", "2222222222", "John", "Second");
        phone.addContact("3", "3333333333", "John", "Third");
        System.out.println();

        phone.getFirstContact();
        phone.getLastContact();
        System.out.println();

        phone.sendMessage("2222222222", "Let's do something"); // - 1 hour
        phone.sendMessage("2222222222", "Let's do something else"); // - 1 hour
        System.out.println();

        phone.getFirstMessage("2222222222");
        phone.getSecondMessage("2222222222");
        System.out.println();

        phone.getFirstMessage("1111111111");
        phone.getSecondMessage("1111111111");
        System.out.println();

        phone.viewHistory();
        System.out.println();

        phone.call("3333333333"); // - 2 hours
        phone.call("2222222222"); // - 2 hours
        System.out.println();

        phone.viewHistory();
        System.out.println();
        System.out.println("Battery left = " + phone.getBatteryLeft() + " hours");
        System.out.println("IMEI = " + phone.getIMEI());
    }
}
