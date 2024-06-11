import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int maxCount = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        find();
        System.out.println(maxCount);
    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];

        for(int i = 0; i < n ; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }
    public static void find(){
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < n-2; j++){
                int count = 0;
                for(int m = 0; m < 3; m++){
                    for(int k = 0; k < 3; k++){
                        if(board[i+m][j+k] == 1){
                            count++;
                        }
                    }
                }
                maxCount = Math.max(maxCount,count);
                
            }
        }
    }
}