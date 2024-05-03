import java.util.*;

public class Main {
    public static int m; // 거리 -> m 이상은 오케이
    public static int k; // 말의 수
    public static int[] arr; // 입력값들

    public static int[] status;

    public static int maxValue = Integer.MIN_VALUE;

    public static void find(int currLen){
        if(currLen == arr.length){
            int currValue = 0;
            for(int i = 0; i < k; i++){
                if(status[i]>=m){
                    currValue++;
                }
            }
            maxValue = Math.max(maxValue,currValue);
            return;
        }
        for(int i = 0; i < k; i++){
            status[i] = status[i] + arr[currLen];
            find(currLen+1);
            status[i] = status[i] - arr[currLen];
        }

    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        // n = 3 => 001122 012210
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        m = Integer.parseInt(input[1])-1;
        arr = new int[Integer.parseInt(input[0])];
        k = Integer.parseInt(input[2]);

        status = new int[k];

        String[] numbers = sc.nextLine().split(" ");
        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }
        
        find(0);

        System.out.println(maxValue);
    }
}