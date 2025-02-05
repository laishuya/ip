package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to unmark a Task as completed.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Represents a command to unmark a Task as completed.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Unmarks Task as completed.
     *
     * @param list The list of Tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving Tasks.
     * @return A string representing the unmarked Task.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        String responseToUser = list.unmark(index);
        storage.saveFile(list);
        return responseToUser;
    }
}
