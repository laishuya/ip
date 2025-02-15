package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents a command to remind the user of uncompleted Tasks due within a specified amount of time.
 */
public class RemindCommand extends Command {
    private final int hoursAhead;

    /**
     * Creates a RemindCommand to display tasks due within the next 'hoursAhead' hours.
     *
     * @param hoursAhead The time window to look for upcoming Tasks that are due.
     */
    public RemindCommand(int hoursAhead) {
        this.hoursAhead = hoursAhead;
    }

    /**
     * Finds all uncompleted Tasks that are due within the next 'hoursAhead' hours.
     *
     * @param tasks The list of Tasks
     * @param ui The Ui object that deals with user interaction.
     * @param storage The Storage object that deals with loading and saving tasks.
     * @return A string listing upcoming tasks that are due soon.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return tasks.getReminders(hoursAhead);
    }
}
