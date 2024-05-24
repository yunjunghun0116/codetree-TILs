import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[] nums;
    public static int[] sum;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] numInput = sc.nextLine().split(" ");
        n = Integer.parseInt(numInput[0]);
        m = Integer.parseInt(numInput[1]);
        nums = new int[n];
        sum = new int[m+1];
        String[] numsInput = sc.nextLine().split(" ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(numsInput[i]);
        }
        Arrays.fill(sum,Integer.MAX_VALUE);
        sum[0] = 0;

        find();

        System.out.println(sum[m] == Integer.MAX_VALUE?-1:sum[m]);
    }
    public static void find(){
        for(int i = 0 ; i < n; i++){
            for(int j = m ; j >0 ; j--){
                if(j < nums[i]) continue;
                if(sum[j-nums[i]] == Integer.MAX_VALUE) continue;
                sum[j] = Math.min(sum[j], sum[j-nums[i]]+1);
            }
        
        }
        
    }
}