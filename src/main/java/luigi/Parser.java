package luigi;

import luigi.commands.*;
import luigi.tasks.Task;

public class Parser {
    public static Command parse(String command, String input) throws Exception {
        switch (command) {
        case "list":
            return new ListCommand();
        case "mark":
            int markIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            return new MarkCommand(markIndex);
        case "unmark":
            int unmarkIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            return new UnmarkCommand(unmarkIndex);
        case "todo":
            String description = input.substring(5).trim();
            return new ToDoCommand(description);
        case "deadline":
            String[] deadlineParts = input.substring(9).trim().split(" /by ");
            return new DeadlineCommand(deadlineParts[0].trim(), deadlineParts[1].trim());
        case "event":
            String[] eventParts = input.substring(6).trim().split(" /from | /to ");
            return new EventCommand(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
        case "delete":
            int deleteIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            return new DeleteCommand(deleteIndex);
        case "date":
            String date = input.split(" ")[1].trim();
            return new DateCommand(date);
        case "bye":
            return new ExitCommand();
        case "find":
            String word = input.substring(5).trim();
            return new FindCommand(word);
        default:
            throw new Exception("Invalid command!");
        }
    }
}
