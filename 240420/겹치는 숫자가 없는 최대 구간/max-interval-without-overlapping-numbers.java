import java.util.*;

public class Main {
    public static int maxLength = Integer.MIN_VALUE;
    public static int[] indexArr = new int[100001];
    public static int length;
    public static int[] arr;
    public static void find(){
        int end = 0;
        
        for(int i = 0; i < length; i++){
            while(end < length && indexArr[arr[end]] == -1){
                indexArr[arr[end]] = end;
                end++;
            }
            //indexArr 이  이미 저장되어있거나, end 가 마지막일때
            maxLength = Math.max(end-i,maxLength);

            if(end < length && indexArr[arr[end]]!=-1){
                i = indexArr[arr[end]];
                indexArr[arr[end]] = end++;
            }
            indexArr[arr[i]] = -1;
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        length = Integer.parseInt(sc.nextLine());
        arr = new int[length];
    
        Arrays.fill(indexArr,-1);

        String[] input = sc.nextLine().split(" ");

        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        find();

        System.out.println(maxLength);
    }
}