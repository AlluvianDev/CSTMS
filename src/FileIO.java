import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Reads and parses CSV commands from a file
public class FileIO {
    
    // Reads commands from a CSV file and returns Command objects
    public static Command[] readCommands(String filename) throws IOException {
        // Count valid commands first to create exact-size array
        int commandCount = countValidCommands(filename);
        
        // Create array with exact size needed
        Command[] commands = new Command[commandCount];
        int index = 0;
        
        // Use try-with-resources to ensure file is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                // Parse line into Command object
                Command command = parseCommand(line.trim());
                if (command != null) {
                    commands[index++] = command;
                }
            }
        }
        
        return commands;
    }
    
    // Counts valid commands in the file
    private static int countValidCommands(String filename) throws IOException {
        int count = 0;
        
        // Use try-with-resources for automatic file closing
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            // Read each line to count valid commands
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                // Check if line can be parsed into valid command
                Command command = parseCommand(line.trim());
                if (command != null) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // Parses a CSV line into a Command object
    private static Command parseCommand(String line) {
        try {
            // Split line by commas
            String[] parts = splitByComma(line);
            
            // Return null if no parts found
            if (parts.length == 0) {
                return null;
            }
            
            // Get command type (first part)
            String commandType = parts[0].trim();
            
            // Handle different command types
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
                    // resolve (no additional parameters)
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
                    // Unknown command type
                    System.err.println("Unknown command type: " + commandType);
                    return null;
            }
        } catch (Exception e) {
            // Handle any parsing errors
            System.err.println("Error parsing command: " + line + " - " + e.getMessage());
            return null;
        }
        
        return null;
    }
    
    // Splits a string by commas
    private static String[] splitByComma(String input) {
        // Handle null or empty input
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
        
        // Split string at each comma
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                parts[partIndex++] = input.substring(startIndex, i);
                startIndex = i + 1; // Start after the comma
            }
        }
        
        // Add the last part (after final comma or entire string if no commas)
        parts[partIndex] = input.substring(startIndex);
        
        return parts;
    }
    
    // Reads commands safely, returning empty array on error
    public static Command[] readCommandsSafe(String filename) {
        try {
            // Try to read commands normally
            return readCommands(filename);
        } catch (IOException e) {
            // Print error and return empty array if file reading fails
            System.err.println("Error reading file: " + filename + " - " + e.getMessage());
            return new Command[0];
        }
    }
}
