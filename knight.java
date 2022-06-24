import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int x,y;

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

public class knight {
    static int m;
    static int k_m;
    static int k_n;
    static int d_m;
    static int d_n;
    static boolean[][] graph ;
    static int[][] cost ;

    static int[] dx = {-2,-2,2,2,-1,1,-1,1};
    static int[] dy = {-1,1,-1,1,-2,-2,2,2};

    static void bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        graph[x][y] = true;
        cost[x][y] = 0;
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node node = q.poll();
            int xx = node.getX();
            int yy = node.getY();

            if (k_m == d_m && k_n == d_n) break;

            for(int i=0;i<8;i++){
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if(nx < 0 || nx >= m || ny <0 || ny >=m) continue;
                if(graph[nx][ny] == false) {
                    if (nx == d_m && ny == d_n) {
                        graph[nx][ny] = true;
                        cost[nx][ny] = cost[xx][yy] + 1;
                        break;

                    }
                    else {
                        q.offer(new Node(nx, ny));
                        graph[nx][ny] = true;
                        cost[nx][ny] = cost[xx][yy] + 1;
                    }


                }

            }
        }



    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            m = sc.nextInt();
            k_m = sc.nextInt();
            k_n = sc.nextInt();
            d_m = sc.nextInt();
            d_n = sc.nextInt();
            sc.nextLine();
            graph = new boolean[m][m];
            cost = new int[m][m];



            bfs(k_m, k_n);
            System.out.println(cost[d_m][d_n]);
        }
    }
}
