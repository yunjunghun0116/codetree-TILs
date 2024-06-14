import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static int maxCount = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                find(i,j);
            }
        }
        System.out.println(maxCount);

    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);

        String[] sizeInput = sc.nextLine().split(" ");
        n = Integer.parseInt(sizeInput[0]);
        m = Integer.parseInt(sizeInput[1]);

        board = new int[n][n];

        for(int i = 0; i < n; i ++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j = 0; j < n; j ++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }
    public static void find(int y, int x){
        for(int i = 0; i < n*n; i++){
            List<int[]> positionList = getPositionList(y,x,i);
            int count = 0;
            for(int[] position : positionList){
                count += board[position[0]][position[1]];
            }
            if(count * m >= (i*i)+(i+1)*(i+1)){
                maxCount = Math.max(maxCount,count);
            }
            if(positionList.size() == n*n){
                break;
            }
        }
    }
    public static List<int[]> getPositionList(int y, int x, int k){
        List<int[]> positionList = new ArrayList<>();
        // 윗부분 
        for(int i = -k; i <= 0; i++){
            for(int j = -k-i; j <= k+i; j++ ){
                if(isBoardIn(y+i,x+j)){
                    positionList.add(new int[]{y+i, x+j});
                }
            }
        }
        for(int i = 1; i<= k; i++){
            for(int j = -k+i; j <= k-i; j++ ){
                if(isBoardIn(y+i,x+j)){
                    positionList.add(new int[]{y+i, x+j});
                }
            }
        }

        return positionList;
    }
    public static boolean isBoardIn(int y, int x){
        if( y < 0 || y >= n || x < 0 || x >= n) return false;
        return true;
    }
}