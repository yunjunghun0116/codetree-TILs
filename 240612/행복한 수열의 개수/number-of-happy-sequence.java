import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static int count = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        find();
        System.out.println(count);
    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        n = Integer.parseInt(sizeInput[0]);
        m = Integer.parseInt(sizeInput[1]);

        board = new int[n][n];

        for(int i = 0; i < n ; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0 ; j < n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }
    public static void find(){
        for(int i = 0; i < n; i ++){
            if(isHappyRow(i)){
                count++;
            }
            if(isHappyCol(i)){
                count++;
            }
        }
    }
    public static boolean isHappyRow(int row){
        int currNum = 0;
        int currCount = 0;
        for(int i = 0 ; i < n ; i++){
            if(currCount >= m) return true;
            if(board[row][i] == currNum){
                currCount++;
                continue;
            }
            currNum = board[row][i];
            currCount = 1;
        }
        return currCount >= m;
    }
    public static boolean isHappyCol(int col){
        int currNum = 0;
        int currCount = 0;
        for(int i = 0 ; i < n ; i++){
            if(currCount >= m) return true;
            if(board[i][col] == currNum){
                currCount++;
                continue;
            }
            currNum = board[i][col];
            currCount = 1;
        }
        return false;
    }

}