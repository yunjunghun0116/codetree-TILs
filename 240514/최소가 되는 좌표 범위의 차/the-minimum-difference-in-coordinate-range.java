import java.util.*;

public class Main {
    public static int minLength = Integer.MAX_VALUE;
    public static int d;
    public static Set<Integer> xSet = new HashSet<>();
    public static List<Integer> list;

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

        list = getXList();

        int result = find();

        System.out.println(result);
    }

    public static int find(){
       
        int end = 0;

        int currMinY = minY[end];
        int currMaxY = maxY[end];

        for(int i = 0; i < list.size()-1; i++){
            while(end < list.size()-1){
                end++;
                currMinY = Math.min(currMinY,minY[end]);
                currMaxY = Math.max(currMaxY,maxY[end]);
                if(!needFind(currMinY,currMaxY,list.get(end))){
                    minLength = Math.min(minLength,Math.abs(list.get(end) - list.get(i)));
                    break;
                }
                
            }
            if(!needFind(currMinY,currMaxY,list.get(end))){
                minLength = Math.min(minLength,Math.abs(list.get(end) - list.get(i)));
            }
            if(minY[i] == currMinY){
                currMinY = findMinValue(i+1,end);
            }
            if(maxY[i] == currMaxY){
                currMaxY = findMaxValue(i+1,end);
            }
        }
        if(minLength == Integer.MAX_VALUE) return -1;
        return minLength;
    }
    public static int findMaxValue(int start,int end){
        int maxValue = Integer.MIN_VALUE;
        for(int i = start; i < end; i++){
            maxValue = Math.max(maxY[list.get(i)],maxValue);
        }
        return maxValue;
    }
    public static int findMinValue(int start,int end){
        int minValue = Integer.MAX_VALUE;
        for(int i = start; i < end; i++){
            minValue = Math.max(minY[list.get(i)],minValue);
        }
        return minValue;
    }

    public static List<Integer> getXList(){
        List<Integer> xList = new ArrayList<>();
        for(int i : xSet){
            xList.add(i);
        }

        Collections.sort(xList);

        return xList;
    }
    public static boolean needFind(int minValue,int maxValue,int x){
        if(Math.abs(minValue - maxY[x]) >= d) return false;
        if(Math.abs(maxValue - minY[x]) >= d) return false;
        return true;
    }
}