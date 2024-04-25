import java.util.*;

public class Main {
    public static int[] arr;;
    public static int maxCount;
    public static int maxLength = Integer.MIN_VALUE;
    public static Map<Integer,Integer> countMap = new HashMap<>();

    public static void find(){
        int end = 0;

        for(int i = 0; i< arr.length; i++){
            while(end < arr.length && canAdd(arr[end])){
                addValue(arr[end]);
                end++;
            }
            maxLength = Math.max(maxLength, end - i);
            removeValue(arr[i]);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        arr = new int[Integer.parseInt(input[0])];
        maxCount = Integer.parseInt(input[1]);
        
        String[] arrInput = sc.nextLine().split(" ");
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        find();

        System.out.println(maxLength);
    }

    public static boolean canAdd(int value){
        if(!countMap.containsKey(value)) return true;
        int count = countMap.get(value);
        if(count == maxCount)return false;
        return true;
    }

    public static void addValue(int value){
        if(countMap.containsKey(value)){
            int count = countMap.get(value);
            countMap.put(value,count+1);
            return;
        }
        countMap.put(value,1);
    }

    public static void removeValue(int value){
        if(countMap.containsKey(value)){
            int count = countMap.get(value);
            countMap.put(value,count-1);
            return;
        }
    }

}