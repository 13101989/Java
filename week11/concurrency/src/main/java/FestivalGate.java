package main.java;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FestivalGate {
    private List<FestivalAttendeeThread> attendees = new ArrayList<>();

    public synchronized void addAttendee(FestivalAttendeeThread attendee) {
        attendees.add(attendee);
        System.out.println("Ticket was validated for -> " + attendee);
    }
}
