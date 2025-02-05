package luigi.commands;

import java.util.ArrayList;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;
import luigi.tasks.Task;

/**
 * Represents a command to find all tasks with the same keyword.
 */
public class FindCommand extends Command {
    private final String word;

    /**
     * Represents a command to find all tasks with a common word.
     *
     * @param word The keyword(s).
     */
    public FindCommand(String word) {
        this.word = word;
    }

    /**
     * Find all tasks with the common word(s).
     *
     * @param list The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        ArrayList<Task> matchingTasks = list.findTasksWithSameWord(word);
        ui.sayMessage("Here are the matching tasks in your list:");
        int index = 1;
        for (Task task : matchingTasks) {
            ui.sayMessage(index + ". " + task);
            index++;
        }
    }
}
