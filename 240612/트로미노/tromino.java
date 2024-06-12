import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static int[][] dyList;
    public static int[][] dxList;
    public static int maxValue = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        find();
        System.out.println(maxValue);
    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        n = Integer.parseInt(sizeInput[0]);
        m = Integer.parseInt(sizeInput[1]);
        
        board = new int[n][m];

        for(int i = 0; i < n; i ++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        dyList = new int[][]{{0,1,1},{0,0,-1},{0,-1,-1},{0,0,1},{0,0,0},{0,1,2}};
        dxList = new int[][]{{0,0,1},{0,1,1},{0,0,-1},{0,-1,-1},{0,1,2},{0,0,0}};
    }
    public static void find(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 6; k++){
                    int value = 0;
                    int[] dy = dyList[k];
                    int[] dx = dxList[k];
                    boolean canUse = true;
                    for(int c = 0; c < 3; c++){
                        int row = i + dy[c];
                        int col = j + dx[c];
                        if(row < 0 || row >= n || col < 0 || col >= m){
                            canUse = false;
                            break;
                        }
                        value += board[row][col];
                    }
                    if(canUse){
                        maxValue = Math.max(maxValue,value);
                    }
                }
            }
        }
    }
}