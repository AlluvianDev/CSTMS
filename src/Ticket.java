import java.util.Date;

public class Ticket implements Comparable<Ticket> {
    private String customerName;
    private String issueDescription;
    private String priority;
    private Date arrivalTime;

    public Ticket(String customerName,String issueDescription, String priority){
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
        this.arrivalTime = new Date();
    }

    public Ticket(String customerName,String issueDescription, String priority, Date arrivalTime){
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getIssueDescription(){
        return issueDescription;
    }

    public String getPriority(){
        return priority;
    }

    public Date arrivalTime(){
        return arrivalTime;
    }
    private int getPriorityValue(){
        return switch (priority) {
            case "high" -> 3;
            case "medium" -> 2;
            case "low" -> 1;
            default -> 0;
        };
    }

    public String getPriorityDisplay() {
        return priority.substring(0, 1).toUpperCase() + priority.substring(1);
    } //substring(startIndex,endIndex); we used here to make high -> High for example

    @Override
    public int compareTo(Ticket o) {
        int priorityCompare = Integer.compare(o.getPriorityValue(), this.getPriorityValue());
        //o.getPriorityValue() <  this.getPriorityValue() returns negative number,
        if(priorityCompare != 0){
            return priorityCompare;
        }
        return this.arrivalTime.compareTo(o.arrivalTime); //if elements are equal, they are compared by arrivalTimes.
    }

    @Override
    public String toString(){
        return customerName + " - " + issueDescription + " [" + getPriorityDisplay() + "]";
    }
}
