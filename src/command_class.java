/**
 * Represents a command parsed from the CSV file.
 */
public class Command {
    /**
     * Enumeration of possible command types.
     */
    public enum CommandType {
        NEW,
        RESOLVE,
        DISPLAY,
        HISTORY
    }
    
    private CommandType type;
    private String customerName;
    private String issueDescription;
    private String priority;
    private String displayOption;
    
    /**
     * Constructs a new command for creating a ticket.
     * 
     * @param customerName     The customer name
     * @param issueDescription The issue description
     * @param priority         The priority level
     */
    public Command(String customerName, String issueDescription, String priority) {
        this.type = CommandType.NEW;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
    }
    
    /**
     * Constructs a new display or history command with an option.
     * 
     * @param type          The command type (DISPLAY or HISTORY)
     * @param displayOption The display option (priority, asc, desc)
     */
    public Command(CommandType type, String displayOption) {
        this.type = type;
        this.displayOption = displayOption;
    }
    
    /**
     * Constructs a new resolve command.
     */
    public Command() {
        this.type = CommandType.RESOLVE;
    }
    
    /**
     * Gets the command type.
     * 
     * @return The command type
     */
    public CommandType getType() {
        return type;
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
    public String getPriority() {
        return priority;
    }
    
    /**
     * Gets the display option.
     * 
     * @return The display option
     */
    public String getDisplayOption() {
        return displayOption;
    }
}
