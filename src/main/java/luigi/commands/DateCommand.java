package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class DateCommand extends Command {
    private final String description;

    /**
     * Represents the common date to find.
     *
     * @param description The date that some tasks might have in common.
     */
    public DateCommand(String description) {
        this.description = description;
    }

    /**
     * Finds all tasks in the list that share the common date.
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.findAllTasksWithSameDate(description);
        storage.saveFile(list);
    }
}