import java.util.*;

public class Main {
    public static int[] dp;
    public static int n;
    public static int[] num = {1,2,5};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        dp = new int[n+1];

        find();

        System.out.println(dp[n]);
    }
    public static void find(){
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 3; j++){
                if(i < num[j]) continue;
                dp[i] = (dp[i] + dp[i-num[j]])%10007;
            }
        }
    }
}