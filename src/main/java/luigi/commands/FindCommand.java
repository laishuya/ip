package luigi.commands;

import java.util.ArrayList;

import luigi.Storage;
import luigi.TaskList;
import luigi.tasks.Task;
import luigi.ui.Ui;

/**
 * Represents a command to find all Tasks with the same keyword.
 */
public class FindCommand extends Command {
    private final String word;

    /**
     * Represents a command to find all Tasks with the common word.
     *
     * @param word The keyword(s).
     */
    public FindCommand(String word) {
        this.word = word;
    }

    /**
     * Find all tasks with the common word(s).
     *
     * @param list The list of Tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     * @return A string containing all the common Tasks.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Task> matchingTasks = list.findTasksWithSameWord(word);
        sb.append("Here are the matching tasks in your list:\n");
        int index = 1;
        for (Task task : matchingTasks) {
            sb.append(index + ". " + task + "\n");
            index++;
        }
        return sb.toString();
    }
}
