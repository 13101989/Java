package main.java;

import lombok.Getter;
import lombok.ToString;

@ToString
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        validateAttendeeTicket();
    }
}
