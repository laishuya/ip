package luigi.commands;

import luigi.TaskList;
import luigi.Ui;
import luigi.Storage;

public abstract class Command {
    /**
     * Executes the command given by the user.
     *
     * @param taskList The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage);

    /**
     * Tells the chatbot if it should exit the program.
     */
    public boolean isExitCommand() {
        return false;
    }
}
