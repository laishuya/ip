package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.addEvent(description, from, to);
        storage.saveFile(list);
    }
}