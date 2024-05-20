import java.util.*;

public class Main {
    public static int k;
    public static int[] arr;
    public static int[] maxL;
    public static int[] maxR;
    public static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setData();
        find();
        // int result = getResult();
        // System.out.println(result);
        getResultL();
        getResultR();

        int max = maxL[arr.length-1];
        for(int i = 0; i < arr.length-1; i++){
            max = Math.max(max,maxL[i]+maxR[i+1]);
        }

        // print();        
        System.out.println(max);
    }
    public static void print(){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.print(maxL[i]+" ");
        }
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.print(maxR[i]+" ");
        }
        System.out.println();
    }
    public static void setData(){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        arr = new int[n];
        maxL = new int[n];
        maxR = new int[n];

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

    public static void getResultL(){
        int start = 0;
        int maxCount = 0;
        for(int end = 0; end < arr.length; end++){
            while(start < arr.length && arr[end] - arr[start] > k){
                start++;
            }
            maxCount = Math.max(maxCount, end-start+1);
            maxL[end] = maxCount;
        }
    }
    public static void getResultR(){
        int right = arr.length-1;
        int maxCount = 0;
        for(int left = arr.length-1; left >= 0; left--){
            while(right >= 0 && arr[right]-arr[left]>k){
                right--;
            }
            maxCount = Math.max(maxCount,right-left+1);
            maxR[left] = maxCount;
        }
    }
}