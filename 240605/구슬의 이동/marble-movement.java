import java.util.*;

public class Main {
    public static int n;
    public static int t;
    public static int k;
    public static List<Pair>[][] board;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        setUp();
        for(int i = 0; i < t; i++){
            next();
        }

        int result = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                result += Math.min(board[i][j].size(),k);
            }
        }
        
        System.out.println(result);

        
    }
    public static void setUp(){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);
        k = Integer.parseInt(input[3]);

        Map<String,Integer> dirMap = new HashMap<>();
        dirMap.put("U",0);
        dirMap.put("L",1);
        dirMap.put("R",2);
        dirMap.put("D",3);

        board = new ArrayList[n][n];
    

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                board[i][j] = new ArrayList<>();
            }
        }
        int value = 1;
        for(int i = 0; i < m; i++){
            String[] pairInput = sc.nextLine().split(" ");
            int y = Integer.parseInt(pairInput[0])-1;
            int x = Integer.parseInt(pairInput[1])-1;
            int direction = dirMap.get(pairInput[2]);
            int moveCount = Integer.parseInt(pairInput[3]);
            Pair pair = new Pair(y,x,direction,value++,moveCount);
            board[y][x].add(pair);
        }
    }
    public static void next(){
        List<Pair> tempPairs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                List<Pair> list = board[i][j];
                if(list.isEmpty()) continue;
                if(list.size() > k){
                    Collections.sort(list,(a,b)->b.getValue()-a.getValue());
                }
                for(int m = 0; m < Math.min(list.size(), k); m++){
                    tempPairs.add(list.get(m));
                }
                board[i][j].clear();
            }
        }

        for(Pair pair : tempPairs){
            pair.move(n);
            int[] position = pair.getPosition();
            board[position[0]][position[1]].add(pair);
        }
    }
}
class Pair { 
    int y;
    int x;
    int direction;
    int value;
    int moveCount;
    public Pair(int y, int x, int direction, int value, int moveCount) { 
        this.y = y;
        this.x = x; 
        this.direction = direction;
        this.value = value;
        this.moveCount = moveCount;
    }
    public void move(int n){
        // 0 : U, 1 : L, 2 : R, 3 : D
        int[] dy = {-1,0,0,1};
        int[] dx = {0,-1,1,0};
        for(int i = 0; i < moveCount; i++){
            int nextI = y + dy[direction];
            int nextJ = x + dx[direction];
            if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n){
                direction = 3 - direction;
                i--;
                continue;
            }
            y = nextI;
            x = nextJ;
        }
    }
    public int[] getPosition(){
        return new int[]{y,x};
    }
    public int getValue(){
        return value;
    }
}