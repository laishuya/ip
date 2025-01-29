package luigi;

import luigi.tasks.Deadline;
import luigi.tasks.Event;
import luigi.tasks.Task;
import luigi.tasks.Todo;
import luigi.commands.Command;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Luigi {
    private static String FILE_PATH ="./data/luigi.txt";
    private Storage storage;
    private TaskList list;
    private Ui ui;

    public Luigi(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            this.list = new TaskList(storage.loadFile());
        } catch (Exception e) {
            System.out.println("placeholder");
        }
    }

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
