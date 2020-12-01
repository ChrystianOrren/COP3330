import java.io.*;
import java.util.*;

public class TaskList {

    protected ArrayList<TaskItem> list = new ArrayList<TaskItem>();

    protected void addList(TaskItem item){
        list.add(item);
    }

    protected void removeFromList(int i)throws IndexOutOfBoundsException{
        list.remove(i);
    }

    protected void printList(){
        System.out.println("Current Tasks\n-------------\n");
        Iterator itr = list.iterator();
        int i = 0;
        while(itr.hasNext()){
            TaskItem t = (TaskItem)itr.next();
            if(t.Complete == true){
                System.out.println(i + ") " + "*** " + "[" + t.DueDate + "]" + " " + t.Title + ": " + t.Description);
                i++;
            }
            else
                System.out.println(i + ") " + "[" + t.DueDate + "]" + " " + t.Title + ": " + t.Description);
            i++;
        }
    }

    protected void saveList(String filename){
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0 ;i < list.size();i++){
                TaskItem t = list.get(i);
                output.format("%s, %s, %s, %B\n", t.DueDate, t.Title, t.Description, t.Complete);
            }
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: file not found");
        } catch(Exception e){
            System.out.println("WARNING: An error has occurred");
        }
        System.out.println("Task list has been saved");
    }

    protected void unMarkCom(int index)throws IndexOutOfBoundsException{
        if(index > list.size() || index < 0){
            System.out.println("WARNING: out of bounds choice");
        }
        list.get(index).Complete = false;
    }

    protected void markCom(int index)throws IndexOutOfBoundsException {
        if(index > list.size() || index < 0){
            System.out.println("WARNING: out of bounds choice");
        }
        list.get(index).Complete = true;
    }

    protected void actualizeList(String filename, TaskList List){
        File file = new File(filename);
        String line[] = new String[100];
        int lineCounter = 0;
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()){
                line[lineCounter] = scanner.nextLine();
                lineCounter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: File not found");
        } catch(Exception e){
            System.out.println("WARNING: An error has occurred");
        }

        for(int i = 0;i < lineCounter;i++){
            TaskItem temp = new TaskItem();
            String[] data = line[i].split(", ");
            temp.setDueDate(data[0]);
            temp.setTitle(data[1]);
            temp.setDescription(data[2]);
            temp.setComplete(data[3]);
            List.addList(temp);
        }
    }

    protected void editItem(String newT, String newD, String newDD, TaskList List, int choice) throws IndexOutOfBoundsException{
        if(choice > List.list.size() || choice < 0){
            System.out.println("WARNING: out of bounds index");
        }
        TaskItem newItem = new TaskItem();
        List.list.remove(choice);
        newItem.setTitle(newT);
        newItem.setDescription(newD);
        newItem.setDueDate(newDD);
        List.list.add(choice, newItem);
    }

    protected String getItemDescription(int index) throws IndexOutOfBoundsException{
        return list.get(index).getDescription();
    }

    protected String getItemDueDate(int index) throws IndexOutOfBoundsException{
        return list.get(index).getDueDate();
    }

    public String getItemTitle(int i) throws IndexOutOfBoundsException{
        return list.get(i).getTitle();
    }
}