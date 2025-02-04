package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.Ui;

/**
 * Represents a command to unmark a Task as completed.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Represents a command to mark a task as completed.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.unmark(index);
        storage.saveFile(list);
    }
}
