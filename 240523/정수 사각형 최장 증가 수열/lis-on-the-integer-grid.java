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

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->board[a[0]][a[1]]-board[b[0]][b[1]]);

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(maxBoard[i][j] != 0) continue;
                pq.add(new int[]{i, j, 1});
                while(!pq.isEmpty()){
                    int[] position = pq.poll();
                    maxBoard[position[0]][position[1]] = position[2];
                    maxCount = Math.max(maxCount,position[2]);
                    for(int k = 0; k < 4; k++){
                        int nextI = position[0]+dy[k];
                        int nextJ = position[1]+dx[k];
                        if(position[2]+1 <= maxBoard[i][j]) continue;
                        if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n) continue;
                        if(board[nextI][nextJ] <= board[position[0]][position[1]]) continue;
                        pq.add(new int[]{nextI,nextJ,position[2]+1});
                    }
                }
                
            }
        }
    }
}