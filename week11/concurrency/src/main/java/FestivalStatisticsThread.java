package main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FestivalStatisticsThread implements Runnable {
    private final FestivalGate festivalGate;

    private int totalAttendees;
    private long attendeesWithFullAccess;
    private long attendeesWithFullVIPAccess;
    private long attendeesWithFreePass;
    private long attendeesWithOneDayAccess;
    private long attendeesWithOneDayVIPAccess;

    public FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    public void collectGateStats() {
        List<FestivalAttendeeThread> attendees = this.festivalGate.getAttendees();
        totalAttendees = attendees.size();

        if (totalAttendees > 0) {
            Map<TicketType, Long> ticketCountMapper = attendees
                    .stream()
                    .collect(Collectors.groupingBy(
                            FestivalAttendeeThread::getTicketType,
                            Collectors.counting()));

            attendeesWithFullAccess = ticketCountMapper.getOrDefault(TicketType.FULL, 0L);
            attendeesWithFullVIPAccess = ticketCountMapper.getOrDefault(TicketType.FULL_VIP, 0L);
            attendeesWithFreePass = ticketCountMapper.getOrDefault(TicketType.FREE_PASS, 0L);
            attendeesWithOneDayAccess = ticketCountMapper.getOrDefault(TicketType.ONE_DAY, 0L);
            attendeesWithOneDayVIPAccess = ticketCountMapper.getOrDefault(TicketType.ONE_DAY_VIP, 0L);
        }
    }

    @Override
    public void run() {
        collectGateStats();
        System.out.println();
        System.out.println(this);
    }

    @Override
    public String toString() {
        return
                "***************************************************************************\n" +
                        "Total stats collected from gate so far are as follow:\n" +
                        totalAttendees + " people entered\n\n" +
                        attendeesWithFullAccess + " people have FULL access\n" +
                        attendeesWithFreePass + " people have FREE_PASS access\n" +
                        attendeesWithFullVIPAccess + " people have FULL_VIP access\n" +
                        attendeesWithOneDayAccess + " people have ONE_DAY access\n" +
                        attendeesWithOneDayVIPAccess + " people have ONE_DAY_VIP access\n" +
                        "***************************************************************************\n";
    }
}
