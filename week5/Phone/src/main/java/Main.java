package main.java;

import main.java.phones.Phone;
import main.java.phones.manufacturer.applemodels.iPhone15;

public class Main {
    public static void main(String[] args) {

//        Phone phone = new Apple(); // shouldn't compile

        Phone phone = new iPhone15();

        phone.addContact("1", "phone number", "first name", "last name");
        phone.addContact("2", "second phone number", "second first name", "second last name");
        phone.getFirstContact();
        phone.getLastContact();

        phone.sendMessage("phone number", "message content");
        phone.getFirstMessage("phone number");
        phone.getSecondMessage("phone number");

        phone.call("second phone number");
        phone.viewHistory();
    }
}
