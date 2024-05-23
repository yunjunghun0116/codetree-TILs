import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int[][] sum;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];
        sum = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        find();

        System.out.println(sum[n-1][0]);
    }
    public static void find(){
        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                if(i==0 && j == n-1){
                    sum[i][j] = board[i][j];
                    continue;
                }
                if(i == 0){
                    sum[i][j] = sum[i][j+1]+board[i][j];
                    continue;
                }
                if(j == n-1){
                    sum[i][j] = sum[i-1][j] + board[i][j];
                    continue;
                }
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j+1])+board[i][j];
            }
        }
    }
}