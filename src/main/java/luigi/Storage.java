package luigi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import luigi.tasks.Deadline;
import luigi.tasks.Event;
import luigi.tasks.Task;
import luigi.tasks.Todo;

/**
 * Loads and saves user data from the data file stored on the computer.
 * If the data file and directory are missing, then they will be created by the program.
 */
public class Storage {
    private static ArrayList<Task> list = new ArrayList<>();
    private String filePath;

    /**
     * Initialises a Storage object that loads and saves tasks in the file.
     *
     * @param filePath Path to where the data file is stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the tasks in the data file into an ArrayList.
     *
     * @return An ArrayList containing all the tasks in the save file.
     */
    public ArrayList<Task> loadFile() {
        File file = new File(filePath);
        try {
            makeNewFile(file);
            scanContentsInFile(file);
            return list;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    /**
     * Makes a new data file to store the TaskList contents if said file does not exist.
     *
     * @param file The file to store the TaskList contents.
     * @throws IOException The exception that is thrown if the file is not created successfully.
     */
    public void makeNewFile(File file) throws IOException {
        if (!file.exists()) {
            File directory = new File(file.getParent());
            if (!directory.exists()) {
                directory.mkdirs();
            }
            file.createNewFile();
        }
    }

    /**
     * Loads the data stored in the data file into an ArrayList of Tasks.
     *
     * @param file The file that is being read by the scanner.
     * @throws IOException The exception that is thrown if there's an error when reading the file.
     */
    public void scanContentsInFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" \\| ");
            if (parts.length == 1) {
                break;
            }
            String command = parts[0];
            boolean isDone = parts[1].equals("1");
            Task task;
            switch (command) {
            case "T":
                if (parts.length != 3) {
                    System.out.println("Skipping corrupt line");
                    continue;
                }
                task = new Todo(parts[2]);
                break;
            case "D":
                if (parts.length != 4) {
                    System.out.println("Skipping corrupt line");
                    continue;
                }
                task = new Deadline(parts[2], parts[3]);
                break;
            case "E":
                if (parts.length != 5) {
                    System.out.println("Skipping corrupt line");
                    continue;
                }
                task = new Event(parts[2], parts[3], parts[4]);
                break;
            default:
                System.out.println("Skipping corrupt task type: " + command);
                continue;
            }
            if (isDone) {
                task.mark();
            }
            list.add(task);
        }
        scanner.close();
    }

    /**
     * Saves data in the current TaskList into the data file.
     *
     * @param list TaskList containing the current tasks in the program.
     */
    public void saveFile(TaskList list) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Task task : list.getTasks()) {
                printWriter.println(task.saveStringInFile());
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
