import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Scanner;

public class ContactList {

    protected ArrayList<ContactItem> contactList = new ArrayList<ContactItem>();

    public void printList() {
        System.out.println("Current Contacts\n-------------\n");
        Iterator itr = contactList.iterator();
        int i=0;
        while(itr.hasNext()){
            ContactItem c = (ContactItem)itr.next();
            System.out.println(i + ") Name: " + c.firstName + " " + c.lastName + "\nPhone: " + c.phoneNumber + "\nEmail: " + c.email);
            i++;
        }
    }

    protected void addNew(ContactList cList, ContactItem temp){
        if(temp.firstName.length() == 0 && temp.lastName.length() == 0 && temp.phoneNumber.length() == 0 && temp.email.length() == 0){
            System.out.println("WARNING: Creation failed due to lack of information");
            return;
        }
        cList.contactList.add(temp);
    }

    public void editContact(ContactList cList, String fn, String ln, String pn, String em, int c) throws IndexOutOfBoundsException{
        if(c > cList.contactList.size() || c < 0){
            System.out.println("WARNING: out of bounds index");
        }
        ContactItem newC = new ContactItem();
        newC.setFirstName(fn);
        newC.setLastName(ln);
        newC.setPhoneNumber(pn);
        newC.setEmail(em);
        if(newC.firstName.length() == 0 && newC.lastName.length() == 0 && newC.phoneNumber.length() == 0 && newC.email.length() == 0){
            System.out.println("WARNING: Creation failed due to lack of information");
            return;
        }
        cList.contactList.remove(c);
        cList.contactList.add(c, newC);
    }

    public void removeContact(int c) {
        contactList.remove(c);
    }

    public void saveList(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0 ;i < contactList.size();i++){
                ContactItem c = contactList.get(i);
                output.format("%s, %s, %s, %s\n", c.firstName, c.lastName, c.phoneNumber, c.email);
            }
        } catch (FileNotFoundException e) {
            System.out.println("WARNING: file not found");
        } catch(Exception e){
            System.out.println("WARNING: An error has occurred");
        }
        System.out.println("Task list has been saved");
    }

    public void actualizeList(String filename, ContactList cList) {
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
            ContactItem temp = new ContactItem();
            String[] data = line[i].split(", ");
            temp.setFirstName(data[0]);
            temp.setLastName(data[1]);
            temp.setPhoneNumber(data[2]);
            temp.setEmail(data[3]);
            cList.addList(temp);
        }
    }

    private void addList(ContactItem temp) {
        contactList.add(temp);
    }
}
