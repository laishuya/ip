package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to exit the program.
 */
public class ExitCommand extends Command {
    /**
     * Tells MainWindow to exit the program.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     * @return A string telling MainWindow to close the program.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        storage.saveFile(list);
        return "Bye!";
    }
}

