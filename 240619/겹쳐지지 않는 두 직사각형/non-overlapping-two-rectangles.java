import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static int maxResult = -1000;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                find(i,j);
            }
        }

        System.out.println(maxResult);
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
    // a,b에서 m,n 개 만큼의 직사각형을 만듬
    // 1에서 만든 후 만약 2에서 만든게 겹치면 바로 return, 다음으로
    public static void find(int y, int x){
        for(int i = 0; i < n-y; i++){
            for(int j = 0; j < m-x; j++){
                visited = new boolean[n][m];
                int sum = 0;
                for(int p = 0; p <= i; p++){
                    for(int q = 0; q<= j; q++){
                        visited[y+p][x+q] = true;
                        sum += board[y+p][x+q];
                    }
                }
                int secondValue = findSecond();
                maxResult = Math.max(maxResult,sum+secondValue);
            }
        }
    }
    public static int findSecond(){
        int maxSum = -1000;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                for(int p = 0; p < n-i; p++){
                    for(int q = 0; q < m-j; q++){
                        int[] secondValue = getSecondValue(i,j,p,q);
                        if(secondValue[0]==1){
                            maxSum = Math.max(maxSum,secondValue[1]);
                        }
                    }
                }
            }
        }
        return maxSum;
    }
    public static int[] getSecondValue(int y,int x,int p,int q){
        boolean flag = true;
        int sum = 0;
        for(int i = 0; i <= p; i++){
            for(int j = 0; j <= q; j++){
                if(visited[y+i][x+j]){
                    flag = false;
                    return new int[]{0,0};
                }
                sum += board[y+i][x+j];
            }
        }
        return new int[]{1,sum};
    }

}