package main.java;

import lombok.Getter;


@Getter
public class FestivalAttendeeThread implements Runnable {
    private final TicketType ticketType;
    private final FestivalGate festivalGate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
    }

    private void validateAttendeeTicket() {
        festivalGate.addAttendee(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        validateAttendeeTicket();
    }

    @Override
    public String toString() {
        return "attendee with access type " + ticketType;
    }
}
