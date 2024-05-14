import java.util.*;

public class Main {
    public static int[][] board;
    public static boolean[][] visited;

    public static int bombCount = 0;
    public static int maxBlock = 0;
    public static int currentCount = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n ; i++){
            String[] input = sc.nextLine().split(" ");
            for(int j = 0; j < n ; j++){
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        find();

        System.out.println(bombCount+" "+maxBlock);
    }
    public static void find(){
        int size = board.length;
        for(int i =0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(visited[i][j]) continue;
                currentCount = 0;
                dfs(i,j,board[i][j]);
                if(currentCount >= 4){
                    bombCount++;
                }
                maxBlock = Math.max(maxBlock,currentCount);
            }
        }
    }
    public static void dfs(int x, int y, int value){
        visited[x][y] = true;
        currentCount++;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        for(int i = 0; i < 4; i++){
            int nextI = x + dx[i];
            int nextJ = y + dy[i];
            if(canGo(nextI,nextJ,value)){
                dfs(nextI,nextJ,value);
            }
        }
    }
    public static boolean canGo(int x, int y, int value){
        if(x < 0 || x >= board.length || y < 0 || y >= board.length) return false;
        if(visited[x][y]) return false;
        if(board[x][y] != value) return false;
        return true;
    }
}