import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "examplecommands.csv"; // Relative path as required
        List<Command> commands = FileIO.readCommands(filePath);
        CommandProcessor processor = new CommandProcessor();
        processor.processCommands(commands);
    }
}