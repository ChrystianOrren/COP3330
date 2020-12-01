import java.util.Scanner;

public class App {

    private static Scanner s = new Scanner(System.in);

    private static void appSelect(){
        boolean x = true;
        int c;
        while(x){
            System.out.println("Select Your Application\n" + "-----------------------\n");
            System.out.println("1) task list\n" + "2) contact list\n" + "3) quit\n");
            c = s.nextInt();
            if(c == 1){
                TaskApp taskApp = new TaskApp();
                taskApp.taskMainMenu();
            }
            else if(c == 2){
                ContactApp contactApp = new ContactApp();
                contactApp.contactMainMenu();
            }
            else if(c == 3){
                x = false;
            }
            else{
                System.out.println("WARNING: out of bounds choice\n");
            }
        }
    }

    public static void main (String[] args){
        appSelect();
    }
}