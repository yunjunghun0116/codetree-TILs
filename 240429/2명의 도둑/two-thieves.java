import java.util.*;

public class Main {
    public static int n;
    public static int m; // 최대 갯수
    public static int c; // 최대 무게
    public static int[][] board;
    public static int maxValue = Integer.MIN_VALUE;
    public static List<Integer> arr = new ArrayList<>();

    public static void find(int currLen,int preValue){
        if(arr.size() == 2){
            find();
            return;
        }
        for(int i = preValue; i < n; i++){
            arr.add(i);
            find(currLen,i);
            arr.remove(arr.size()-1);
        }
    }

    public static void find(){
        int[] position = new int[n];
        for(int i : arr){
            position[i] = position[i]+1;
        }
        int currValue = 0;
        for(int i = 0; i < n; i++){
            if(position[i] == 0) continue;
            if(position[i] == 1){
                currValue += findAloneLine(i);
            }
            if(position[i] > 1){
                currValue += findDoubleLine(i,0);
            }
        }
        maxValue = Math.max(maxValue,currValue);
    }

    public static int findAloneLine(int line){
        // m : 최대 갯수, c : 최대 무게
        int findMaxValue = Integer.MIN_VALUE;
        int end = 0;
        int currCount = 0;
        int currWeight = 0;
        int currValue = 0;
        for(int i = 0;i < n; i++){
            while(end < n && currCount < m && currWeight + board[line][end] <= c){
                currCount++;
                currWeight += board[line][end];
                currValue += board[line][end]*board[line][end];
                end++;
            }

            findMaxValue = Math.max(findMaxValue, currValue);
            currCount --;
            currWeight -= board[line][i];
            currValue -= board[line][i]*board[line][i];
        }
        return findMaxValue;
    }

    public static int findDoubleLine(int line,int currCol){
        int findMaxValue = Integer.MIN_VALUE;
        int end = currCol;
        int currCount = 0;
        int currWeight = 0;
        int currValue = 0;
        for(int i = currCol;i < n; i++){
            while(end < n && currCount < m && currWeight + board[line][end] <= c){
                currCount++;
                currWeight += board[line][end];
                currValue += board[line][end]*board[line][end];
                end++;
            }
            if(currCol == 0){
                int nextValue = findDoubleLine(line,end);
                findMaxValue = Math.max(findMaxValue, currValue+nextValue);
            }
            
            currCount --;
            currWeight -= board[line][i];
            currValue -= board[line][i]*board[line][i];
        }
        return findMaxValue;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        // 2개의 행 ( 만약 겹치면 겹치지 않도록 선택 ) -> 열에서 선택하는 로직 생각해야할듯
        // 최대 무게 C 
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        board = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] arrInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(arrInput[j]);
            }
        }

        find(0,0);

        System.out.println(maxValue);

    }
}