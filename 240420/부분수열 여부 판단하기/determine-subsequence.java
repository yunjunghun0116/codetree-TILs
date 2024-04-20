import java.util.*;

public class Main {
    public static int[] aArr;
    public static int[] bArr;

    public static boolean find(int aIdx, int bIdx){
        if(bIdx == bArr.length) return true;
        for(int i = aIdx; i < aArr.length; i++){
            if(aArr[i] == bArr[bIdx]){
                return find(i+1,bIdx+1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        aArr = new int[Integer.parseInt(input[0])];
        bArr = new int[Integer.parseInt(input[1])];


        String[] aInput = sc.nextLine().split(" ");
        for(int i = 0; i < aArr.length; i++){
            aArr[i] = Integer.parseInt(aInput[i]);
        }

        String[] bInput = sc.nextLine().split(" ");
        for(int i = 0; i < bArr.length; i++){
            bArr[i] = Integer.parseInt(bInput[i]);
        }

        System.out.println(find(0,0)?"Yes":"No");
    }
}