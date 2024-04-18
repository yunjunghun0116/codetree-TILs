import java.util.*;

public class Main {
    public static int[] arr;
    public static int minLength = Integer.MAX_VALUE;
    public static int s;
    public static void find(){
        int end = 0;
        int currentSum = 0;
        for(int i = 0; i < arr.length; i++){
            while(end < arr.length && currentSum < s) {
                currentSum += arr[end];
                end++;
            }

            if(currentSum>= s){
                minLength = Math.min(minLength, end - i);
            }

            currentSum -= arr[i];
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        arr = new int[Integer.parseInt(input[0])];
        s = Integer.parseInt(input[1]);
        String[] arrInput = sc.nextLine().split(" ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        find();
        if(minLength == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(minLength);
    }
}