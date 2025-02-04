package luigi.tasks;

/**
 * Represents the base Task class, which the Deadline, Todo and Event subclasses extend from.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a Task object with the task description.
     *
     * @param description Details about the Task to accomplish.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Marks done task with X.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    /**
     * Marks done task with 1.
     */
    public int getStatusNumber() {
        return (isDone ? 1 : 0);
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    /**
     * Converts information of the Task into a string, to be saved in data file.
     * Will never be called since only subclasses of Task are instantiated.
     */
    public String saveStringInFile() {
        return "You should not see this";
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + this.description;
    }
}
