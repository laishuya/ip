package luigi;

import luigi.commands.Command;
import luigi.commands.DateCommand;
import luigi.commands.DeadlineCommand;
import luigi.commands.DeleteCommand;
import luigi.commands.EventCommand;
import luigi.commands.ExitCommand;
import luigi.commands.FindCommand;
import luigi.commands.ListCommand;
import luigi.commands.MarkCommand;
import luigi.commands.RemindCommand;
import luigi.commands.ToDoCommand;
import luigi.commands.UnmarkCommand;

/**
 * Parses user input and returns a Command object to be executed by the Chatbot.
 * If user input is invalid, an exception is thrown.
 */
public class Parser {
    /**
     * Parses the first word entered by the user and returns the right command type.
     *
     * @param command The first word entered by the user.
     * @param input The entire string entered by the user.
     * @return The command type entered by the user.
     */
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
        case "remind":
            int hoursAhead = Integer.parseInt(input.substring(7).trim());
            return new RemindCommand(hoursAhead);
        default:
            throw new Exception("Invalid command!");
        }
    }
}
