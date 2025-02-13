package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to list all Tasks in the TaskList.
 */
public class ListCommand extends Command {
    /**
     * Prints all Tasks in the TaskList.
     *
     * @param list The list of Tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving Tasks.
     * @return A string containing all the Tasks in TaskList.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        return list.getListToPrint();
    }
}

