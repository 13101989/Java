package test.java;

import main.java.FestivalAttendeeThread;
import main.java.FestivalGate;
import main.java.FestivalStatisticsThread;
import main.java.TicketType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FestivalTest {
    private FestivalGate gate;
    private final List<FestivalAttendeeThread> attendees = new ArrayList<>();


    @BeforeEach
    void setUp() {
        gate = new FestivalGate();
        gate.setEstimatedValidationTime(0);

        attendees.add(new FestivalAttendeeThread(TicketType.Full, gate));
        attendees.add(new FestivalAttendeeThread(TicketType.Full, gate));
        attendees.add(new FestivalAttendeeThread(TicketType.Full, gate));

        attendees.add(new FestivalAttendeeThread(TicketType.FullVIP, gate));

        attendees.add(new FestivalAttendeeThread(TicketType.FreePass, gate));
        attendees.add(new FestivalAttendeeThread(TicketType.FreePass, gate));

        attendees.add(new FestivalAttendeeThread(TicketType.OneDay, gate));
    }

    @Test
    void canInstantiate() {
        assertNotNull(gate);
        attendees.forEach(Assertions::assertNotNull);
    }

    @Test
    void testAttendeeValidationTicketAtGate() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(1)) {
            attendees.forEach(executorService::submit);
        }

        assertEquals(7, gate.getAttendees().size());

        assertEquals("attendee with access type Full", gate.getAttendees().get(0).toString());
        assertEquals("attendee with access type Full", gate.getAttendees().get(1).toString());
        assertEquals("attendee with access type Full", gate.getAttendees().get(2).toString());
        assertEquals("attendee with access type FullVIP", gate.getAttendees().get(3).toString());
        assertEquals("attendee with access type FreePass", gate.getAttendees().get(4).toString());
        assertEquals("attendee with access type FreePass", gate.getAttendees().get(5).toString());
        assertEquals("attendee with access type OneDay", gate.getAttendees().get(6).toString());
    }

    @Test
    void testStatsForGate() {
        FestivalStatisticsThread gateStats;
        try (ExecutorService executorService = Executors.newFixedThreadPool(7)) {
            attendees.forEach(executorService::submit);

            gateStats = new FestivalStatisticsThread(gate);
            executorService.submit(gateStats);
        }

        try (ExecutorService executorServiceStats = Executors.newFixedThreadPool(1)) {
            gateStats = new FestivalStatisticsThread(gate);
            executorServiceStats.submit(gateStats);
        }

        assertEquals(
                "***************************************************************************\n" +
                        "Total stats collected from gate so far are as follow:\n" +
                        "7 people entered\n\n" +
                        "3 people have full access\n" +
                        "2 people have free passes\n" +
                        "1 people have full VIP access\n" +
                        "1 people have one-day access\n" +
                        "0 people have one-day VIP access\n" +
                        "***************************************************************************\n",
                gateStats.toString()
        );


    }

}