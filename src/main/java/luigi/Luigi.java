package luigi;

import luigi.tasks.Deadline;
import luigi.tasks.Event;
import luigi.tasks.Task;
import luigi.tasks.Todo;


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

    public Luigi(String filePath) {
        this.storage = new Storage(filePath);
        try {
            this.list = new TaskList(storage.loadFile());
        } catch (Exception e) {
            System.out.println("placeholder");
        }
    }

    public void run() {
        greetUser();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("bye")) {
                break;
            }

            String command = input.split(" ")[0];
            switch (command) {
            case "list":
                this.list.printList();
                break;

            case "mark":
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    this.list.mark(index);
                } catch (Exception e) {
                    System.out.println("Invalid index!");
                }
                break;

            case "unmark":
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    this.list.unmark(index);
                } catch (Exception e) {
                    System.out.println("Invalid index!");
                }
                break;

            case "todo":
                try {
                    String description = input.substring(5).trim();
                    this.list.addToDo(description);
                } catch (Exception e) {
                    System.out.println("Description of todo cannot be empty!");
                    System.out.println("Correct example: todo read book");
                }
                break;

            case "deadline":
                try {
                    String[] deadlineParts = input.substring(9).trim().split(" /by ");
                    this.list.addDeadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                } catch (Exception e) {
                    System.out.println("Please input description and deadline!");
                    System.out.println("Correct example: deadline return book /by yyyy-MM-dd HHmm");
                }
                break;

            case "event":
                try {
                    String[] eventParts = input.substring(6).trim().split(" /from | /to ");
                    this.list.addEvent(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
                } catch (Exception e) {
                    System.out.println("Please input description, from (what time), to (what time)!");
                    System.out.println("Correct example: event book club meeting "
                        + "/from yyyy-MM-dd HHmm /to yyyy-MM-dd HHmm");
                 }
                break;

            case "delete":
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    this.list.deleteTask(index);
                } catch (Exception e) {
                    System.out.println("Invalid index!");
                }
                break;

            case "date":
                try {
                    String date = input.split(" ")[1].trim();
                    this.list.findAllTasksWithSameDate(date);
                } catch (Exception e) {
                    System.out.println("Correct example: date yyyy-MM-dd format.");
                }
                break;

            default:
                System.out.println("Sorry, invalid command");
                break;
            }
        }
        System.out.println("Bye!");
        storage.saveFile(this.list);
        scanner.close();
    }

    private static void greetUser() {
        System.out.println("""
                Hello, I'm Luigi! How can I help you?
                """);
    }

    public static void main(String[] args) {
        new Luigi(FILE_PATH).run();
    }
}
