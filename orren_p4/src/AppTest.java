import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();


    //TASKITEM TESTS

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

    //TASKLIST TESTS

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskItem t = new TaskItem();
        TaskList List = new TaskList();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        List.addList(t);
        assertEquals(1, List.list.size());
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem t = new TaskItem();
        t.markComplete();
        assertEquals(true, t.Complete);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem t = new TaskItem();
        TaskList List = new TaskList();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        List.addList(t);
        assertThrows(IndexOutOfBoundsException.class,()-> List.markCom(4));
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertEquals("test", t.getTitle());
        L.editItem("edited", "edited", "2020-01-16", L, 0);
        assertEquals("edited", L.list.get(0).getTitle());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertEquals("test", t.getDescription());
        L.editItem("edited", "edited", "2020-01-16", L, 0);
        assertEquals("edited", L.list.get(0).getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertThrows(IndexOutOfBoundsException.class, ()-> L.editItem("edited", "edited", "2020-01-16", L, 99));
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertEquals("2020-11-16", t.getDueDate());
        L.editItem("edited", "edited", "2020-01-16", L, 0);
        assertEquals("2020-01-16", L.list.get(0).getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertThrows(IndexOutOfBoundsException.class,()-> L.editItem("edited", "edited", "2020-01-16", L, 99));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertEquals("test", t.getTitle());
        L.editItem("edited", "edited", "2020-01-16", L, 0);
        assertEquals("edited", L.list.get(0).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertThrows(IndexOutOfBoundsException.class, () -> L.editItem("edited", "edited", "2020-01-16", L, 99));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertThrows(IndexOutOfBoundsException.class, () -> L.getItemDescription(3));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertEquals("test", L.getItemDescription(0));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertThrows(IndexOutOfBoundsException.class, ()-> L.getItemDueDate(4));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertEquals("2020-11-16", L.getItemDueDate(0));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertThrows(IndexOutOfBoundsException.class, ()-> L.getItemTitle(4));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertEquals("test", L.getItemTitle(0));
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList L = new TaskList();
        assertEquals(0, L.list.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        L.removeFromList(0);
        assertEquals(0, L.list.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        assertThrows(IndexOutOfBoundsException.class, ()-> L.removeFromList(99));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList L = new TaskList();
        L.actualizeList("test.txt", L);
        assertEquals("test", L.getItemTitle(0));
        assertEquals("new", L.getItemTitle(1));
    }

    @Test
    public void unCompletingTaskItemChangesStatus(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        L.markCom(0);
        assertEquals(true, L.list.get(0).Complete);
        L.unMarkCom(0);
        assertEquals(false, L.list.get(0).Complete);
    }

    @Test
    public void unCompletingTaskItemFailsWithInvalidIndex(){
        TaskList L = new TaskList();
        TaskItem t = new TaskItem();
        t.setTitle("test");
        t.setDescription("test");
        t.setDueDate("2020-11-16");
        L.addList(t);
        L.markCom(0);
        assertThrows(IndexOutOfBoundsException.class, ()-> L.unMarkCom(99));
    }
}