package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to add a ToDo Task to the TaskList.
 */
public class ToDoCommand extends Command {
    private final String description;

    /**
     * Represents a command to create a Task to be done.
     *
     * @param description The task.
     */
    public ToDoCommand(String description) {
        this.description = description;
    }

    /**
     * Adds a ToDo Task to the TaskList.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     * @return A string representing a Task to be completed in the future.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        String responseToUser = list.addToDo(description);
        storage.saveFile(list);
        return responseToUser;
    }
}
