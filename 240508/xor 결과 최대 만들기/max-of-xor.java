import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();

    public static int maxValue = Integer.MIN_VALUE;

    public static void find(int currIndex){
        if(list.size() == m){
            int value = 0;
            for(int i = 0; i < m; i++){
                value = value ^ arr[list.get(i)];
            }
            maxValue = Math.max(maxValue,value);
            return;
        }
        for(int i = currIndex; i <n; i++){
            list.add(i);
            find(currIndex+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] arrInput = sc.nextLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        find(0);

        System.out.println(maxValue);
    }
}