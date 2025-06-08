import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileIO class responsible for reading and parsing CSV commands from a file.
 * Returns an array of Command objects that can be processed by CommandProcessor.
 */
public class FileIO {
    
    /**
     * Reads commands from a CSV file and returns an array of Command objects.
     * 
     * @param filename The path to the CSV file containing commands
     * @return Array of Command objects parsed from the file
     * @throws IOException if there's an error reading the file
     */
    public static Command[] readCommands(String filename) throws IOException {
        // First pass: count the number of valid commands
        int commandCount = countValidCommands(filename);
        
        // Create array with exact size needed
        Command[] commands = new Command[commandCount];
        int index = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                // Parse the line and create a Command object
                Command command = parseCommand(line.trim());
                if (command != null) {
                    commands[index++] = command;
                }
            }
        }
        
        return commands;
    }
    
    /**
     * Counts the number of valid commands in the file to determine array size.
     * 
     * @param filename The path to the CSV file
     * @return Number of valid commands in the file
     * @throws IOException if there's an error reading the file
     */
    private static int countValidCommands(String filename) throws IOException {
        int count = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                Command command = parseCommand(line.trim());
                if (command != null) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Parses a single line from the CSV file and creates a Command object.
     * 
     * @param line A single line from the CSV file
     * @return Command object representing the parsed command, or null if parsing fails
     */
    private static Command parseCommand(String line) {
        try {
            // Split the line by comma manually
            String[] parts = splitByComma(line);
            
            if (parts.length == 0) {
                return null;
            }
            
            String commandType = parts[0].trim();
            
            switch (commandType.toLowerCase()) {
                case "new":
                    // new,CustomerName,IssueDescription,Priority
                    if (parts.length >= 4) {
                        String customerName = parts[1].trim();
                        String issueDescription = parts[2].trim();
                        String priority = parts[3].trim();
                        return new Command("new", customerName, issueDescription, priority);
                    }
                    break;
                    
                case "resolve":
                    return new Command("resolve");
                    
                case "display":
                    // display,priority or display,asc or display,desc
                    if (parts.length >= 2) {
                        String sortType = parts[1].trim();
                        return new Command("display", sortType);
                    } else {
                        return new Command("display");
                    }
                    
                case "history":
                    // history or history,asc or history,desc
                    if (parts.length >= 2) {
                        String sortType = parts[1].trim();
                        return new Command("history", sortType);
                    } else {
                        return new Command("history");
                    }
                    
                default:
                    System.err.println("Unknown command type: " + commandType);
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Error parsing command: " + line + " - " + e.getMessage());
            return null;
        }
        
        return null;
    }
    
    /**
     * Manually splits a string by comma character.
     * 
     * @param input The string to split
     * @return Array of string parts
     */
    private static String[] splitByComma(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        
        // Count commas to determine array size
        int commaCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                commaCount++;
            }
        }
        
        // Create array with size = comma count + 1
        String[] parts = new String[commaCount + 1];
        int partIndex = 0;
        int startIndex = 0;
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                parts[partIndex++] = input.substring(startIndex, i);
                startIndex = i + 1;
            }
        }
        
        // Add the last part
        parts[partIndex] = input.substring(startIndex);
        
        return parts;
    }
    
    /**
     * Alternative method that accepts a filename and handles IOException internally.
     * Prints error message and returns empty array if file reading fails.
     * 
     * @param filename The path to the CSV file containing commands
     * @return Array of Command objects, or empty array if reading fails
     */
    public static Command[] readCommandsSafe(String filename) {
        try {
            return readCommands(filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename + " - " + e.getMessage());
            return new Command[0];
        }
    }
}
