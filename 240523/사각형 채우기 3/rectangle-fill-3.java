import java.util.*;

public class Main {
    public static long[] square = new long[1001];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc =new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        square[0] = 1;
        square[1] = 2;
        square[2] = 7;
        square[3] = 22;
        square[4] = 71;
        for(int i = 5; i < 1001; i++){
            square[i] = (square[i-1]*2+square[i-2]*3+square[i-3]*2+square[i-4]*2+square[i-5]*2)%1000000007;
        }

        System.out.println(square[n]);

    }
}