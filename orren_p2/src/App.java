import java.util.ArrayList;
import java.util.Scanner;


public class App
{

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println("BMI: " + bmi.bmi1);
        BodyMassIndex.Category();
    }

    public static boolean moreInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Y or N");
        char input = in.nextLine().charAt(0);
        boolean YorN = false;
        if(input == 'Y'){
            YorN = true;
        }
        return YorN;
    }

    public static double getUserHeight(){
        Scanner in = new Scanner(System.in);
        boolean check = true;
        double height = 0;
        while(check) {
            System.out.println("Enter height: ");
            height = in.nextDouble();
            if(height > 0){
                check = false;
            }
        }
        return height;
    }

    public static double getUserWeight(){
        Scanner in = new Scanner(System.in);
        boolean check = true;
        double weight = 0;
        while(check) {
            System.out.println("Enter weight: ");
            weight = in.nextDouble();
            if(weight > 0){
                check = false;
            }
        }
        return weight;
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        System.out.println("Average: " + (BodyMassIndex.total/BodyMassIndex.size));
        //lmao
    }

}
