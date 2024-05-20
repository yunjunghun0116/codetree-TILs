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
        // 정렬된 값에 대해서 두개의 값을 고르기
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            int[] numberInfo = list.get(i);
            for(int j = i+1; j < list.size(); j++){
                int[] number2Info = list.get(j);
                if(numberInfo[0] > number2Info[1]){
                    maxValue = Math.max(maxValue,numberInfo[2]+number2Info[2]);
                    break;
                }
                if(numberInfo[1] < number2Info[0]){
                    maxValue = Math.max(maxValue,numberInfo[2]+number2Info[2]);
                    break;
                }
            }
        }
        if(maxValue == Integer.MIN_VALUE){
            return list.get(0)[2];
        }
        return maxValue;
    }
}