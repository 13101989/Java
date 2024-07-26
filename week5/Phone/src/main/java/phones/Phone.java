package main.java.phones;

import java.util.*;

public abstract class Phone implements Callable, Messageable, Contacts {
    public final String batteryLife;
    public String color;
    public String material;

    public LinkedHashMap<String, Map<String, String>> contacts;
    public Map<String, List<String>> messages;
    public LinkedHashMap<String, String> callHistory;

    public Phone(String batteryLife, String color, String material) {
        this.batteryLife = batteryLife;
        this.color = color;
        this.material = material;
    }

    public void addContact(String number, String phoneNumber, String firstName, String lastName) {
        Map<String, String> contactData = new HashMap<>();
        contactData.put("phoneNumber", phoneNumber);
        contactData.put("firstName", firstName);
        contactData.put("lastName", lastName);

        contacts.put(number, contactData);

        System.out.println("Following contact was added: " + contactData);
    }

    public void getFirstContact() {
        if (!contacts.isEmpty()) {
            System.out.println("First contact details = " + contacts.get("0"));
        } else {
            System.out.println("You haven't added any contacts yet.");
        }
    }

    public void getLastContact() {
        if (!contacts.isEmpty()) {
            Map.Entry<String, Map<String, String>> lastEntry = null;
            for (Map.Entry<String, Map<String, String>> entry : contacts.entrySet()) {
                lastEntry = entry;
            }
            System.out.println("Last contact details = " + lastEntry);
        } else {
            System.out.println("You haven't added any contacts yet.");
        }
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        List<String> message = new ArrayList<>();

        if (messages.containsKey(phoneNumber)) {
            message = messages.get(phoneNumber);
            message.add(messageContent);
        } else {
            message.add(messageContent);
            messages.put(phoneNumber, message);
        }
    }

    public void getFirstMessage(String phoneNumber) {
        if (!messages.get(phoneNumber).isEmpty()){
            String firstMessage = messages.get(phoneNumber).getFirst();
            System.out.println("First message towards number " + phoneNumber + " is " + firstMessage);
        } else {
            System.out.println("You haven't sent any messages towards " +  phoneNumber + " yet ");
        }

    }

    public void getLastMessage(String phoneNumber) {
        if (!messages.get(phoneNumber).isEmpty()) {
            String lastMessage = messages.get(phoneNumber).getLast();
            System.out.println("Last message towards number " + phoneNumber + " is " + lastMessage);
        } else {
            System.out.println("You haven't sent any messages towards " +  phoneNumber + " yet ");
        }
    }
}
