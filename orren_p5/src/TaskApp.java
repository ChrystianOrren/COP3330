import java.util.Scanner;

public class TaskApp {

    protected static void printTaskMainMenu(){
        System.out.println("Main Menu\n---------\n");
        System.out.println("1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n");
    }

    protected static void printTaskListOperations(){
        System.out.println("\nList Operation Menu\n---------\n");
        System.out.println("1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu\n");
    }

    private static Scanner s = new Scanner(System.in);

    protected static void taskMainMenu(){
        int choice;
        boolean x = true;
        while(x) {
            printTaskMainMenu();
            choice = s.nextInt();
            if(choice == 1 ){
                TaskList List = new TaskList();
                System.out.println("New task list has been created");
                listOperation(List);
            }
            if(choice == 2){
                s.nextLine();
                TaskList List = new TaskList();
                System.out.printf("\nEnter filename to load: ");
                String filename = s.nextLine();
                List.actualizeList(filename, List);
                System.out.println("Task list has been loaded");
                listOperation(List);
                break;
            }
            if(choice == 3){
                x = false;
            }
            if(choice != 1 && choice != 2 && choice != 3) {
                System.out.println("WARNING: invalid choice");
            }

        }
    }

    private static void listOperation(TaskList List) {
        int choice;
        boolean gargantuan = true;
        while(gargantuan) {
            printTaskListOperations();
            choice = s.nextInt();
            if(choice < 1 || choice > 8)
                System.out.println("WARNING: invalid choice");
            switch(choice){
                case 1:
                    viewTaskList(List);
                    break;
                case 2:
                    addTaskItem(List);
                    break;
                case 3:
                    editTaskItem(List);
                    break;
                case 4:
                    removeTaskItem(List);
                    break;
                case 5:
                    markTaskItemComplete(List);
                    break;
                case 6:
                    unMarkTaskItemComplete(List);
                    break;
                case 7:
                    saveTaskList(List);
                    break;
                case 8:
                    gargantuan = false;
                    break;
            }
        }
        taskMainMenu();
    }

    private static void saveTaskList(TaskList List){
        s.nextLine();
        System.out.printf("Enter the filename to save as: ");
        String filename = s.nextLine();
        List.saveList(filename);
    }

    private static void unMarkTaskItemComplete(TaskList List) {
        List.printList();
        System.out.println("\nWhich task will you unmark as completed?");
        int choice = s.nextInt();
        List.unMarkCom(choice);
    }

    private static void markTaskItemComplete(TaskList List) {
        List.printList();
        System.out.println("\nWhich task will you mark as completed?");
        int choice = s.nextInt();
        List.markCom(choice);
    }

    private static void removeTaskItem(TaskList List) {
        List.printList();
        System.out.println("Which task will you remove?");
        int choice = s.nextInt();
        List.removeFromList(choice);
    }

    private static void editTaskItem(TaskList List) {
        List.printList();
        System.out.println("\nWhich task will you edit?");
        int choice = s.nextInt();
        s.nextLine();
        System.out.println("Enter a new title for task " + choice + ": ");
        String newT = s.nextLine();
        System.out.println("Enter a new description for task " + choice + ": ");
        String newD = s.nextLine();
        System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + choice + ": ");
        String newDD = s.nextLine();
        List.editItem(newT, newD, newDD, List, choice);
    }

    private static void viewTaskList(TaskList List) {
        List.printList();
    }

    private static void addTaskItem(TaskList List) {
        TaskItem newItem = new TaskItem();
        String newDesc;
        String newTitle;
        String newDueDate;
        s.nextLine();
        System.out.println("Task title: ");
        newTitle = s.nextLine();
        System.out.println("Task description: ");
        newDesc = s.nextLine();
        System.out.println("Task due date (YYYY-MM-DD): ");
        newDueDate = s.nextLine();
        newItem.setDescription(newDesc);
        newItem.setTitle(newTitle);
        if(newItem.checkTitle() == 0 || newItem.setDueDate(newDueDate) == 0) {
            System.out.printf("; task not created");
            return;
        }
        List.addList(newItem);
    }

}
