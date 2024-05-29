import java.util.*;

public class Main {
    public static Map<Integer,int[]> posMap = new HashMap<>();
    public static int n;
    public static int t;
    public static int[][] board;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        input();
        for(int i = 0; i < t; i++){
            nextTurn();
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void nextTurn(){
        for(int i = 1; i <= n*n; i++){
            swapPosition(i);
        }
    }
    public static void swapPosition(int number){
        int[] pos = posMap.get(number);
        int i = pos[0];
        int j = pos[1];

        int[] dy = {1,1,0,-1,-1,-1,0,1};
        int[] dx = {0,-1,-1,-1,0,1,1,1};
        int maxValue = 0;

        for(int k = 0; k < 8; k++){
            int nextI = i + dy[k];
            int nextJ = j + dx[k];
            if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n) continue;
            if(board[nextI][nextJ] > maxValue){
                maxValue = board[nextI][nextJ];
            }
        }

        int[] maxPos = posMap.get(maxValue);
        
        int temp = board[i][j];
        board[i][j] = maxValue;
        board[maxPos[0]][maxPos[1]] = temp;

        posMap.put(temp,maxPos);
        posMap.put(maxValue,new int[]{i,j});
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        n = Integer.parseInt(sizeInput[0]);
        t = Integer.parseInt(sizeInput[1]);

        board = new int[n][n];

        for(int i = 0; i < n ; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n ; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
                posMap.put(board[i][j], new int[]{i,j});
            }
        }
    }
}