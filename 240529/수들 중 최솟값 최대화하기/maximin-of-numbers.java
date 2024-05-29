import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static boolean[] visited;
    public static List<Integer> list = new ArrayList<>();
    public static int maxMinNumber = 0;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n ; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
        find(0);

        System.out.println(maxMinNumber);

    }
    public static void find(int currLen){
        if(currLen == n){
            check();
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            list.add(i);
            find(currLen+1);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
    public static void check(){
        int minNumber = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            minNumber = Math.min(minNumber,board[i][list.get(i)]);
        }

        maxMinNumber = Math.max(maxMinNumber,minNumber);
    }
}