import java.io.IOException;

// Entry point of the program
public class Main {
    public static void main(String[] args) {
        try {
            // Creates the main logic object
            CommandProcessor processor = new CommandProcessor();
            processor.processCommands();
            // Give error if can not read the file
        } catch (IOException e) {
            System.err.println("Error reading commands file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
