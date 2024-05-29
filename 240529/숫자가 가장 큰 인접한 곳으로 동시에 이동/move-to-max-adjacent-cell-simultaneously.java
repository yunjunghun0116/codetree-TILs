import java.util.*;

public class Main {
    public static int[][] board;
    public static int[][] balls;
    public static int n;
    public static int t;
    public static void main(String[] args) {
        setInput();

        for(int i = 0; i < t; i++){
            nextTime();
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                if( balls[i][j] == 1){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void setInput(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        n = Integer.parseInt(sizeInput[0]);
        int m = Integer.parseInt(sizeInput[1]);
        t = Integer.parseInt(sizeInput[2]);
        board = new int[n][n];
        balls = new int[n][n];

        for(int i = 0; i < n ; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        for(int i = 0; i < m; i++){
            String[] ballInput = sc.nextLine().split(" ");
            int y = Integer.parseInt(ballInput[0])-1;
            int x = Integer.parseInt(ballInput[1])-1;

            balls[y][x] = 1;
        }
    }

    public static void nextTime(){
        int[][] tempBalls = new int[n][n];

        removeDuplicated();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(balls[i][j] == 1){
                    balls[i][j] = 0;
                    int[] nextPos = findNextPosition(i,j); 
                    tempBalls[nextPos[0]][nextPos[1]] = tempBalls[nextPos[0]][nextPos[1]]+1;
                }
            }
        }
        
        balls = tempBalls;
    }

    public static int[] findNextPosition(int i, int j){
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};

        int maxValue = 0;
        int[] result = new int[]{};
        for(int k = 0; k < 4; k++){
            int nextI = i + dy[k];
            int nextJ = j + dx[k];
            if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n) continue;
            if(board[nextI][nextJ] > maxValue){
                result = new int[]{nextI,nextJ};
                maxValue = board[nextI][nextJ];
            }
        }

        return result;
    }

    public static void removeDuplicated(){
        for(int i = 0; i < n ;i++){
            for(int j = 0; j < n ; j++){
                if(balls[i][j] > 1){
                    balls[i][j] = 0;
                }
            }
        }
    }
}