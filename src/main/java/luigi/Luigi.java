package luigi;

import luigi.commands.Command;
import luigi.ui.Ui;

/**
 * Represents Luigi the Chatbot, which is initialised with the given filepath.
 * Luigi helps users to organise their tasks, by processing user command and carrying out different functionalities,
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
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        return "Luigi heard: " + input;
    }

    /**
     * Parses each line of user input until the user says "bye".
     */
    public void run() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.readCommand();
                String commandType = input.split(" ")[0];
                Command command = Parser.parse(commandType, input);
                command.execute(list, ui, storage);
                isExit = command.isExitCommand();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        ui.closeScanner();
        storage.saveFile(this.list);
    }

    public static void main(String[] args) {
        new Luigi(FILE_PATH).run();
    }
}
