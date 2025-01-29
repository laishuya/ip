package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.deleteTask(index);
        storage.saveFile(list);
    }
}