package main.java.phones;

import java.time.Instant;
import java.util.*;

public abstract class Phone implements Callable, Messageable, Contacts {
    public final Integer batteryLife;
    public String color;
    public String material;

    public LinkedHashMap<String, Map<String, String>> contacts = new LinkedHashMap<>();
    public Map<String, List<String>> messages = new HashMap<>();
    public LinkedHashMap<Instant, String> callHistory = new LinkedHashMap<>();

    public Phone(Integer batteryLife, String color, String material) {
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
            System.out.println("First contact details: " + contacts.get("1"));
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
            System.out.println("Last contact details: " + lastEntry.getValue());
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
        System.out.println("Message was sent: {destination number=" + phoneNumber + ", message=" + messageContent + "}");
    }

    public void getFirstMessage(String phoneNumber) {
        if (!messages.get(phoneNumber).isEmpty()) {
            String firstMessage = messages.get(phoneNumber).getFirst();
            System.out.println("First message: {destination number=" + phoneNumber + " ,message=" + firstMessage + "}");
        } else {
            System.out.println("You haven't sent any messages towards " + phoneNumber + " yet.");
        }

    }

    public void getSecondMessage(String phoneNumber) {
        if (messages.get(phoneNumber).size() > 1) {
            String secondMessage = messages.get(phoneNumber).get(1);
            System.out.println("Second message: {destination number=" + phoneNumber + " ,message=" + secondMessage + "}");
        } else {
            System.out.println("You haven't sent two messages towards " + phoneNumber + " yet.");
        }
    }

    public void call(String phoneNumber) {
        Instant now = Instant.now();
        callHistory.put(now, phoneNumber);
        System.out.println("Call initiated: {destination number=" + phoneNumber + " , timestamp=" + now + "}");
    }

    public void viewHistory() {
        System.out.println("The history of your calls is (timestamp -> called number): ");
        if (!callHistory.isEmpty()) {
            for (Map.Entry<Instant, String> entry : callHistory.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        } else {
            System.out.println("You haven't made any calls yet.");
        }
    }
}
