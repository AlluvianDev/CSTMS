public class Ticket implements Comparable<Ticket> {
    private String customerName;
    private String issueDescription;
    private String priority;
    private int arrivalTime;

    public Ticket(String customerName, String issueDescription, String priority, int arrivalTime) {
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public String getPriority() {
        return priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    private int getPriorityValue() {
        return switch (priority.toLowerCase()) {
            case "high" -> 3;
            case "medium" -> 2;
            case "low" -> 1;
            default -> throw new IllegalArgumentException("Unknown priority: " + priority);
        };
    }

    private String getPriorityDisplay() {
        return priority.substring(0, 1).toUpperCase() + priority.substring(1).toLowerCase();
    }

    @Override
    public int compareTo(Ticket other) {
        int priorityCompare = Integer.compare(other.getPriorityValue(), this.getPriorityValue());
        if (priorityCompare != 0) return priorityCompare;
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }

    @Override
    public String toString() {
        return customerName + " - " + issueDescription + " [" + getPriorityDisplay() + "]";
    }
}
