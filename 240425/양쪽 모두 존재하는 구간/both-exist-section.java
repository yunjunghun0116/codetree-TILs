import java.util.*;

public class Main {
    public static int[] arr;
    public static int number;
    public static int[] currArr;
    public static int minLength = Integer.MAX_VALUE;

    public static void find(){
        int end = 0;
        int currentSize = 0;
        for(int i = 0; i < arr.length; i++){
            while(end < arr.length && currentSize < number){
                if(currArr[arr[end]] == 0){
                    currentSize++;
                }
                currArr[arr[end]] = currArr[arr[end]]+1;
                end++;
            }
            if(currentSize == number&&check(i, end)){
                 minLength = Math.min(minLength, end-i);
            }
            currArr[arr[i]] = currArr[arr[i]] -1;
            if(currArr[arr[i]] == 0){
                currentSize --;
            }
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] arrInput = sc.nextLine().split(" ");

        arr = new int[Integer.parseInt(input[0])];
        number = Integer.parseInt(input[1]);
        currArr = new int[number+1];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        find();

        System.out.println(minLength<Integer.MAX_VALUE?minLength:-1);
    }

    public static boolean check(int start, int end){
        int[] currCheckArr = new int[currArr.length];
        int currentSize = 0;
        for(int i = 0; i<arr.length; i++){
            if(currentSize >= number) return true;
            if( i>=start && i < end) continue;
            if(currCheckArr[arr[i]] == 0){
                currentSize++;
            }
            currCheckArr[arr[i]] = currCheckArr[arr[i]]+1;
        }
        return currentSize >= number;
    }
}