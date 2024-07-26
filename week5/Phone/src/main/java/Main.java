package main.java;

import main.java.phones.manufacturer.applemodels.iPhone15;

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


        iPhone15 phone = new iPhone15();

        phone.addContact("1", "1111111111", "John", "First");
        phone.addContact("2", "2222222222", "John", "Second");
        phone.addContact("3", "3333333333", "John", "Third");
        System.out.println();
        phone.getFirstContact();
        phone.getLastContact();
        System.out.println();

        phone.sendMessage("2222222222", "Let's do something");
        phone.sendMessage("2222222222", "Let's do something else");
        System.out.println();
        phone.getFirstMessage("2222222222");
        phone.getSecondMessage("2222222222");
        System.out.println();
        phone.getFirstMessage("1111111111");
        phone.getSecondMessage("1111111111");
        System.out.println();

        phone.viewHistory();
        System.out.println();
        phone.call("3333333333");
        phone.call("2222222222");
        System.out.println();
        phone.viewHistory();

        phone.getIMEI();
        phone.getBatteryLeft();
    }
}
