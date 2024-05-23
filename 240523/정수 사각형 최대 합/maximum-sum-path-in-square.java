import java.util.*;

public class Main {
    public static int[][] board;
    public static int[][] sum;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setup();
        find();
        System.out.println(sum[board.length-1][board.length-1]);
    }
    public static void setup(){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];
        sum = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }
    public static void find(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(i==0 && j==0){
                    sum[i][j] = board[i][j];
                    continue;
                }
                if(i==0){
                    sum[i][j] = sum[i][j-1]+board[i][j];
                    continue;
                }
                if(j==0){
                    sum[i][j] = sum[i-1][j]+board[i][j];
                    continue;
                }
                sum[i][j] = Math.max(sum[i-1][j],sum[i][j-1])+board[i][j];
            }
        }
    }
}