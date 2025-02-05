package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to add a Deadline task to the TaskList.
 */
public class DeadlineCommand extends Command {
    private final String description;
    private final String deadline;

    /**
     * Represents a command to create a Task with a deadline.
     *
     * @param description The task.
     * @param deadline The due date of the task.
     */
    public DeadlineCommand(String description, String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    /**
     * Adds deadline to the TaskList.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.addDeadline(description, deadline);
        storage.saveFile(list);
    }
}
