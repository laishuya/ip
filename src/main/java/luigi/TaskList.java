package luigi;

import luigi.tasks.Deadline;
import luigi.tasks.Event;
import luigi.tasks.Task;
import luigi.tasks.Todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class TaskList {
    private ArrayList<Task> list;
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getTasks() {
        return this.list;
    }

    /**
     * Find all task descriptions containing the same word.
     *
     * @param word The common keyword to find.
     * @return A list of tasks containing the specified word.
     */
    public ArrayList<Task> findTasksWithSameWord(String word) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task: list) {
            if (task.getDescription().contains(word)) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    /**
     * Finds all tasks with the same date.
     *
     * @param date The common date the tasks should share.
     */
    public void findAllTasksWithSameDate(String date) {
        String inputFormat = "yyyy-MM-dd";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(inputFormat, Locale.ENGLISH);
        LocalDate targetDate = LocalDate.parse(date, format);
        for (Task task : list) {
            if (task instanceof Deadline) {
                Deadline deadline = (Deadline) task;
                if (deadline.getLocalDate().equals(targetDate)) {
                    System.out.println(deadline);
                }
            }
            if (task instanceof Event) {
                Event event = (Event) task;
                if (event.getFromLocalDate().equals(targetDate)
                        || event.getToLocalDate().equals(targetDate)) {
                    System.out.println(event);
                }
            }
        }
    }

    /**
     * Prints all the tasks in the list.
     */
    public void printList() {
        System.out.println("Here are your tasks:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public void deleteTask(int index) {
        Task task = list.get(index);
        list.remove(index);
        System.out.println("Noted. I've disposed of this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
    }

    public void addToDo(String description) {
        Task task = new Todo(description);
        list.add(task);
        System.out.println("Got it! I've added this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
    }

    public void addDeadline(String description, String by) {
        Task task = new Deadline(description, by);
        list.add(task);
        System.out.println("Got it! I've added this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
    }

    public void addEvent(String description, String from, String to) {
        Task task = new Event(description, from, to);
        list.add(task);
        System.out.println("Got it! I've added this task:");
        System.out.println("  " + task);
        System.out.println("You now have " + list.size() + " tasks in your list");
    }

    public void mark(int index) {
        Task task = list.get(index);
        task.mark();
        System.out.println("Successfully marked!");
        System.out.println("  " + task);
    }

    public void unmark(int index) {
        Task task = list.get(index);
        task.unmark();
        System.out.println("Successfully unmarked!");
        System.out.println("  " + task);
    }
}
