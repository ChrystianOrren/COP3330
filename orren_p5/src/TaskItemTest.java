import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void testSettingInvalidTitle(){
        TaskItem t = new TaskItem();
        t.setTitle("");
        assertEquals(0, t.checkTitle());
    }

    @Test
    public void testSettingValidTitle(){
        TaskItem t = new TaskItem();
        t.setTitle("title");
        assertEquals(1, t.checkTitle());
    }

    @Test
    public void testSettingValidDueDate(){
        TaskItem t = new TaskItem();
        assertEquals(1, t.setDueDate("2020-11-16"));
    }

    @Test
    public void testSettingInvalidDueDate(){
        TaskItem t = new TaskItem();
        assertEquals(0, t.setDueDate("2020-50-16"));
    }

    @Test
    public void testCreateWithInvalidTitle(){
        TaskItem t = new TaskItem();
        t.setTitle("");
        assertEquals(0, t.checkTitle());
    }

}