import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        boolean[] charArr = new boolean[255];
        int currLen = 0;
        int end = 0;

        for(int i = 0; i < str.length(); i++){
            while(end < str.length() && !charArr[(int)str.charAt(end)]){
                charArr[(int)str.charAt(end)] = true;
                end++;
            }
            currLen = Math.max(currLen, end - i);

            charArr[(int)str.charAt(i)] = false;
        }

        System.out.println(currLen);
    }
}