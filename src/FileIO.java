import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static List<Command> readCommands(String filePath) {
        List<Command> commands = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].toLowerCase();
                if (type.equals("new") && parts.length == 4) {
                    commands.add(new Command(type, parts[1], parts[2], parts[3]));
                } else {
                    commands.add(new Command(type));
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return commands;
    }
}