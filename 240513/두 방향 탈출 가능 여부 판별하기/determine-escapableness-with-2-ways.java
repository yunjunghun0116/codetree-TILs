import java.util.*;

public class Main {
    public static int[] dx = {1,0};
    public static int[] dy = {0,1};
    public static int[][] board;
    public static boolean[][] visited;
    public static boolean canMove = false;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
        dfs(0,0);
        System.out.println(canMove?1:0);
    }
    public static void dfs(int x, int y){
        if(x == board.length-1 && y == board[0].length - 1){
            canMove = true;
            return;
        }
        for(int i = 0; i < 2; i++){
            int nextI = x + dx[i];
            int nextJ = y + dy[i];
            if(nextI >= board.length || nextJ >= board[0].length || visited[nextI][nextJ]) continue;
            if(board[nextI][nextJ] == 0) return;
            visited[nextI][nextJ] = true;
            dfs(nextI,nextJ);
        }
    }
}