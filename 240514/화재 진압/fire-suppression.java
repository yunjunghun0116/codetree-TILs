import java.util.*;

public class Main {
    public static int[] fires;
    public static int[] stations;
    public static int maxLength = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        int n = Integer.parseInt(sizeInput[0]);
        int m = Integer.parseInt(sizeInput[1]);
        fires = new int[n];
        stations = new int[m];

        String[] fireInput = sc.nextLine().split(" ");
        for(int i = 0; i < n; i ++){
            fires[i] = Integer.parseInt(fireInput[i]);
        }
        String[] stationInput = sc.nextLine().split(" ");
        for(int i = 0; i < m; i ++){
            stations[i] = Integer.parseInt(stationInput[i]);
        }

        Arrays.sort(fires);
        Arrays.sort(stations);

        find();

        System.out.println(maxLength);
    }

    public static void find(){
        int end = 0;
        int preLength = Integer.MAX_VALUE;
        for(int i = 0; i < fires.length; i++){
            // i : 불의 위치
            // end : 소방서 위치
            while(end < stations.length ){
                if(end > 0 && Math.abs(stations[end]-fires[i])>Math.abs(stations[end-1]-fires[i])){
                    break;
                }
                if(end == stations.length -1) break;
                end++;
            }
            maxLength = Math.max(maxLength, Math.abs(stations[end]-fires[i]));
        }
    }
}