import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] dp;
    public static List<int[]> jewelries = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        n = Integer.parseInt(sizeInput[0]);
        m = Integer.parseInt(sizeInput[1]);

        dp = new int[n+1][m+1];
        jewelries.add(new int[]{});
        for(int i = 0; i < n; i++){
            String[] jewelry = sc.nextLine().split(" ");
            jewelries.add(new int[]{Integer.parseInt(jewelry[0]),Integer.parseInt(jewelry[1])});
        }

        find();

        System.out.println(dp[n][m]);
    }
    public static void find(){
        for(int i = 1; i <= n; i++){
            int[] jewelry = jewelries.get(i);
            for(int j = 1; j <= m; j++){
                if(j < jewelry[0]){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j-jewelry[0]]+jewelry[1],dp[i-1][j]);
            }
        }
    }
}