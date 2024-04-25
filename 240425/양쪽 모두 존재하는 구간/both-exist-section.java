import java.util.*;

public class Main {
    public static int[] arr; // 입력 배열
    public static int number; // 입력 최대갓값
    public static int[] countArr; // 최종 갯수
    
    public static int minLength = Integer.MAX_VALUE; // 결과

    public static void find(){
        int end = 0;
        int currentSize = 0;
        boolean canUse = false;
        int[] currCount = new int[number+1];
        for(int i = 0; i < arr.length; i++){
            while(end < arr.length && currentSize < number && countArr[arr[end]]-1> currCount[arr[end]]){
                if(currCount[arr[end]] == 0){
                    currentSize++;
                }
                currCount[arr[end]] = currCount[arr[end]]+1;
                end++;
            }
            if(currentSize == number){
                 minLength = Math.min(minLength, end-i);
            }
            currCount[arr[i]] = currCount[arr[i]] -1;
            if(currCount[arr[i]] == 0){
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
        countArr = new int[number+1];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(arrInput[i]);
            countArr[arr[i]] = countArr[arr[i]]+1;
        }

        find();

        System.out.println(minLength<Integer.MAX_VALUE?minLength:-1);
    }
}