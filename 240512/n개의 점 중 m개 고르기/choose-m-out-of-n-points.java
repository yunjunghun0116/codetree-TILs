import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static List<Point> pointList = new ArrayList<>(); 
    public static List<Integer> list = new ArrayList<>();
    public static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        for(int i = 0; i < n; i++){
            String[] pointInfo = sc.nextLine().split(" ");
            pointList.add(new Point(Integer.parseInt(pointInfo[0]),Integer.parseInt(pointInfo[1])));
        }

        find(0);

        System.out.println(minDistance);
        
    }
    public static void find(int currIndex){
        if(list.size() == m){
            int mDistance = 0;
            for(int i = 0; i < m-1;i++){
                for(int j = i+1; j < m;j++ ){
                    Point a = pointList.get(list.get(i));
                    Point b = pointList.get(list.get(j));
                    int distance = (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
                    mDistance = Math.max(mDistance, distance);
                }
            }
            minDistance = Math.min(minDistance,mDistance);
            return;
        }
        if(currIndex >= n) return;
        for(int i = currIndex; i < n; i++){
            list.add(i);
            find(i+1);
            list.remove(list.size()-1);
        }
    }

    static class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}