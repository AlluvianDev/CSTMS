public class Command {
    private final String type;
    private String customerName;
    private String issueDescription;
    private String priority;
    private String parameter; //asc,desc,priority
    
    // Constructor of "new" command
    public Command(String type, String customerName, String issueDescription, String priority){
        this.type = type;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
    }
    // Constructor of display and history
    public Command(String type, String parameter){
        this.type = type;
        this.parameter = parameter;
    }
    
    // Constructor of display,history,resolve that has no parameters
    public Command(String type){
        this.type = type;
    }

    // Getters of the Command Class
    public String getType() {
        return type;
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
    public String getParameter() {
        return parameter;
    }

}
