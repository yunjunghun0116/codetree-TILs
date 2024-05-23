import java.util.*;

public class Main {
    public static int[] stairs = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // 여기에 코드를 작성해주세요.
        stairs[0] = 0;
        stairs[1] = 0;
        stairs[2] = 1;
        stairs[3] = 1;
        for(int i = 4; i < 1001; i++){
            stairs[i] = (stairs[i-3]+stairs[i-2])%10007;
        }

        System.out.println(stairs[n]);
    }
}