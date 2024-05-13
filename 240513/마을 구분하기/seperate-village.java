import java.util.*;

public class Main {
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};
    public static List<Integer> village = new ArrayList<>();

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
        for(int i = 0; i < village.size(); i++){
            System.out.println(village.get(i));
        }
    }

    public static void find(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    int size = dfs(i,j);
                    village.add(size);
                }
            }
        }
    }
    public static int dfs(int x,int y){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});
        visited[x][y] = true;
        int size = 0;

        while(!stack.isEmpty()){
            int[] point = stack.pop();
            size++;
            for(int i = 0; i < 4; i++){
                int nextI = point[0] + dx[i];
                int nextJ = point[1] + dy[i];
                if(canGo(nextI,nextJ)){
                    visited[nextI][nextJ] = true;
                    stack.push(new int[]{nextI,nextJ});
                }
            }
        }

        return size;
    }
    public static boolean canGo(int x,int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board.length) return false;
        if(visited[x][y]) return false;
        if(board[x][y] == 0) return false;
        return true;
    }
}