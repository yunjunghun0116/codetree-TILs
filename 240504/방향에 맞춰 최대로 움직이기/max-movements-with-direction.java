import java.util.*;

public class Main {
    public static int[] dx = {0,1,1,1,0,-1,-1,-1};
    public static int[] dy = {-1,-1,0,1,1,1,0,-1};

    public static int[][] board;
    public static int[][] nextPos;
    public static boolean[][] visited;

    public static int maxMove = Integer.MIN_VALUE;

    // y : 열, x : 행
    public static void find(int currentMove,int currX,int currY){
        maxMove = Math.max(maxMove,currentMove);

        for(int i = 1; i < board.length; i++){
            int nextMove = nextPos[currY][currX];
            int nextY = currY + dy[nextMove]*i;
            int nextX = currX + dx[nextMove]*i;

            if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length || visited[nextY][nextX]) continue;
            if(board[nextY][nextX] < board[currY][currX])continue;
            visited[nextY][nextX] = true;
            find(currentMove+1, nextX,nextY);
            visited[nextY][nextX] = false;
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        board = new int[size][size];
        nextPos = new int[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < size; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        for(int i = 0; i < size; i++){
            String[] nextPosInput = sc.nextLine().split(" ");
            for(int j = 0; j < size; j++){
                nextPos[i][j] = Integer.parseInt(nextPosInput[j])-1;
            }
        }

        String[] startPosition = sc.nextLine().split(" ");
        int startY = Integer.parseInt(startPosition[0])-1;
        int startX = Integer.parseInt(startPosition[1])-1;
        
        visited[startY][startX] = true;
        find(0,startX,startY);


        System.out.println(maxMove);
    }


}