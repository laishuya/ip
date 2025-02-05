package luigi.commands;

import luigi.Storage;
import luigi.TaskList;
import luigi.ui.Ui;

/**
 * Represents the type of command that the bot should execute.
 * This is the base abstract class that other subclasses will extend.
 */
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
