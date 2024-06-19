import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static List<Integer> maxValueList = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                find(i,j);
            }
        }

        Collections.sort(maxValueList,(a,b)->b-a);

        System.out.println(maxValueList.get(0)+maxValueList.get(1));
    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        n = Integer.parseInt(sizeInput[0]);
        m = Integer.parseInt(sizeInput[1]);

        board = new int[n][m];

        for(int i = 0; i < n ; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }
    public static void find(int y, int x){
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < n-y; i++){
            for(int j = 0; j < m-x; j++){
                maxValue = Math.max(maxValue,getSum(y,x,i,j));
            }
        }
        maxValueList.add(maxValue);
    }
    public static int getSum(int y, int x, int m, int n){
        int sum = 0;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                sum += board[y+i][x+j];
            }
        }
        return sum;
    }
}