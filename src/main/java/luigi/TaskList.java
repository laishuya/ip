package luigi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import luigi.tasks.Deadline;
import luigi.tasks.Event;
import luigi.tasks.Task;
import luigi.tasks.Todo;

/**
 * Stores the user's Tasks in an ArrayList.
 * Allows manipulation of the list, such as adding and deleting tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList(ArrayList<Task> list) {
        this.tasks = list;
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Finds all Task descriptions containing the same word.
     *
     * @param word The common keyword to find.
     * @return A list of Tasks containing the specified word.
     */
    public ArrayList<Task> findTasksWithSameWord(String word) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task: this.tasks) {
            if (task.getDescription().contains(word)) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    /**
     * Finds all Tasks with the same date.
     *
     * @param date The common date the Tasks should share.
     * @return A string of all the Tasks with the same date.
     */
    public String findAllTasksWithSameDate(String date) {
        StringBuilder sb = new StringBuilder();
        String inputFormat = "yyyy-MM-dd";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(inputFormat, Locale.ENGLISH);
        LocalDate targetDate = LocalDate.parse(date, format);
        for (Task task : tasks) {
            if (task instanceof Deadline) {
                Deadline deadline = (Deadline) task;
                if (deadline.getLocalDate().equals(targetDate)) {
                    sb.append(deadline + System.lineSeparator());
                }
            }
            if (task instanceof Event) {
                Event event = (Event) task;
                if (event.getFromLocalDate().equals(targetDate)
                        || event.getToLocalDate().equals(targetDate)) {
                    sb.append(event + System.lineSeparator());
                }
            }
        }
        return sb.toString();
    }

    /**
     * Makes a list of all Tasks currently in the TaskList.
     *
     * @return A string of all the Tasks in the TaskList.
     */
    public String getListToPrint() {
        return "Here are your tasks:" + System.lineSeparator()
                + IntStream.range(0, tasks.size())
                        .mapToObj(i -> (i + 1) + ". " + tasks.get(i))
                        .collect(Collectors.joining(System.lineSeparator()));
    }

    /**
     * Deletes the Task in the specified index position.
     *
     * @param index The position of the task in the list.
     * @return A string of the Task that was deleted.
     */
    public String deleteTask(int index) {
        StringBuilder sb = new StringBuilder();
        Task task = tasks.get(index);
        tasks.remove(index);
        sb.append("Noted. I've disposed of this task:" + System.lineSeparator());
        sb.append("  " + task + System.lineSeparator());
        sb.append("You now have " + tasks.size() + " tasks in your list");
        return sb.toString();
    }

    /**
     * Adds a ToDo Task to the list.
     *
     * @param description Details of the ToDo Task.
     * @return A string containing details of the ToDo Task.
     */
    public String addToDo(String description) {
        StringBuilder sb = new StringBuilder();
        Task task = new Todo(description);
        tasks.add(task);
        sb.append("Got it! I've added this task:)" + System.lineSeparator());
        sb.append("  " + task + System.lineSeparator());
        sb.append("You now have " + tasks.size() + " tasks in your list");
        return sb.toString();
    }

    /**
     * Adds a Deadline Task to the list.
     *
     * @param description Details of the Deadline Task.
     * @param by The due date of the Task.
     * @return A string containing details of the Deadline Task.
     */
    public String addDeadline(String description, String by) {
        StringBuilder sb = new StringBuilder();
        Task task = new Deadline(description, by);
        tasks.add(task);
        sb.append("Got it! I've added this task:" + System.lineSeparator());
        sb.append("  " + task + System.lineSeparator());
        sb.append("You now have " + tasks.size() + " tasks in your list");
        return sb.toString();
    }

    /**
     * Adds an Event Task to the list.
     *
     * @param description Details of the Event Task.
     * @param from Start date and time of the Task.
     * @param to End date and time of the Task.
     * @return A string containing details of the Event Task.
     */
    public String addEvent(String description, String from, String to) {
        StringBuilder sb = new StringBuilder();
        Task task = new Event(description, from, to);
        tasks.add(task);
        sb.append("Got it! I've added this task:" + System.lineSeparator());
        sb.append("  " + task + System.lineSeparator());
        sb.append("You now have " + tasks.size() + " tasks in your list");
        return sb.toString();
    }

    /**
     * Marks a Task as completed.
     *
     * @param index The position of the Task in the list.
     * @return A string of the marked Task.
     */
    public String mark(int index) {
        StringBuilder sb = new StringBuilder();
        Task task = tasks.get(index);
        task.mark();
        sb.append("Successfully marked!" + System.lineSeparator());
        sb.append("  " + task);
        return sb.toString();
    }

    /**
     * Unmarks a Task as completed.
     *
     * @param index The position of the Task in the list.
     * @return A string of the unmarked Task.
     */
    public String unmark(int index) {
        StringBuilder sb = new StringBuilder();
        Task task = tasks.get(index);
        task.unmark();
        sb.append("Successfully unmarked!" + System.lineSeparator());
        sb.append("  " + task);
        return sb.toString();
    }
}
