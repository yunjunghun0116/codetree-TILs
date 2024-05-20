import java.util.*;

public class Main {
    public static int k;
    public static int[] arr;
    public static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setData();
        find();
        int result = getResult();
        System.out.println(result);
    }
    public static void setData(){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        Arrays.sort(arr);
    }
    public static void find(){
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            while(end < arr.length && arr[end]-arr[i]<= k){
                end++;
            }
            list.add(new int[]{arr[i],arr[end-1],end-i});
            while(i < arr.length-1 && arr[i+1]==arr[i]){
                i++;
            }
        }
    }
    public static int getResult(){
        Collections.sort(list,(a,b)->b[2]-a[2]);
        int[] maxResult = list.get(0);
        int[] secondResult = new int[0];
        for(int i = 1; i < list.size(); i++){
            int[] data = list.get(i);
            if(maxResult[1]<data[0]){
                secondResult = data;
                break;
            }
            if(maxResult[0]>data[1]){
                secondResult = data;
                break;
            }
        }
        if(secondResult.length==0){
            return maxResult[2];
        }
        return maxResult[2]+secondResult[2];
    }
}