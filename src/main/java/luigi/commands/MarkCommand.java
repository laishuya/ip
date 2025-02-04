package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.Ui;

/**
 * Represents a command to mark a task as completed.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Represents a command to unmark a task as completed.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Unmarks task as completed.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.mark(index);
        storage.saveFile(list);
    }
}
