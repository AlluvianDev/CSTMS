import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "examplecommands.csv"; // Relative path of the input file
        List<Command> commands = FileIO.readCommands(filePath);
        CommandProcessor processor = new CommandProcessor();
        processor.processCommands(commands);
    }
}
