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

        attendees.add(new FestivalAttendeeThread(TicketType.FULL, gate));
        attendees.add(new FestivalAttendeeThread(TicketType.FULL, gate));
        attendees.add(new FestivalAttendeeThread(TicketType.FULL, gate));

        attendees.add(new FestivalAttendeeThread(TicketType.FULL_VIP, gate));

        attendees.add(new FestivalAttendeeThread(TicketType.FREE_PASS, gate));
        attendees.add(new FestivalAttendeeThread(TicketType.FREE_PASS, gate));

        attendees.add(new FestivalAttendeeThread(TicketType.ONE_DAY, gate));
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

        assertEquals("attendee with access type FULL", gate.getAttendees().get(0).toString());
        assertEquals("attendee with access type FULL", gate.getAttendees().get(1).toString());
        assertEquals("attendee with access type FULL", gate.getAttendees().get(2).toString());
        assertEquals("attendee with access type FULL_VIP", gate.getAttendees().get(3).toString());
        assertEquals("attendee with access type FREE_PASS", gate.getAttendees().get(4).toString());
        assertEquals("attendee with access type FREE_PASS", gate.getAttendees().get(5).toString());
        assertEquals("attendee with access type ONE_DAY", gate.getAttendees().get(6).toString());
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
                        "3 people have FULL access\n" +
                        "2 people have FREE_PASS access\n" +
                        "1 people have FULL_VIP access\n" +
                        "1 people have ONE_DAY access\n" +
                        "0 people have ONE_DAY_VIP access\n" +
                        "***************************************************************************\n",
                gateStats.toString()
        );
    }
}