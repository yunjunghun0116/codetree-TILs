import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static boolean[] visited;
    public static List<Integer> list = new ArrayList<>();
    public static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        find(0);

        System.out.println(minValue);
    }
    public static void find(int currLen){
        if(currLen == n-1){
            check();
            return;
        }
        for(int i = 1; i < n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            list.add(i);

            find(currLen+1);

            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
    public static void check(){
        int sum = 0;
        for(int i = 0; i < n-2; i++){
            if(board[list.get(i)][list.get(i+1)] == 0) return;
            sum += board[list.get(i)][list.get(i+1)];
        }
        if(board[0][list.get(0)] == 0 || board[list.get(n-2)][0] == 0){
            return;
        }
        sum+= board[0][list.get(0)];
        sum+= board[list.get(n-2)][0];

        minValue = Math.min(minValue,sum);
    }
}