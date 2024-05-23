import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int[][] minBoard;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];
        minBoard = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        find();

        System.out.println(minBoard[n-1][n-1]);
    }
    public static void find(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    minBoard[i][j] = board[i][j];
                    continue;
                }
                if(i == 0){
                    minBoard[i][j] = Math.min(minBoard[i][j-1],board[i][j]);
                    continue;
                }
                if(j == 0){
                    minBoard[i][j] = Math.min(minBoard[i-1][j],board[i][j]);
                    continue;
                }
                minBoard[i][j] = Math.min(Math.max(minBoard[i][j-1],minBoard[i-1][j]),board[i][j]);
            }
        }
    }
}