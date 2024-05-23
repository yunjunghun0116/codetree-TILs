import java.util.*;

public class Main {
    public static int[] square = new int[1001];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        square[0] = 0;
        square[1] = 1;
        square[2] = 3;
        for(int i =3; i < 1001; i++){
            square[i] = (square[i-1]+ square[i-2]*2)%10007;
        }

        int n = Integer.parseInt(sc.nextLine());

        System.out.println(square[n]);
    }
}