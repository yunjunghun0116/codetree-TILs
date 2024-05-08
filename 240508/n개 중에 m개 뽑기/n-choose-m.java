import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        find(0);
    }

    public static void find(int currValue){
        if(list.size() == m){
            print();
            return;
        }
        for(int i = currValue+1; i <= n; i++){
            list.add(i);
            find(i);
            list.remove(list.size()-1);
        }
    }

    public static void print(){
        for(int i = 0; i < m ;i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}