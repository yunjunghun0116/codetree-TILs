import java.util.*;

public class Main {
    public static long[] arr = new long[1000001];
    public static int maxLength;
    public static long maxValue = Long.MIN_VALUE;

    public static void find(){

        int end = 1;
        int currentSum = 0;
        for(int i = 1; i < arr.length; i++){
            while(end < arr.length && end-i+1 <= maxLength){
                // System.out.println("start : "+i+", end : "+end);
                currentSum+=arr[end++];
            }
            // System.out.println();
            maxValue = Math.max(maxValue, currentSum);
            currentSum -= arr[i];
        }

    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        maxLength = 2 * Integer.parseInt(input[1])+1;

        for(int i =0; i<Integer.parseInt(input[0]); i++){
            String[] candy = sc.nextLine().split(" ");
            arr[Integer.parseInt(candy[1])] = arr[Integer.parseInt(candy[1])]+Integer.parseInt(candy[0]);
        }

        find();

        System.out.println(maxValue);
    }
}