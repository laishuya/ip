package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class DateCommand extends Command {
    private final String description;

    public DateCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.findAllTasksWithSameDate(description);
        storage.saveFile(list);
    }
}