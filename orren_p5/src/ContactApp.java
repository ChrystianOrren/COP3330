import java.util.Scanner;

public class ContactApp {

    private Scanner s = new Scanner(System.in);

    private void printListOperations(){
        System.out.println("\nList Operation Menu\n---------\n");
        System.out.println("1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) save the current list\n" +
                "6) quit to the main menu\n");
    }

    private void listContactOperations(ContactList cList){
        int c;
        boolean x = true;
        while(x){
            printListOperations();
            c = s.nextInt();
            switch(c){
                case 1:
                    viewContactList(cList);
                    break;
                case 2:
                    addContactList(cList);
                    break;
                case 3:
                    editContactList(cList);
                    break;
                case 4:
                    removeContactList(cList);
                    break;
                case 5:
                    saveContactList(cList);
                    break;
                case 6:
                    x = false;
                    break;
                default:
                    System.out.println("WARNING: Invalid choice");
            }
        }
        contactMainMenu();
    }

    private void saveContactList(ContactList cList) {
        s.nextLine();
        System.out.printf("Enter the filename to save as: ");
        String filename = s.nextLine();
        cList.saveList(filename);
    }

    private void removeContactList(ContactList cList) {
        cList.printList();
        System.out.println("\nWhich contact will you remove?");
        int c = s.nextInt();
        cList.removeContact(c);
    }

    private void editContactList(ContactList cList) {
        viewContactList(cList);
        int c;
        System.out.println("\nWhich contact will you edit?");
        c = s.nextInt();
        s.nextLine();
        System.out.printf("\nEnter a new first name for contact %d: ", c);
        String fn = s.nextLine();
        System.out.printf("\nEnter a new last name for contact %d: ", c);
        String ln = s.nextLine();
        System.out.printf("\nEnter a new phone number (xxx-xxx-xxxx) for contact %d: ", c);
        String pn = s.nextLine();
        System.out.printf("\nEnter a new email address (x@y.z) for contact %d: ", c);
        String em = s.nextLine();
        cList.editContact(cList, fn, ln, pn, em, c);

    }

    protected void contactMainMenu() {
        boolean x = true;
        int c;
        while(x){
            TaskApp app = new TaskApp();
            app.printTaskMainMenu();
            c = s.nextInt();
            if(c == 1){
                ContactList cList = new ContactList();
                System.out.println("New contact list has been created");
                listContactOperations(cList);
            }
            else if(c == 2){
                s.nextLine();
                ContactList cList = new ContactList();
                System.out.printf("\nEnter filename to load: ");
                String filename = s.nextLine();
                cList.actualizeList(filename, cList);
                System.out.println("Task list has been loaded");
                listContactOperations(cList);
            }
            else if(c == 3){
                x = false;
            }
            else{
                System.out.println("WARNING: Invalid choice");
            }
        }
    }

    private void addContactList(ContactList cList) {
        ContactItem temp = new ContactItem();
        String fn;
        String ln;
        String pn;
        String em;
        s.nextLine();
        System.out.printf("\nFirst name: ");
        fn = s.nextLine();
        System.out.printf("\nLast name: ");
        ln = s.nextLine();
        System.out.printf("\nPhone number (xxx-xxx-xxxx): ");
        pn = s.nextLine();
        System.out.printf("\nEmail address (x@y.z): ");
        em = s.nextLine();
        temp.setFirstName(fn);
        temp.setLastName(ln);
        temp.setPhoneNumber(pn);
        temp.setEmail(em);
        cList.addNew(cList, temp);
    }

    private void viewContactList(ContactList cList) {
        cList.printList();
    }

}
