import java.util.Comparator;

/**
 * A comparator that compares tickets by customer name.
 */
public class TicketComparator implements Comparator<Ticket> {
    private final boolean ascending;
    
    /**
     * Constructs a new TicketComparator.
     * 
     * @param ascending If true, sorts in ascending order; if false, sorts in descending order
     */
    public TicketComparator(boolean ascending) {
        this.ascending = ascending;
    }
    
    /**
     * Constructs a new TicketComparator with default ascending order.
     */
    public TicketComparator() {
        this(true);
    }
    
    /**
     * Compares two tickets by customer name.
     * 
     * @param t1 The first ticket
     * @param t2 The second ticket
     * @return A negative integer, zero, or a positive integer as the first ticket's name
     *         is less than, equal to, or greater than the second ticket's name
     */
    @Override
    public int compare(Ticket t1, Ticket t2) {
        int result = t1.getCustomerName().compareTo(t2.getCustomerName());
        return ascending ? result : -result;
    }
}
