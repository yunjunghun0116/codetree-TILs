import java.util.*;

public class Main {
    public static int coinCount;
    public static int[] coins;
    public static int findCoin;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] countInput = sc.nextLine().split(" ");
        coinCount = Integer.parseInt(countInput[0]);
        findCoin = Integer.parseInt(countInput[1]);
        coins = new int[coinCount];

        String[] coinInput = sc.nextLine().split(" ");
        for(int i = 0; i < coinCount; i++){
            coins[i] = Integer.parseInt(coinInput[i]);
        }

        int result = find();

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static int find(){
        int[] dp = new int[findCoin+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= findCoin; i++){
            for(int j = 0; j < coinCount; j++){
                if(i < coins[j]) continue;
                if(dp[i - coins[j]] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i],dp[i - coins[j]]+1);
                
            }
        }

        return dp[findCoin];
    }
}