package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        storage.saveFile(list);
        ui.sayMessage("Bye!");
    }

    @Override
    public boolean isExitCommand() {
        return true;
    }
}