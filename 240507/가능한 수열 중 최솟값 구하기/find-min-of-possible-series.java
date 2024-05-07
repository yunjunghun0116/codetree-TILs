import java.util.*;

public class Main {
    public static List<Integer> arr = new ArrayList<>();
    public static int length;
    public static boolean find = false;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        length = Integer.parseInt(sc.nextLine());
        find(0);
    }
    public static void find(int currLen){
        if(find) return;
        if(currLen == length){
            for(int i = 0; i < length; i++){
                System.out.print(arr.get(i));
            }
            find = true;
            return;
        }
        for(int i = 4;i <= 6; i++){
            if(arr.size()>0 && arr.get(arr.size()-1) == i) continue;
            arr.add(i);
            boolean canAdd = check();
            if(canAdd){
                find(currLen+1);
            }
            arr.remove(arr.size()-1);
            
        }
    }
    public static boolean check(){
        for(int i = arr.size()-2; i >= 0; i--){
            if(arr.get(i) == arr.get(arr.size()-1)){
                int start = i+1;
                int end = arr.size()-1;
                int length = end - start + 1;
                int firstCheck = start-length;
                if(firstCheck < 0) return true;
                for(int j = firstCheck; j < start; j++){
                    if(arr.get(j) != arr.get(j+length)) return true;
                }
                return false;
            }
        }
        return true;
    }
}