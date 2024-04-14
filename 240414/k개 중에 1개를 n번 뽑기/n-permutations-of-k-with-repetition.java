import java.util.*;

public class Main {
    public static int number = 4;
    public static int length = 8;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void print(){
        for(int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }

    public static void choose(int currLength){
        if(currLength == length){
            print();
            return;
        }
        for(int i = 1;i <= number; i++){
            answer.add(i);
            choose(currLength+1);
            answer.remove(answer.size()-1);
        }
    
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] inputs = line.split(" ");
        number = Integer.parseInt(inputs[0]);
        length = Integer.parseInt(inputs[1]);
        choose(0);
    }
}