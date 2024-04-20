import java.util.*;

public class Main {
    public static int[] arr;
    public static int m;
    public static int count;
    public static void find(){
        int end = 0;
        int currentSum = 0;
        for(int i = 0;i < arr.length; i++){
            while(end < arr.length && currentSum < m){
                currentSum += arr[end++];
            }
            if(currentSum == m){
                count++;
            }
            currentSum -= arr[i];
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        arr = new int[Integer.parseInt(input[0])];
        m = Integer.parseInt(input[1]);

        
        String[] arrInput = sc.nextLine().split(" ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(arrInput[i]);
        }
        find();

        System.out.println(count);
    }
}