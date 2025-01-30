package luigi.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    void toString_validDeadline_correctFormat() {
        Deadline deadline = new Deadline("return book", "2025-06-28 2000");
        String expected = "[D][ ] return book (by: Jun 28 2025 20:00)";
        assertEquals(expected, deadline.toString());
    }
}
