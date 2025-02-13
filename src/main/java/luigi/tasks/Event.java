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
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    /**
     * Creates an Event object, which represents the start and end time of the event.
     *
     * @param description Details of the Event Task.
     * @param startDate Start date of the event task.
     * @param endDate End date of the event task.
     * @throws DateTimeParseException
     */
    public Event(String description, String startDate, String endDate) throws DateTimeParseException {
        super(description);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        this.startDate = LocalDateTime.parse(startDate, format);
        this.endDate = LocalDateTime.parse(endDate, format);
    }

    /**
     * Returns the start date of the Event Task.
     */
    public LocalDate getStartDate() {
        return this.startDate.toLocalDate();
    }

    /**
     * Returns the start date and time of the Event Task.
     */
    public LocalDateTime getStartDateTime() {
        return this.startDate;
    }

    /**
     * Returns the end date of the Event Task.
     */
    public LocalDate getEndDate() {
        return this.endDate.toLocalDate();
    }

    /**
     * Returns the end date and time of the Event Task.
     */
    public LocalDateTime getEndDateTime() {
        return this.endDate;
    }

    /**
     * Converts information of the Event into a string, to be saved in data file.
     */
    @Override
    public String saveStringInFile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(INPUT_FORMAT, Locale.ENGLISH);
        return String.format("%s | %d | %s | %s | %s", "E", getStatusNumber(),
                this.description, this.startDate.format(format), this.endDate.format(format));
    }

    /**
     * Returns the string information of the Event, to be displayed to users.
     */
    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DISPLAY_FORMAT, Locale.ENGLISH);
        return "[E]" + super.toString() + " (from: "
                + this.startDate.format(format) + " to: " + this.endDate.format(format) + ")";
    }
}
