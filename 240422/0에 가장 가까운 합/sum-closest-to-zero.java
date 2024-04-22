import java.util.*;

public class Main {
    public static int[] arr;
    public static int minValue = Integer.MAX_VALUE;
    public static void find(){
        int end = 1;
        Arrays.sort(arr);

        for(int i = 0;i < arr.length; i++){
            if(end <= i) break;
            while(i < end && end < arr.length && arr[i] + arr[end] < 0){
                if(end == arr.length -1){
                    break;
                }
                minValue = Math.min(minValue,Math.abs(arr[i]+arr[end++]));
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