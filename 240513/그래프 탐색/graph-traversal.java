import java.util.*;

public class Main {

    public static int[][] graph;
    public static boolean[] visited;

    public static int canTouchCount = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int size = Integer.parseInt(input[0])+1;
        visited = new boolean[size];
        graph = new int[size][size];

        for(int i = 0; i < Integer.parseInt(input[1]); i++){
            String[] node = sc.nextLine().split(" ");
            int start = Integer.parseInt(node[0]);
            int end = Integer.parseInt(node[1]);

            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        visited[1] = true;
        dfs(1);

        System.out.println(canTouchCount);

    }


    public static void dfs(int node){
        for(int i = 1; i < graph.length; i++){
            if(graph[node][i] == 1 && !visited[i]){
                canTouchCount++;
                visited[i] = true;
                dfs(i);
            }
        }
    }
}