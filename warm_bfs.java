import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}

public class warm_bfs {
    static int t;
    static int[][] graph;
    static int m;
    static int n;
    static int result;
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};



    public static void bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        graph[x][y] = 0;
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node node = q.poll();
            int x_ = node.getX();
            int y_ = node.getY();
            graph[x_][y_] = 0;

            for(int i=0;i<= 3;i++){
                int d_x = x_ + dx[i];
                int d_y = y_ + dy[i];


                if(d_x <0 || d_x> m || d_y <0 || d_y>n) continue;

                if(graph[d_x][d_y] == 0 ) continue;

                if(graph[d_x][d_y] == 1) {
                    q.offer(new Node(d_x, d_y));
                    graph[d_x][d_y] = 0;



                }



            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        sc.nextLine();
        for(int test = 0;test<t;test++) {
            result = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();


            graph = new int[m + 1][n + 1];


            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[x][y] = 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {

                        bfs(i, j);
                        result++;

                    }
                }
            }
            System.out.println(result);
        }
    }

}
