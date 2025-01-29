package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.printList();
    }
}
