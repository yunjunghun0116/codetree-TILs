import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[] dp;
    public static int[] num;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        dp = new int[m+1];
        num = new int[n];

        String[] numInput = sc.nextLine().split(" ");
        for(int i = 0; i < n ;i++){
            num[i] = Integer.parseInt(numInput[i]);
        }

        find();

        System.out.println(dp[m]==Integer.MIN_VALUE?-1:dp[m]);
    }
    public static void find(){

        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                if(i < num[j]) continue;
                if(dp[i-num[j]] == Integer.MIN_VALUE) continue;
                dp[i] = Math.max(dp[i],dp[i-num[j]]+1);
            }
        }
    }
}