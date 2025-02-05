package luigi;

import luigi.commands.Command;
import luigi.ui.Ui;

/**
 * Represents Luigi the Chatbot, which is initialised with the given filepath.
 * Luigi helps users to organise their tasks, by processing user commands and carrying out different functionalities,
 * such as adding, deleting, marking, unmarking and finding tasks.
 *
 */
public class Luigi {
    private static String FILE_PATH = "./data/luigi.txt";
    private Storage storage;
    private TaskList list;
    private Ui ui;

    /**
     * Loads data to initialise the Luigi chatbot.
     *
     * @param filePath Path to where the file data is stored.
     */
    public Luigi(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            this.list = new TaskList(storage.loadFile());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Generates a response to the user's chat message.
     */
    public String getResponse(String input) {
        try {
            String commandType = input.split(" ")[0];
            Command command = Parser.parse(commandType, input);
            String commandOutput = command.execute(list, ui, storage);
            return commandOutput;
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            storage.saveFile(this.list);
            return errorMessage;
        }
    }
}
