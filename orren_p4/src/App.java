import java.util.Scanner;

public class App {

    private static void printMainMenu(){
        System.out.println("Main Menu\n---------\n");
        System.out.println("1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n");
    }

    private static void printListOperations(){
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

    private static void mainMenu(){
        int choice;
        while(true) {
            printMainMenu();
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
            if(choice == 3)
                break;
            if(choice != 1 && choice != 2 && choice != 3) {
                System.out.println("WARNING: invalid choice");
            }

        }
    }

    private static void listOperation(TaskList List) {
        int choice;
        boolean gargantuan = true;
        while(gargantuan) {
            printListOperations();
            choice = s.nextInt();
            if(choice < 1 || choice > 8)
                System.out.println("WARNING: invalid choice");
            switch(choice){
                case 1:
                    viewList(List);
                    break;
                case 2:
                    addItem(List);
                    break;
                case 3:
                    editItem(List);
                    break;
                case 4:
                    removeItem(List);
                    break;
                case 5:
                    markItemComplete(List);
                    break;
                case 6:
                    unMarkItemComplete(List);
                    break;
                case 7:
                    saveList(List);
                    break;
                case 8:
                    gargantuan = false;
                    break;
            }
        }
    }

    private static void saveList(TaskList List){
        s.nextLine();
        System.out.printf("Enter the filename to save as: ");
        String filename = s.nextLine();
        List.saveList(filename);
    }

    private static void unMarkItemComplete(TaskList List) {
        List.printList();
        System.out.println("\nWhich task will you unmark as completed?");
        int choice = s.nextInt();
        List.unMarkCom(choice);
    }

    private static void markItemComplete(TaskList List) {
        List.printList();
        System.out.println("\nWhich task will you mark as completed?");
        int choice = s.nextInt();
        List.markCom(choice);
    }

    private static void removeItem(TaskList List) {
        List.printList();
        System.out.println("Which task will you remove?");
        int choice = s.nextInt();
        List.removeFromList(choice);
    }

    private static void editItem(TaskList List) {
        List.printList();
        TaskItem newItem = new TaskItem();
        System.out.println("\nWhich task will you edit?");
        int choice = s.nextInt();
        s.nextLine();
        System.out.println("Enter a new title for task " + choice + ": ");
        String newT = s.nextLine();
        System.out.println("Enter a new description for task " + choice + ": ");
        String newD = s.nextLine();
        System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + choice + ": ");
        String newDD = s.nextLine();
        List.list.remove(choice);
        newItem.setTitle(newT);
        newItem.setDescription(newD);
        newItem.setDueDate(newDD);
        List.list.add(choice, newItem);
    }

    private static void viewList(TaskList List) {
        List.printList();
    }

    private static void addItem(TaskList List) {
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

    public static void main (String[] args){
        mainMenu();
    }

}
