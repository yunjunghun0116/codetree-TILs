import java.util.*;

public class Main {
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};
    public static List<Integer> village = new ArrayList<>();
    public static int count = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        board = new int[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i < size; i++){
            String[] arrInput = sc.nextLine().split(" ");
            for(int j = 0; j < size; j++){
                board[i][j] = Integer.parseInt(arrInput[j]);
            }
        }

        find();

        System.out.println(village.size());
        Collections.sort(village);
        
        for(int i: village){
            System.out.println(i);
        }
    }

    public static void find(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                    village.add(count);
                    count = 0;
                }
            }
        }
    }
    public static void dfs(int x,int y){

        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int nextI = x + dx[i];
            int nextJ = y + dy[i];
            if(canGo(nextI,nextJ)){
                dfs(nextI,nextJ);
            }
        }
        
    }
    public static boolean canGo(int x,int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board.length) return false;
        if(visited[x][y]) return false;
        if(board[x][y] == 0) return false;
        return true;
    }
}