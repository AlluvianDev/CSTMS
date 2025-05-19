import java.time.LocalDateTime;

/**
 * Represents a customer service ticket with customer information, issue details,
 * priority level, and creation timestamp.
 */
public class Ticket implements Comparable<Ticket> {
    private String customerName;
    private String issueDescription;
    private Priority priority;
    private LocalDateTime arrivalTime;

    /**
     * Enumeration of possible ticket priority levels.
     */
    public enum Priority {
        HIGH(3),
        MEDIUM(2),
        LOW(1);

        private final int value;

        Priority(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        /**
         * Converts a string representation to Priority enum.
         * @param priority String representation of priority
         * @return The corresponding Priority enum value
         */
        public static Priority fromString(String priority) {
            if (priority == null) {
                return LOW;
            }
            
            switch (priority.trim().toUpperCase()) {
                case "HIGH":
                    return HIGH;
                case "MEDIUM":
                    return MEDIUM;
                case "LOW":
                default:
                    return LOW;
            }
        }
    }

    /**
     * Constructs a new Ticket with the given details.
     * 
     * @param customerName     Name of the customer
     * @param issueDescription Description of the issue
     * @param priority         Priority level of the ticket
     */
    public Ticket(String customerName, String issueDescription, String priority) {
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = Priority.fromString(priority);
        this.arrivalTime = LocalDateTime.now();
    }

    /**
     * Constructs a new Ticket with the given details and a specific arrival time.
     * 
     * @param customerName     Name of the customer
     * @param issueDescription Description of the issue
     * @param priority         Priority level of the ticket
     * @param arrivalTime      Arrival time of the ticket
     */
    public Ticket(String customerName, String issueDescription, String priority, LocalDateTime arrivalTime) {
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = Priority.fromString(priority);
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets the customer name.
     * 
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Gets the issue description.
     * 
     * @return The issue description
     */
    public String getIssueDescription() {
        return issueDescription;
    }

    /**
     * Gets the priority level.
     * 
     * @return The priority level
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Gets the arrival time.
     * 
     * @return The arrival time
     */
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Compares this ticket with another ticket based on priority.
     * Higher priority tickets come before lower priority tickets.
     * For tickets with the same priority, earlier arrival times come first (FIFO).
     * 
     * @param other The ticket to compare with
     * @return A negative integer, zero, or a positive integer if this ticket is
     *         higher priority, equal priority, or lower priority than the other ticket
     */
    @Override
    public int compareTo(Ticket other) {
        // First, compare by priority (higher priority comes first)
        int priorityComparison = other.priority.getValue() - this.priority.getValue();
        
        // If same priority, compare by arrival time (earlier comes first - FIFO)
        if (priorityComparison == 0) {
            return this.arrivalTime.compareTo(other.arrivalTime);
        }
        
        return priorityComparison;
    }

    /**
     * Returns a string representation of the ticket.
     * 
     * @return A string representation of the ticket
     */
    @Override
    public String toString() {
        return customerName + " - " + issueDescription + " [" + priority + "]";
    }
}
