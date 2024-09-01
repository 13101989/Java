package main.java;


public class FestivalStatisticsThread {
    private FestivalGate festivalGate;

    private int totalAttendees;
    private int attendeesWithFullAccess;
    private int attendeesWithFullVIPAccess;
    private int attendeesWithFreePass;
    private int attendeesWithOneDayAccess;
    private int attendeesWithOneDayVIPAccess;

    public FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    private FestivalStatisticsThread collectGateStats() {
        totalAttendees = this.festivalGate.getAttendees().size();

        for (FestivalAttendeeThread attendee : this.festivalGate.getAttendees()) {
            switch (attendee.getTicketType()) {
                case Full -> attendeesWithFullAccess += 1;
                case FullVIP -> attendeesWithFullVIPAccess += 1;
                case FreePass -> attendeesWithFreePass += 1;
                case OneDay -> attendeesWithOneDayAccess += 1;
                case OneDayVIP -> attendeesWithOneDayVIPAccess += 1;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return
                "Stats collected from gate so far are as follow: " +
                totalAttendees + " people entered\n" +
                attendeesWithFullAccess + " people have full tickets\n" +
                attendeesWithFreePass + " people have free passes\n" +
                attendeesWithFullVIPAccess + " people have full VIP passes\n" +
                attendeesWithOneDayAccess + " people have one-day passes\n" +
                attendeesWithOneDayVIPAccess + " people have one-day VIP passes";
    }
}
