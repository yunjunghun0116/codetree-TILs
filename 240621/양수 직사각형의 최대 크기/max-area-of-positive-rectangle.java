import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static int maxSize = -1;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                find(i,j);
            }
        }
        System.out.println(maxSize);
    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        n = Integer.parseInt(sizeInput[0]);
        m = Integer.parseInt(sizeInput[1]);
        
        board = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }
    public static void find(int y, int x){
        for(int i = 0; i < n-y; i++){
            for(int j = 0; j < m-x; j++){
                check(y,y+i,x,x+j);
            }
        }
    }
    public static void check(int y, int yMax, int x, int xMax){
        int count = 0;
        for(int i = y; i <= yMax; i++){
            for(int j = x; j <= xMax; j++){
                count++;
                if(board[i][j] > 0) continue;
                return;
            }
        }

        maxSize = Math.max(maxSize,count);
    }
}