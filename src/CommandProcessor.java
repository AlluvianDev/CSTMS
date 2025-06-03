import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CommandProcessor {
    private GenericPriorityQueue<Ticket> ticketQueue;
    private GenericHistory<Ticket> history;
    Command[] commands;
    private int currentTime = 0;

    public CommandProcessor() throws IOException {
        this.ticketQueue = new GenericPriorityQueue<>();
        this.history = new GenericHistory<>();
        commands = FileIO.readCommands("commands.csv"); // we will process this file.
    }

    public void processCommands(){
        for (Command cmd : commands){
            switch(cmd.getType()){
                case "new":
                    break;
                case "resolve":
                    break;
                case "display":
                    break;
                case "history":
                    break;
                default:
                    break;

            }
        }
    }
    /* void processCommand(){
        /*
        new,CustomerName,IssueDescription,Priority
        resolve
        display,priority
        display,asc
        display,desc
        history
        history,asc
        history,desc

        for (int i = 0; i < commands.length; i++){ //process all commands in examplecommands.csv once

            switch(commands[i].getType()){
                case "new":
                    add(commands[i]);
                    break;
                case "history":
                    break;
                case "resolve":
                    resolve(commands[i]);
                    break;
                case "display":
                    break;
            }
        }
    }

    public void add(Command command){
        Ticket adding = new Ticket(command.getCustomerName(),command.getIssueDescription(),command.getPriority());
        ticketQueue.offer(adding);
        System.out.println("Adding Ticket: "
                + adding.getCustomerName()
                + " - "
                + adding.getIssueDescription()
                + " ["
                + adding.getPriority()
                + " Priority"
                + "]");
    }

    public void resolve(Command command){
        Ticket resolving = ticketQueue.poll();
        System.out.println("Resolving ticket:");
        System.out.println("Resolved: "
                + resolving.getCustomerName()
                + " - "
                + resolving.getIssueDescription()
                + " ["
                + resolving.getPriority()
                + "]" );
        history.add(resolving);
    }

    public void showHistory(Command command){ //show history
        switch(command.getParameter()){
            case "asc":
                break;
            case "desc":
                break;
            default: //normal listing (customer name alphabetic)
                break;
        }
        history.display();
    }

    public void display(Command command){
        Ticket[] tickets = ticketQueue.getAll();

        switch(command.getParameter()){
            case "asc":
                break;
            case "desc":
                break;
            default: // priority
                break;
        }
    }
    public void sortByArrivalTime(Ticket[] tickets,String toDo){
        for (int i = 0; i < tickets.length; i++){
            for (int j = 0; j < tickets.length ; j++){
                if(tickets[j].getArrivalTime)
            }
        }*/
}
