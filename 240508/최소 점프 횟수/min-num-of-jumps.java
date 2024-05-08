import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();
    public static int minValue = Integer.MAX_VALUE;

    public static void find(int currPos,int currCount){
        if(currPos >= n-1){
            minValue = Math.min(minValue,currCount);
            return;
        }
        for(int i = arr[currPos]; i >= 1; i--){
            find(currPos+i,currCount+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        arr = new int[n];
        String[] arrInput = sc.nextLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        find(0,0);

        System.out.println(minValue<Integer.MAX_VALUE?minValue:-1);
    }
}