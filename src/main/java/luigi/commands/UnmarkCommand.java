package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.unmark(index);
        storage.saveFile(list);
    }
}