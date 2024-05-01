import java.util.*;

public class Main {
    public static int k;
    public static int n;
    public static List<Integer> arr = new ArrayList<>();

    public static void find(int currLen){
        if(currLen==n){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= k; i++){
            if(arr.size()>= 2 && arr.get(arr.size()-1)==arr.get(arr.size()-2) && arr.get(arr.size()-1) == i) continue;
            arr.add(i);
            find(currLen+1);
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        k = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        find(0);

    }
}