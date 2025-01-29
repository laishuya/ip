package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage);

    public boolean isExitCommand() {
        return false;
    }
}
