package luigi.tasks;
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    public int getStatusNumber() {
        return (isDone ? 1 : 0); // mark done task with 1
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String saveStringInFile() {
        return "You should not see this";
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + this.description;
    }
}