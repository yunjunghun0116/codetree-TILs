import java.util.*;

public class Main {
    public static int[] tree = new int[20];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());


        tree[0] = 1;
        tree[1] = 1;
        tree[2] = 2;
        for(int i = 3; i < 20; i++){
            // i번째 트리는
            for(int j = i-1; j >= 0 ;j--){
                // 왼쪽은 i-1부터 0개까지 다 가질 수 있고
                tree[i] = tree[i] + tree[j]*tree[i-1-j];
            }
        }

        System.out.println(tree[n]);

    }
}