public class Encrypter
{


    public static String encrypt(String args){
        int[] arr;
        arr = new int[4];

        convertToInt(args, arr);
        step1(arr);
        step2(arr);

        String answer = "";
        answer = convertToString(answer, arr);

        return answer;
    }

    public static void convertToInt(String input, int[] arr){
        for(int i=0;i<4;i++){
            arr[i] = input.charAt(i) - 48;
        }
    }

    public static String convertToString(String answer, int[] arr){

        StringBuilder answerBuilder = new StringBuilder(answer);
        for(int i = 0; i<4; i++) {
            answerBuilder.append(arr[i]);
        }
        answer = answerBuilder.toString();

        return answer;
    }


    public static void step1(int[] x)
    {
        for(int i=0;i<4;i++)
        {
            x[i] += 7;
            x[i] = x[i] % 10;
        }

    }

    public static void step2(int[] x)
    {
       int temp;

       temp = x[0];
       x[0] = x[2];
       x[2] = temp;

       temp = x[1];
       x[1] = x[3];
       x[3] = temp;

    }

}
