import java.util.*;

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class rec {
    static Queue<Node> q;
    static boolean[][] graph;
    static int[][] rec;
    static int m;
    static int n;
    static int num;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Integer> arr = new ArrayList<Integer>();

    static void bfs(int x,int y){

        q = new LinkedList<>();
        int cnt = 1;
        for(int i =0;i<num;i++){
            if(rec[i][0] <= y && y < rec[i][2] && rec[i][1] <= x && x < rec[i][3]){
                return;
            }
        }



        graph[x][y] = true;
        q.offer(new Node(x,y));

        while (!q.isEmpty()){
            Node node = q.poll();
            int xx = node.getX();
            int yy = node.getY();

            for(int i=0 ; i <4 ;i++){
                int temp_x = xx + dx[i];
                int temp_y = yy + dy[i];

                if(temp_x < 0 || temp_x >=m || temp_y < 0 || temp_y >=n) continue;

                for(int j =0;j<num;j++){
                    if(rec[j][0] <= temp_y && temp_y < rec[j][2] && rec[j][1] <= temp_x && temp_x < rec[j][3]) {

                        break;
                    }

                    if(j == num-1 && graph[temp_x][temp_y] == false){
                        graph[temp_x][temp_y] = true;
                        q.offer(new Node(temp_x,temp_y));
                        cnt ++;

                    }
                }



            }
        }


        arr.add(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        num = sc.nextInt();

        graph = new boolean[m][n];
        rec = new int[num][4];
        sc.nextLine();

        for(int i =0 ; i< num;i++){
            for(int j=0;j<4;j++){
                rec[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }



        for(int i =0 ;i <m;i++){
            for(int j=0;j< n;j++){
                if(graph[i][j] == false){
                    bfs(i,j);

                }
            }
        }


        Collections.sort(arr);
        System.out.println(arr.size());


        for(int i =0 ; i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }


    }



}
