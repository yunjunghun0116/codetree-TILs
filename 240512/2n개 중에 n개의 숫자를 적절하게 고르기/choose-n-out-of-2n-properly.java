import java.util.*;

public class Main {
    public static int maxSum;
    public static int minDifference = Integer.MAX_VALUE;
    public static int n;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        arr = new int[2*n];

        String[] arrInput = sc.nextLine().split(" ");
        int sum = 0;
        for(int i = 0; i < 2*n; i++){
            int value = Integer.parseInt(arrInput[i]);
            arr[i] = value;
            sum += value;
        }

        maxSum = sum;
        find(0);

        System.out.println(minDifference);
    }

    public static void find(int currIndex){
        if(currIndex >= 2*n) return;
        if(list.size() == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += arr[list.get(i)];
            }
            minDifference = Math.min(minDifference,Math.abs(2*sum-maxSum));
            return;
        }
        for(int i = currIndex; i < 2*n; i++){
            list.add(i);
            find(i+1);
            list.remove(list.size()-1);
        }
    }
}