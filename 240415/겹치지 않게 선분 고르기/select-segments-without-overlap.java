import java.util.*;

public class Main {
    public static List<int[]> lines = new ArrayList<>();
    public static List<int[]> currentList = new ArrayList<>();
    public static int maxCount = Integer.MIN_VALUE;
    public static void find(int currPos){
        if(currPos == lines.size()){
            maxCount = Math.max(maxCount,currentList.size());
            return;
        }
        if(currentList.isEmpty() || (currentList.get(currentList.size()-1)[1] < lines.get(currPos)[0])){
            currentList.add(lines.get(currPos));
            find(currPos+1);
            currentList.remove(currentList.size()-1);
        }
        find(currPos+1);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int lineLength = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < lineLength; i++){
            String[] lineInput = sc.nextLine().split(" ");
            lines.add(new int[]{Integer.parseInt(lineInput[0]),Integer.parseInt(lineInput[1])});
        }

        Collections.sort(lines,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        find(0);

        System.out.println(maxCount);
    }
}