import java.util.*;

public class Main {
    public static int minLength = Integer.MIN_VALUE;
    public static int d;
    public static Set<Integer> xSet = new HashSet<>();

    public static int[] minY = new int[1000001];
    public static int[] maxY = new int[1000001];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);

        for(int i = 0; i < n; i++){
            String[] point = sc.nextLine().split(" ");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            xSet.add(x);

            if(minY[x] == 0){
                minY[x] = y;
            }else{
                minY[x] = Math.min(minY[x],y);
            }

            if(maxY[x] == 0){
                maxY[x] = y;
            }else{
                maxY[x] = Math.min(maxY[x],y);
            }
        }

        int result = find();
        System.out.println(result);
    }

    public static int find(){
        List<Integer> list = new ArrayList<>();
        for(int i : xSet){
            list.add(i);
        }

        Collections.sort(list);
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            while(end < list.size() && needFind(list.get(i),list.get(end))){
                end++;
            }
            if(end == list.size()) break;
            if(!needFind(list.get(i),list.get(end))){
                minLength = Math.min(minLength, list.get(end) - list.get(i));
            }
        }
        if( minLength == Integer.MAX_VALUE) return -1;
        return minLength;
    }

    public static boolean needFind(int a,int b){
        if(Math.abs(minY[a] - maxY[b]) >= d) return false;
        if(Math.abs(minY[b] - maxY[a]) >= d) return false;
        return true;
    }
}