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
     * Returns a string that represents the response to the user.
     *
     * @param taskList The list of tasks.
     * @param ui Ui object that deals with user interaction.
     * @param storage Storage object that deals with loading and saving tasks.
     */
    public abstract String execute(TaskList taskList, Ui ui, Storage storage);
}


