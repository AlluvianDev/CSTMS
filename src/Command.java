import java.util.Objects;

public class Command {
    private String type;
    private String customerName;
    private String issueDescription;
    private String priority;
    private String parameter; //asc,desc,priority

    private String[] parts;

    public Command(String[] parts){
        if (Objects.equals(parts[0], "new")){
            this.parts = parts;
            this.type = parts[0];
            this.customerName = parts[1];
            this.issueDescription = parts[2];
            this.priority = parts[3];
        }
        else{
            this.parts = parts;
            this.type = parts[0];
            if (parts.length > 1){
                this.parameter = parts[1];
            }
        }

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

    public String getPart(int index) {
        return parts[index]; //to get for example names or issues
    }

}
