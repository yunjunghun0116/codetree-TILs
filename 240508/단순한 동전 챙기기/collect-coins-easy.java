import java.util.*;

public class Main {
    public static int[][] board;
    public static int[] start;
    public static int[] end;
    public static Map<Integer,int[]> pointMap = new HashMap<>();
    public static List<Integer> pointList = new ArrayList<>();
    public static List<Integer> list = new ArrayList<>();
    public static int minMove = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        board = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split("");
            for(int j = 0; j < n; j++){
                if(input[j].equals(".")) continue;
                if(input[j].equals("S")){
                    start = new int[]{i,j};
                    continue;
                }
                if(input[j].equals("E")){
                    end = new int[]{i,j};
                    continue;
                }
                int number = Integer.parseInt(input[j]);
                board[i][j] = number;
                pointMap.put(number,new int[]{i,j});
                pointList.add(number);
            }
        }

        Collections.sort(pointList);

        find(0,0);

        System.out.println(minMove<Integer.MAX_VALUE?minMove:-1);
    }

    public static void find(int currLength,int currIndex){
        if(pointList.size()<3) return;
        if(currLength == 3){
            int moveCount = 0;
            moveCount += move(start, pointMap.get(pointList.get(list.get(0))));
            moveCount += move(pointMap.get(pointList.get(list.get(0))), pointMap.get(pointList.get(list.get(1))));
            moveCount += move(pointMap.get(pointList.get(list.get(1))), pointMap.get(pointList.get(list.get(2))));
            moveCount += move(pointMap.get(pointList.get(list.get(2))), end);
            minMove = Math.min(minMove, moveCount);
            return;
        }
        if(currIndex >= pointList.size()) return;
        list.add(currIndex);
        find(currLength+1,currIndex+1);
        list.remove(list.size()-1);

        find(currLength, currIndex+1);
    }

    public static int move(int[] start, int[] end){
        return Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
    }
}