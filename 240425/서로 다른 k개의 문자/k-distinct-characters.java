import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int[] arr = new int[26];
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        String str = input[0];
        int diffCount = Integer.parseInt(input[1]);

        int currentDiff = 0;

        int maxLength = 0;
        int end = 0;

        for(int i = 0; i< str.length(); i++){
            while(end < str.length() && currentDiff <= diffCount){
                if(currentDiff == diffCount && arr[getIndex(str.charAt(end))] == 0) break;
                if(arr[getIndex(str.charAt(end))] == 0){
                    currentDiff++;
                }
                arr[getIndex(str.charAt(end))] = arr[getIndex(str.charAt(end))]+1;
                end++;
            }
            
            maxLength = Math.max(maxLength, end - i);
            arr[getIndex(str.charAt(i))] = arr[getIndex(str.charAt(i))]-1;

            if(arr[getIndex(str.charAt(i))] == 0){
                currentDiff--;
            }
        }

        System.out.println(maxLength);
    }
    public static int getIndex(char a){
        return (int)a - (int)'a';
    }
}