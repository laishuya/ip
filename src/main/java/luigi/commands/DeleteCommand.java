package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to delete a task from the TaskList.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Represents a command to remove a Task.
     *
     * @param index The index of the task in the TaskList.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Removes task from TaskList.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     * @return A string containing details of the Delete Task.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        String responseToUser = list.deleteTask(index);
        storage.saveFile(list);
        return responseToUser;
    }
}
