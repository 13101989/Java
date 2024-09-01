package main.java;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class FestivalAttendeeThread {
    private final TicketType ticketType;
    private final FestivalGate festivalGate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;

        festivalGate.addAttendee(this);
    }

}
