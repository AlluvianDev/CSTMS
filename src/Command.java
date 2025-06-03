import java.util.Objects;

public class Command {
    private String type;
    private String customerName;
    private String issueDescription;
    private String priority;
    private String parameter; //asc,desc,priority
    
    //constructor of "new" command
    public Command(String type, String customerName, String issueDescription, String priority){
        this.type = type;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
    }
    // constructor of display and history
    public Command(String type, String parameter){
        this.type = type;
        this.parameter = parameter;
    }
    //constructor of display,history,resolve that has no parameters
    public Command(String type){
        this.type = type;
    }

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

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

}
