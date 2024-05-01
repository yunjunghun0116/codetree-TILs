import java.util.*;

public class Main {
    public static int n;
    public static int m; // 최대 갯수
    public static int c; // 최대 무게
    public static int[][] board;
    public static boolean[][] visited;
    public static int maxValue = Integer.MIN_VALUE;
    public static List<Integer> arr = new ArrayList<>();

    public static void find(int currLen,int preValue){
        if(arr.size() == 2){
            findA(arr.get(0),0,Integer.MAX_VALUE,0,0);
            return;
        }
        for(int i = preValue; i < n; i++){
            arr.add(i);
            find(currLen,i);
            arr.remove(arr.size()-1);
        }
    }

    public static void findA(int line,int currIndex,int minIndex,int currWeight, int currValue){
        if(currIndex == n){
            findB(arr.get(1),0,Integer.MAX_VALUE,0,0,currValue);
            return;
        }
        if(currWeight + board[line][currIndex] > c || currIndex - minIndex >= m || visited[line][currIndex]){
            findA(line,currIndex+1,Math.min(minIndex,currIndex),currWeight,currValue);
            return;
        }
        
        visited[line][currIndex] = true;
        findA(line,currIndex+1,Math.min(minIndex,currIndex),currWeight+board[line][currIndex],currValue+board[line][currIndex]*board[line][currIndex]);
        visited[line][currIndex] = false;
        

        findA(line,currIndex+1,Math.min(minIndex,currIndex),currWeight,currValue);
    }

    public static void findB(int line, int currIndex,int minIndex,int currWeight, int currValue, int aValue){
        if(currIndex == n){
        
            maxValue = Math.max(maxValue,currValue+aValue);
            return;
        }
        if(currWeight + board[line][currIndex] > c || currIndex - minIndex >= m  || visited[line][currIndex]){
            findB(line,currIndex+1,Math.min(minIndex,currIndex),currWeight,currValue,aValue);
            return;
        }
    
        visited[line][currIndex] = true;
        findB(line,currIndex+1,Math.min(minIndex,currIndex),currWeight+board[line][currIndex],currValue+board[line][currIndex]*board[line][currIndex],aValue);
        visited[line][currIndex] = false;


        findB(line,currIndex+1,Math.min(minIndex,currIndex),currWeight,currValue,aValue);
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
        visited = new boolean[n][n];

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