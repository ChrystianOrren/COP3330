import java.util.Arrays;

public class Decrypter
{

    public static void main(String[] args)
    {
        decrypt(args[0]);
    }

    public static String decrypt(String args)
    {
        int[] arr;
        arr = new int[4];

        ConvertToInt(args, arr);
        Step1(arr);
        Step2(arr);

        String answer = "";
        answer = ConvertToString(answer, arr);

        return answer;
    }

    public static void ConvertToInt(String number, int[] arr)
    {
        for(int i=0;i<4;i++){
            arr[i] = number.charAt(i) - 48;
        }
    }

    public static String ConvertToString(String answer, int[] arr)
    {
        StringBuilder answerBuilder = new StringBuilder(answer);
        for(int i = 0; i<4; i++) {
            answerBuilder.append(arr[i]);
        }
        answer = answerBuilder.toString();

        return answer;
    }


    public static void Step2(int[] arr)
    {
        for(int i=0;i<4;i++){
            if (arr[i] < 7) {
                arr[i] += 10;
            }
            arr[i] -= 7;
        }
    }

    public static void Step1(int[] arr)
    {
        int temp;

        temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;

        temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;
    }
}