package luigi;

import luigi.tasks.Deadline;
import luigi.tasks.Event;
import luigi.tasks.Task;
import luigi.tasks.Todo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;
    private static ArrayList<Task> list = new ArrayList<>();

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadFile() {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                File directory = new File(file.getParent());
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                file.createNewFile();
            }

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
            return list;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

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
