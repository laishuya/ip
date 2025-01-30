package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

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
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.deleteTask(index);
        storage.saveFile(list);
    }
}