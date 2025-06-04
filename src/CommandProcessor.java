import java.util.Comparator;
import java.util.List;

public class CommandProcessor {
    private GenericPriorityQueue<Ticket> ticketQueue;
    private GenericHistory<Ticket> ticketHistory;
    private int arrivalCounter;

    public CommandProcessor() {
        ticketQueue = new GenericPriorityQueue<>();
        ticketHistory = new GenericHistory<>();
        arrivalCounter = 0;
    }

    public void processCommands(List<Command> commands) {
        for (Command cmd : commands) {
            switch (cmd.getType()) {
                case "new" -> {
                    Ticket t = new Ticket(cmd.getCustomerName(), cmd.getIssueDescription(), cmd.getPriority(), arrivalCounter++);
                    System.out.println("Adding Ticket: " + t);
                    ticketQueue.offer(t);
                }
                case "resolve" -> {
                    Ticket resolved = ticketQueue.poll();
                    if (resolved != null) {
                        System.out.println("Resolved: " + resolved);
                        ticketHistory.add(resolved);
                    } else {
                        System.out.println("No tickets to resolve.");
                    }
                }
                case "display" -> {
                    System.out.println("--- Displaying Active Tickets ---");
                    List<Ticket> list = ticketQueue.getAll();
                    if (cmd.getPriority() != null && cmd.getPriority().equals("priority")) {
                        list.sort(null); // natural order
                    } else if (cmd.getPriority() != null && cmd.getPriority().equals("asc")) {
                        list.sort(Comparator.comparingInt(Ticket::getArrivalTime));
                    } else if (cmd.getPriority() != null && cmd.getPriority().equals("desc")) {
                        list.sort((a, b) -> b.getArrivalTime() - a.getArrivalTime());
                    }
                    for (Ticket t : list) System.out.println(t);
                }
                case "history" -> {
                    System.out.println("--- Resolved Ticket History ---");
                    if (cmd.getPriority() != null && cmd.getPriority().equals("asc")) {
                        ticketHistory.displaySortedByTime(true);
                    } else if (cmd.getPriority() != null && cmd.getPriority().equals("desc")) {
                        ticketHistory.displaySortedByTime(false);
                    } else {
                        ticketHistory.displaySortedByName(Comparator.comparing(Ticket::getCustomerName));
                    }
                }
                default -> System.out.println("Unknown command: " + cmd.getType());
            }
        }
    }
}