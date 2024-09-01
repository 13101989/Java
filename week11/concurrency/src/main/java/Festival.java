package main.java;

public class Festival {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();

        TicketType access = TicketType.getRandomTicketType();
        FestivalAttendeeThread attendee1 = new FestivalAttendeeThread(access, gate);

    }
}
