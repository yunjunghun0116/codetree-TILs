import java.util.*;

public class Main {
    public static int[] fib = new int[45];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < 45; i++){
            fib[i] = fib[i-1]+fib[i-2];
        }

        System.out.pritnln(fib[n-1]);
    }
}