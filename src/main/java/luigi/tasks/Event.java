package luigi.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Represents a Task with a start and end date, which includes date, year and time.
 */
public class Event extends Task {
    private static final String INPUT_FORMAT = "yyyy-MM-dd HHmm";
    private static final String DISPLAY_FORMAT = "MMM dd yyyy HH:mm";
    private LocalDateTime from;
    private LocalDateTime to;

    /**
     * Creates an Event object, which represents the start and end time of the event.
     *
     * @param description Details of the Event Task.
     * @param from Start date of the event task.
     * @param to End date of the event task.
     * @throws DateTimeParseException
     */
    public Event(String description, String from, String to) throws DateTimeParseException {
        super(description);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        this.from = LocalDateTime.parse(from, format);
        this.to = LocalDateTime.parse(to, format);
    }

    public LocalDate getFromLocalDate() {
        return this.from.toLocalDate();
    }

    public LocalDate getToLocalDate() {
        return this.to.toLocalDate();
    }

    /**
     * Converts information of the Event into a string, to be saved in data file.
     */
    @Override
    public String saveStringInFile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        return String.format("%s | %d | %s | %s | %s", "E", getStatusNumber(),
                this.description, this.from.format(format), this.to.format(format));
    }

    /**
     * Returns the string information of the Event, to be displayed to users.
     */
    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DISPLAY_FORMAT, Locale.ENGLISH);
        return "[E]" + super.toString() + " (from: "
                + this.from.format(format) + " to: " + this.to.format(format) + ")";
    }
}
