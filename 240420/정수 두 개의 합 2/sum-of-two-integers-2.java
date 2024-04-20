import java.util.*;

public class Main {
    public static int[] arr;
    public static int k;
    public static int count = 0;
    public static void find(){
        
        int end = 1;
        for(int i = 0; i < arr.length; i++){
            while(end+1 < arr.length && arr[i]+arr[end+1]<=k){
                end++;
            }
            if(i<end && arr[i]+arr[end] <= k){
                count += end - i;
            }
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        arr = new int[Integer.parseInt(input[0])];
        k = Integer.parseInt(input[1]);
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        Arrays.sort(arr);

        find();

        System.out.println(count);
    }
}