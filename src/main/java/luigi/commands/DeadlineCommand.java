package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class DeadlineCommand extends Command {
    private final String description;
    private final String deadline;

    public DeadlineCommand(String description, String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.addDeadline(description, deadline);
        storage.saveFile(list);
    }
}