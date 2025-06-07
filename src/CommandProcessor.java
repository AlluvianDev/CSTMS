import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class CommandProcessor {
    private GenericPriorityQueue<Ticket> ticketQueue;
    private GenericHistory<Ticket> history;
    Command[] commands;

    public CommandProcessor() throws IOException {
        this.ticketQueue = new GenericPriorityQueue<>(Ticket.class);
        this.history = new GenericHistory<>(Ticket.class);
        commands = FileIO.readCommands("./examplecommands.csv");
    }

    public void processCommands(){
        for (Command cmd : commands){
            switch(cmd.getType()){
                case "new":
                    addTicket(cmd);
                    break;
                case "resolve":
                    resolveTicket();
                    break;
                case "display":
                    displayTickets(cmd);
                    break;
                case "history":
                    showHistory(cmd);
                    break;
                default:
                    System.out.println("Unknown command: " + cmd.getType());
                    break;
            }
        }
    }

    public void addTicket(Command command){
        Ticket adding = new Ticket(command.getCustomerName(), command.getIssueDescription(), command.getPriority());
        ticketQueue.offer(adding);
        System.out.println("\nAdding Ticket: "
                + adding.getCustomerName()
                + " - "
                + adding.getIssueDescription()
                + " ["
                + adding.getPriority()
                + " Priority"
                + "]");
    }

    public void resolveTicket(){
        if (ticketQueue.isEmpty()) {
            System.out.println("\nNo tickets to resolve.");
            return;
        }

        Ticket resolving = ticketQueue.poll();
        System.out.println("\nResolving Ticket:");
        System.out.println("Resolved: "
                + resolving.getCustomerName()
                + " - "
                + resolving.getIssueDescription()
                + " ["
                + resolving.getPriority()
                + "]");
        history.add(resolving);
    }

    public void displayTickets(Command command){
        Ticket[] tickets = ticketQueue.getAll();

        if (tickets.length == 0) {
            System.out.println("\nNo active tickets.");
            return;
        }

        String parameter = command.getParameter();
        if (parameter == null) parameter = "priority";

        switch(parameter){
            case "asc":
                System.out.println("\n--- Displaying Active Tickets (By ASC - Oldest First) ---");
                Arrays.sort(tickets, Comparator.comparing(Ticket::getArrivalTime));
                break;
            case "desc":
                System.out.println("\n--- Displaying Active Tickets (By DESC - Newest First) ---");
                Arrays.sort(tickets, Comparator.comparing(Ticket::getArrivalTime).reversed());
                break;
            case "priority":
                System.out.println("\n--- Displaying Active Tickets (By Priority) ---");
                Arrays.sort(tickets);
                break;
        }

        for (int i = 0; i < tickets.length; i++) {
            System.out.println((i + 1) + ". " + tickets[i]);
        }
    }

    public void showHistory(Command command){
        Ticket[] historyTickets = history.getAll();

        if (historyTickets.length == 0) {
            System.out.println("\nNo resolved tickets in history.");
            return;
        }

        String parameter = command.getParameter();

        if (parameter == null) {
            System.out.println("\n--- Resolved Ticket History (Sorted by Customer Name) ---");
            Arrays.sort(historyTickets, Comparator.comparing(Ticket::getCustomerName));
        } else {
            switch(parameter){
                case "asc":
                    System.out.println("\n--- Resolved Ticket History (ASC - Oldest First) ---");
                    // History is already in chronological order (oldest first)
                    // No additional sorting needed since tickets are added to history in resolution order
                    break;
                case "desc":
                    System.out.println("\n--- Resolved Ticket History (DESC - Newest First) ---");
                    // Reverse the array to show newest first
                    for (int i = 0; i < historyTickets.length / 2; i++) {
                        Ticket temp = historyTickets[i];
                        historyTickets[i] = historyTickets[historyTickets.length - 1 - i];
                        historyTickets[historyTickets.length - 1 - i] = temp;
                    }
                    break;
                default:
                    System.out.println("\n--- Resolved Ticket History (Sorted by Customer Name) ---");
                    Arrays.sort(historyTickets, Comparator.comparing(Ticket::getCustomerName));
                    break;
            }
        }

        for (int i = 0; i < historyTickets.length; i++) {
            System.out.println((i + 1) + ". " + historyTickets[i]);
        }
    }
}
