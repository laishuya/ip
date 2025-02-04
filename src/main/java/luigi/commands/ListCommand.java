package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.Ui;

/**
 * Represents a command to list all tasks in the TaskList.
 */
public class ListCommand extends Command {
    /**
     * Prints all tasks in the TaskList.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.printList();
    }
}

