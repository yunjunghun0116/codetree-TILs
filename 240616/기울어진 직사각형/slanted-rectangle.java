import java.util.*;
public class Main {
    public static int n;
    public static int[] dy = {1,1};
    public static int[] dx = {-1,1};
    public static int[][] board;
    public static int maxSum = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                find(i,j);
            }
        }

        System.out.println(maxSum);

    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        
        board = new int[n][n];

        for(int i=0; i<n; i++){
            String[] boardInput = sc.nextLine().split(" ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
    }
    public static void find(int y, int x){
        for(int i = 1; i <= x; i++){
            for(int j = 1; j <= n-x; j++){
                int[] leftPoint = new int[]{y+dy[0]*i, x+dx[0]*i};
                int[] rightPoint = new int[]{y+dy[1]*j, x+dx[1]*j};
                int[] facePoint = new int[]{y+dy[0]*i+dy[1]*j, x+dx[0]*i+dx[1]*j};
                if(leftPoint[0]<0||leftPoint[0]>=n||leftPoint[1]<0||leftPoint[1]>=n) continue;
                if(rightPoint[0]<0||rightPoint[0]>=n||rightPoint[1]<0||rightPoint[1]>=n) continue;
                if(facePoint[0]<0||facePoint[0]>=n||facePoint[1]<0||facePoint[1]>=n) continue;

                int sum = 0;

                for(int l = 1; l <= i; l++){
                    sum+=board[y+dy[0]*l][x+dx[0]*l];
                }
                for(int r = 1; r <= j; r++){
                    sum+=board[y+dy[0]*i+dy[1]*r][x+dx[0]*i+dx[1]*r];
                }
                for(int l = 1; l <= i; l++){
                    sum+=board[y+dy[0]*i+dy[1]*j-dy[0]*l][x+dx[0]*i+dx[1]*j-dx[0]*l];
                }
                for(int r = 0; r < j; r++){
                    sum+=board[y+dy[1]*r][x+dx[1]*r];
                }

                maxSum = Math.max(maxSum,sum);
            }
        }
    }
}