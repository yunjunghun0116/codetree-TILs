import java.util.*;

public class Main {
    public static int[] square = new int[1001];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        square[0] = 0;
        square[1] = 1;
        square[2] = 2;
        square[3] = 3;
        for(int i = 4; i < 1001; i++){
            square[i] = (square[i-1]+square[i-2])%10007;
        }

        System.out.println(square[n]);

    }
}