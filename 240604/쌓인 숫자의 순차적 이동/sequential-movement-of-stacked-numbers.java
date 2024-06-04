import java.util.*;

public class Main {
    public static int n;
    public static Queue<Integer> queue = new LinkedList<>();
    public static Map<Integer,int[]> posMap = new HashMap<>();
    public static List<List<List<Integer>>> board = new ArrayList<>();
    public static Stack<Integer> stack = new Stack<>();

    public static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public static int[] dx = {0,-1,-1,-1,0,1,1,1};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        int count = 0;
        while(!queue.isEmpty()){
            move();
        }
        print();
    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");

        n = Integer.parseInt(sizeInput[0]);
        int m = Integer.parseInt(sizeInput[1]);


        for(int i = 0; i < n ; i++){
            String[] boardInput = sc.nextLine().split(" ");
            List<List<Integer>> innerBoard = new ArrayList<>();
            for(int j = 0 ; j < n; j++){
                int value = Integer.parseInt(boardInput[j]);
                List<Integer> tempBoard = new ArrayList<>();
                tempBoard.add(value);
                innerBoard.add(tempBoard);

                posMap.put(value, new int[]{i,j});
            }
            board.add(innerBoard);
        }

        String[] queueInput = sc.nextLine().split(" ");
        for(String s : queueInput){
            queue.add(Integer.parseInt(s));
        }
    }
    public static void print(){
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j ++){
                List<Integer> list = board.get(i).get(j);
                if(list.isEmpty()){
                    System.out.println("None");
                    continue;
                }
                for(int k = list.size()-1; k>= 0; k--){
                    System.out.print(list.get(k)+" ");
                }
                System.out.println();
            }
        }
    }
    public static void move(){
        int number = queue.poll();
        int[] position = posMap.get(number);

        int maxValue = 0;
        int[] maxPosition = new int[2];
        for(int i = 0; i < 8; i++){
            int nextI = position[0]+dy[i];
            int nextJ = position[1]+dx[i];
            if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n) continue;
            if(board.get(nextI).get(nextJ).isEmpty()) continue;
            int listMax = 0;
            for(int num : board.get(nextI).get(nextJ)){
                listMax = Math.max(listMax,num);
            }
            if(listMax > maxValue){
                maxValue = listMax;
                maxPosition = new int[]{nextI,nextJ};
            }
        }

        if(maxValue == 0) return;

        List<Integer> list = board.get(position[0]).get(position[1]);
        for(int i = list.size()-1; i >= 0; i--){
            stack.push(list.get(i));
            list.remove(i);
            if(stack.peek() == number){
                break;
            }        
        }

        while(!stack.isEmpty()){
            int popValue = stack.pop();
            board.get(maxPosition[0]).get(maxPosition[1]).add(popValue);

            posMap.put(popValue,new int[]{maxPosition[0],maxPosition[1]});
        }
    }
}