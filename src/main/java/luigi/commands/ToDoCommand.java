package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class ToDoCommand extends Command {
    private final String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.addToDo(description);
        storage.saveFile(list);
    }
}