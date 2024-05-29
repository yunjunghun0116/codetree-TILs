import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int n;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = Integer. parseInt(sc.nextLine());

        visited = new boolean[n+1];

        find(0);
    }
    public static void find(int currLen){
        if(currLen == n){
            print();
            return;
        }
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            list.add(i);
            find(currLen+1);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
    public static void print(){
        for(int i = 0; i < n; i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}