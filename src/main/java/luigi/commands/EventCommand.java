package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to add an Event to the TaskList.
 */
public class EventCommand extends Command {
    private final String description;
    private final String startDate;
    private final String endDate;

    /**
     * Represents a command to create a task with start and end dates.
     *
     * @param description The task.
     * @param startDate Start date of the task.
     * @param endDate End date of the task.
     */
    public EventCommand(String description, String startDate, String endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Adds event to the TaskList.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     * @return A string containing details of the Delete Task.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        String responseToUser = list.addEvent(description, startDate, endDate);
        storage.saveFile(list);
        return responseToUser;
    }
}
