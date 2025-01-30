package luigi;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void deleteTask_validIndex_removedSuccessfully() {
        TaskList taskList = new TaskList(new ArrayList<>());
        taskList.addToDo("test");
        int expected = taskList.getTasks().size() - 1;
        taskList.deleteTask(0);
        int actual = taskList.getTasks().size();
        assertEquals(expected, actual);
    }

    @Test
    public void deleteTask_invalidIndex_exceptionThrown() {
        TaskList taskList = new TaskList(new ArrayList<>());
        assertThrows(IndexOutOfBoundsException.class,
                () -> taskList.deleteTask(0));
    }
}
