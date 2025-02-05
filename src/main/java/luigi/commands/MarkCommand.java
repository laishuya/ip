package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to mark a Task as completed.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Represents a command to mark a Task as completed.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Marks Task as completed.
     *
     * @param list The list of Tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving Tasks.
     * @return A string containing a Task marked as done.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        String responseToUser = list.mark(index);
        storage.saveFile(list);
        return responseToUser;
    }
}
