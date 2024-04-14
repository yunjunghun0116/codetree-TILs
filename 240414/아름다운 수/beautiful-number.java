import java.util.*;

public class Main {
    public static int length = 10;
    public static int count = 0;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void print(){
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }

    public static void find(int currLen){
        if(currLen == length){
            if(beautiful()){
                count++;
                
            }
            return;
        }
        for(int i = 1; i <= 4; i++){
            arr.add(i);
            find(currLen+1);
            arr.remove(arr.size()-1);
        }
    }
    public static boolean beautiful(){
        for(int i = 0; i < length; i++){
            int number = arr.get(i);
            if(i+number > length) return false;
            for(int j = i; j < i + number; j++){
                if(arr.get(j) == number) continue;
                return false;
            }
            i = i+number-1;
        }
        return true;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        length = Integer.parseInt(sc.nextLine());
        find(0);

        System.out.println(count);
    }
}