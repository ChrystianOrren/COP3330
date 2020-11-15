import java.io.*;
import java.util.*;

public class TaskList {

    protected ArrayList<TaskItem> list = new ArrayList<TaskItem>();

    protected void addList(TaskItem item){
        list.add(item);
    }

    protected void removeFromList(int i){
        list.remove(i);
    }

    protected void printList(){
        System.out.println("Current Tasks\n-------------\n");
        Iterator itr = list.iterator();
        int i = 0;
        while(itr.hasNext()){
            TaskItem t = (TaskItem)itr.next();
            System.out.println(i + ") " + "[" + t.DueDate + "]" + " " + t.Title + ": " + t.Description);
            i++;
        }
    }

    protected void saveList(String filename){
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0 ;i < list.size();i++){
                TaskItem t = list.get(i);
                output.format("%s, %s, %s\n", t.DueDate, t.Title, t.Description);
            }
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: file not found");
        } catch(Exception e){
            System.out.println("WARNING: An error has occurred");
        }
        System.out.println("Task list has been saved");
    }

    protected void unMarkCom(int choice){
        Iterator itr = list.iterator();
        int counter = 0;
        while(itr.hasNext()){
            TaskItem t = (TaskItem)itr.next();
            if(counter == choice){
                t.markUnComplete();
            }
            counter++;
        }
    }

    protected void markCom(int choice) {
        Iterator itr = list.iterator();
        int counter = 0;
        while(itr.hasNext()){
            TaskItem t = (TaskItem)itr.next();
            if(counter == choice){
                t.markComplete();
            }
            counter++;
        }
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
            List.addList(temp);
        }
    }

}