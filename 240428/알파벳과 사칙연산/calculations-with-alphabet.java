import java.util.*;

public class Main {
    public static List<Integer> arr = new ArrayList<>();
    public static String input;
    public static int maxValue = Integer.MIN_VALUE;
    public static void find(int currLen){
        if(currLen == 7){
            calculate();
            return;
        }
        for(int i = 1; i <= 4; i++){
            arr.add(i);
            find(currLen+1);
            arr.remove(arr.size()-1);
        }
    }
    public static void calculate(){
        int currValue = 0;
        for(int i = 0; i < input.length(); i+= 2){
            if(i == 0){
                currValue = arr.get(getIndex(input.charAt(i)));
                continue;
            }
            int calculation = input.charAt(i-1);
            int number = arr.get(getIndex(input.charAt(i)));

            if(calculation == '+')currValue = currValue + number;
            if(calculation == '-')currValue = currValue - number;
            if(calculation == '*')currValue = currValue * number;
        }
        maxValue = Math.max(maxValue,currValue);
        
    }
    public static int getIndex(char c){
        
        return (int)(c - 'a');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        find(0);

        System.out.println(maxValue);
    }
}