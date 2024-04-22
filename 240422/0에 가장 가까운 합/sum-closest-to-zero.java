import java.util.*;

public class Main {
    public static int[] arr;
    public static int minValue;
    public static void find(){
        int end = arr.length-1;
        Arrays.sort(arr);
        minValue = Math.abs(arr[0]+arr[end]);
        for(int i = 0;i < arr.length; i++){
            while(i < end && arr[i]+arr[end] >= 0 ){
                end--;
            }
            minValue = Math.min(minValue,Math.abs(arr[i]+arr[end]));
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        arr = new int[Integer.parseInt(sc.nextLine())];
        String[] input = sc.nextLine().split(" ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        find();

        System.out.println(minValue);
        
    }
}