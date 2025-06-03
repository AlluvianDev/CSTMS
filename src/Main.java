import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CommandProcessor processor = new CommandProcessor();
            processor.processCommands();
        } catch (IOException e) {
            System.err.println("Error reading commands file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}