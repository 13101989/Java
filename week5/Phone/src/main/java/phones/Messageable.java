package main.java.phones;

public interface Messageable {
    void sendMessage(String phoneNumber, String messageContent);

    void getFirstMessage(String phoneNumber);

    void getSecondMessage(String phoneNumber);
}
