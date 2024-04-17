import java.util.*;

public class Main {
    public static List<int[]> ladList = new ArrayList<>();// start, height
    public static List<Integer> arr = new ArrayList<>();
    public static int minValue = Integer.MAX_VALUE;
    public static int[] result; //1,2,3,4
    public static Map<Integer,List<int[]>> makeMap(){
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i = 0; i <= 12; i++){
            map.put(i,new ArrayList<>());
        }

        for(int index : arr){
            int[] lad = ladList.get(index);
            List<int[]> sList = map.get(lad[0]);
            sList.add(new int[]{lad[0]+1,lad[1]});
            map.put(lad[0],sList);

            List<int[]> eList = map.get(lad[0]+1);
            eList.add(new int[]{lad[0],lad[1]});
            map.put(lad[0]+1,eList);
        }

        return map;
    }
    public static int[] check(){
        // 선택된 가로줄은 arr에서 확인 가능
        // 선택된 가로줄을 나열했을때 값이 같은지 확인해야함. -> 하나라도 다르면 return 하면 될듯
        Map<Integer,List<int[]>> map = makeMap();
        int[] answer = new int[result.length];

        for(int i = 1; i < result.length; i++){
             int currNumber = i;
             int currHeight = 0;

             while(true){
                List<int[]> currList = map.get(currNumber);
                if(currList.isEmpty()){
                    break;
                }
                boolean find = false;
                for(int j = 0; j < currList.size(); j++){
                    if(currHeight > currList.get(j)[1]) continue;
                    find = true;
                    currNumber = currList.get(j)[0];
                    currHeight = currList.get(j)[1]+1;
                    break;
                }
                if(!find) break;
             }
             answer[i] = currNumber;
        }

        if(arr.size() == ladList.size()){
            result = answer;
        }
        return answer;

    }
    public static void find(int length, int number){
        if(arr.size() == length){
            int[] ans = check();
            
            // 비교하기
            for(int i = 0; i < ans.length; i++){
                if(result[i] == ans[i]) continue;
                return;
            }
            minValue = Math.min(minValue,arr.size());
            return;
        }
        for(int i = number; i<ladList.size(); i++){
            arr.add(i);
            find(length,i+1);
            arr.remove(arr.size()-1);
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int size = Integer.parseInt(input[1]);
        result = new int[Integer.parseInt(input[0])+1];
        for(int i = 0; i < size; i++){
            String[] ladInput = sc.nextLine().split(" ");
            int[] lad = new int[2];
            lad[0] = Integer.parseInt(ladInput[0]);
            lad[1] = Integer.parseInt(ladInput[1]);
            ladList.add(lad);
        }

        Collections.sort(ladList,(a,b)->a[1]-b[1]);
        
        for(int i = size; i >= 0; i--){
            find(i,0);
        }
        
        System.out.println(minValue);

    }
}