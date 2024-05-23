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

        for(int i = 3; i < 1001; i++){
            square[i] = (square[i-1]*2+square[i-2]*3)%1000000007;
            for(int j = i-3; j >=0; j--){
                square[i] = (square[i]+square[j]*2)%1000000007;
            }
        }

        System.out.println(square[n]);

    }
}