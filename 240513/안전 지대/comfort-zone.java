import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int maxHeight = Integer.MIN_VALUE;
    public static int maxArea = Integer.MIN_VALUE;
    public static int k = 1;
    public static int count;

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] arrInput = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                int height = Integer.parseInt(arrInput[j]);
                board[i][j] = height;
                maxHeight = Math.max(maxHeight,height);
            }
        }

        for(int i = 1; i <= maxHeight; i++){
            visited = new boolean[n][m];
            count = 0;
            find(i);
            if(count > maxArea){
                maxArea = count;
                k = i;
            }
        }

        System.out.println(k+" "+maxArea);

    }
    public static void find(int k){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] > k && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    dfs(i,j,k);
                }
            }
        }
    }
    public static void dfs(int x,int y,int k){
        for(int i = 0; i < 4; i++){
            int nextI = x + dx[i];
            int nextJ = y + dy[i];
            if(canGo(nextI,nextJ,k)){
                visited[nextI][nextJ] = true;
                dfs(nextI,nextJ,k);
            }
        }
    }
    public static boolean canGo(int x,int y,int k){
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        if(visited[x][y]) return false;
        if(board[x][y] <= k) return false;
        return true;
    }
}