package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to exit the program.
 */
public class ExitCommand extends Command {
    /**
     * Exits the program.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        storage.saveFile(list);
        ui.sayMessage("Bye!");
    }

    /**
     * Tells the chatbot if it should exit the program.
     */
    @Override
    public boolean isExitCommand() {
        return true;
    }
}
