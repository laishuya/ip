package luigi.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * The class that tests methods from the Deadline class.
 */
public class DeadlineTest {
    @Test
    void toString_validDeadline_correctFormat() {
        Deadline deadline = new Deadline("return book", "2025-06-28 2000");
        String expected = "[D][ ] return book (by: Jun 28 2025 20:00)";
        assertEquals(expected, deadline.toString());
    }

    @Test
    void toString_taskCompleted_correctFormat() {
        Deadline deadline = new Deadline("submit report", "2025-07-15 0900");
        deadline.mark();
        String expected = "[D][X] submit report (by: Jul 15 2025 09:00)";
        assertEquals(expected, deadline.toString());
    }

    @Test
    void getLocalDateOfDeadline_localDateAdded_correctDate() {
        Deadline deadline = new Deadline("return book", "2025-06-28 2000");
        LocalDate expectedDate = LocalDate.of(2025, 6, 28);
        assertEquals(expectedDate, deadline.getLocalDateOfDeadline());
    }

    @Test
    void saveStringInFile_deadlineAdded_correctFormat() {
        Deadline deadline = new Deadline("complete assignment", "2025-09-01 1800");
        String expected = "D | 0 | complete assignment | 2025-09-01 1800";
        assertEquals(expected, deadline.saveStringInFile());
    }
}
