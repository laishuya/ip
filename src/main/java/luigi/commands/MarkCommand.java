package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.mark(index);
        storage.saveFile(list);
    }
}