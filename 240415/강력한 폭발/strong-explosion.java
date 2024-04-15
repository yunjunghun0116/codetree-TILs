import java.util.*;

public class Main {
    public static int[][] board;
    public static List<int[]> bombList = new ArrayList<>();
    public static List<Integer> arr = new ArrayList<>();
    public static int[][][] bombBoard = new int[3][5][2];
    public static int maxValue = Integer.MIN_VALUE;
    public static void find(int currLength){
        if(currLength == bombList.size()){
            check();
            return;
        }
        for(int i = 0; i <3; i++){
            arr.add(i);
            find(currLength+1);
            arr.remove(arr.size()-1);
        }
    }
    public static void check(){
        Set<List<Integer>> positionSet = new HashSet<>();
        for(int i = 0; i < bombList.size(); i++){
            int[] bombPosition = bombList.get(i); 
            int currentY = bombPosition[0];
            int currentX = bombPosition[1];
            int[][] bombArea = bombBoard[arr.get(i)];
            for(int j = 0; j < 5; j++){
                int nextY = currentY + bombArea[j][0];
                int nextX = currentX + bombArea[j][1];
                if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length) continue;
                List<Integer> positionArr = new ArrayList<>();
                positionArr.add(nextY);
                positionArr.add(nextX);
                positionSet.add(positionArr);
            }
        }
        
        maxValue = Math.max(maxValue,positionSet.size());

    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        board = new int[size][size];
        for(int i = 0; i < size; i ++){
            String[] boardData = sc.nextLine().split(" ");
            for(int j = 0 ;j < size; j++){
                board[i][j] = Integer.parseInt(boardData[j]);
                if(boardData[j].equals("1")){
                    bombList.add(new int[]{i,j});
                }
            }
        }
        int[][] firstBomb = new int[][]{{-2,0},{-1,0},{0,0},{1,0},{2,0}};
        int[][] secondBomb = new int[][]{{-1,0},{0,-1},{0,0},{0,1},{1,0}};
        int[][] thirdBomb = new int[][]{{-1,-1},{-1,1},{0,0},{1,-1},{1,1}};
        
        bombBoard[0] = firstBomb;
        bombBoard[1] = secondBomb;
        bombBoard[2] = thirdBomb;

        find(0);

        System.out.println(maxValue);
    }
}