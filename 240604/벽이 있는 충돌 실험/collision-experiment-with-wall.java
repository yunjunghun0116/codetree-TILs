import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static Map<Character,int[]> dMap = new HashMap<>();
    public static Map<Character,Character> swapMap = new HashMap<>();

    public static char[][] board;
    public static int[][] countBoard;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        dMap.put('L',new int[]{0,-1});
        dMap.put('R',new int[]{0,1});
        dMap.put('U',new int[]{-1,0});
        dMap.put('D',new int[]{1,0});

        swapMap.put('L','R');
        swapMap.put('R','L');
        swapMap.put('U','D');
        swapMap.put('D','U');

        int count = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < count; i++){
            String[] sizeInput =  sc.nextLine().split(" ");
            int n = Integer.parseInt(sizeInput[0]);
            int m = Integer.parseInt(sizeInput[1]);
            test(n,m);
        }
    }
    public static void test(int n, int m){
        board = new char[n][n];
        countBoard = new int[n][n];

        for(int i = 0; i < m; i++){
            String[] boardInput = sc.nextLine().split(" ");
            int y = Integer.parseInt(boardInput[0])-1;
            int x = Integer.parseInt(boardInput[1])-1;
            char c = boardInput[2].charAt(0);

            board[y][x] = c;
            countBoard[y][x] = countBoard[y][x]+1;
        }

        for(int i = 0; i < 2*n; i++){
            nextRound();
        }
        int result = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(countBoard[i][j] == 1){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
    public static void nextRound(){
        int n = board.length;
        char[][] newBoard = new char[n][n];
        int[][] newCountBoard = new int[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(countBoard[i][j] == 1){
                    int[] nextD = dMap.get(board[i][j]);
                    int nextI = i + nextD[0];
                    int nextJ = j + nextD[1];
                    if(canGo(nextI,nextJ,n)){
                        newCountBoard[nextI][nextJ] = newCountBoard[nextI][nextJ]+1;
                        newBoard[nextI][nextJ] = board[i][j];
                        continue;
                    }
                    newCountBoard[i][j] = newCountBoard[i][j]+1;
                    newBoard[i][j] = swapMap.get(board[i][j]);
                }
            }
        }
        board = newBoard;
        countBoard = newCountBoard;
    }
    public static boolean canGo(int i, int j, int n){
        if(i < 0 || i >= n || j < 0 || j >= n) return false;
        return true;
    }
}