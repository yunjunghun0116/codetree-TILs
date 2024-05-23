import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int[][] maxBoard;
    public static int maxCount = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];
        maxBoard = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        find();

        System.out.println(maxCount);
    }
    public static void find(){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        Stack<int[]> positionStack = new Stack<>();

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(canGo(i, j, 0, 0)){
                    positionStack.push(new int[]{i, j, board[i][j], 1});
                    while(!positionStack.isEmpty()){
                        int[] position = positionStack.pop();
                        maxCount = Math.max(maxCount, position[3]);
                        for(int k = 0; k < 4; k++){
                            int nextI = position[0] + dy[k];
                            int nextJ = position[1] + dx[k];
                            if(canGo(nextI, nextJ, position[2], position[3])){
                                positionStack.push(new int[]{nextI, nextJ, board[nextI][nextJ], position[3]+1});
                            } 
                        }
                    }
                }
            }
        }
    }
    public static boolean canGo(int i, int j, int value, int count){
        if(i < 0 || i >= n || j < 0 || j >= n) return false;
        if(count + 1 <= maxBoard[i][j]) return false;
        if(board[i][j] <= value) return false;
        return true;
    }
}