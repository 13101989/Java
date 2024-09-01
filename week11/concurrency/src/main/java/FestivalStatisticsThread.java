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

        Map<TicketType, Long> ticketCountMapper = attendees
                .stream()
                .collect(Collectors.groupingBy(
                        FestivalAttendeeThread::getTicketType,
                        Collectors.counting()));

        attendeesWithFullAccess = ticketCountMapper.getOrDefault(TicketType.Full, 0L);
        attendeesWithFullVIPAccess = ticketCountMapper.getOrDefault(TicketType.FullVIP, 0L);
        attendeesWithFreePass = ticketCountMapper.getOrDefault(TicketType.FreePass, 0L);
        attendeesWithOneDayAccess = ticketCountMapper.getOrDefault(TicketType.OneDay, 0L);
        attendeesWithOneDayVIPAccess = ticketCountMapper.getOrDefault(TicketType.OneDayVIP, 0L);
    }

    @Override
    public void run() {
        collectGateStats();
    }

    @Override
    public String toString() {
        return
                "Stats collected from gate so far are as follow:\n\n" +
                        totalAttendees + " people entered\n\n" +
                        attendeesWithFullAccess + " people have full tickets\n" +
                        attendeesWithFreePass + " people have free passes\n" +
                        attendeesWithFullVIPAccess + " people have full VIP passes\n" +
                        attendeesWithOneDayAccess + " people have one-day passes\n" +
                        attendeesWithOneDayVIPAccess + " people have one-day VIP passes";
    }
}
