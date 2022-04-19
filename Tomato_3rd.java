import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



class Tomato{
    int z;
    int x;
    int y;

    public Tomato(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Tomato_3rd {
    static int m;
    static int n;
    static int h;
    static int[][][] graph;
    static int dx[] = {-1,1,0,0,0,0};
    static int dy[] = {0,0,-1,1,0,0};
    static int dz[] = {0,0,0,0,-1,1};
    static Queue<Tomato> q = new LinkedList<Tomato>();


    static void bfs(Queue<Tomato> q){




        while(!q.isEmpty())
        {
            Tomato tomato_node = q.poll();

            int dzz = tomato_node.getZ();
            int dxx = tomato_node.getX();
            int dyy = tomato_node.getY();
            for(int i =0;i<=5;i++){
                int z_temp = dzz + dz[i];
                int x_temp = dxx + dx[i];
                int y_temp = dyy + dy[i];

                if(z_temp > 0 && z_temp <= h && x_temp > 0 && x_temp <= n && y_temp > 0 && y_temp <= m) {
                    if (graph[z_temp][x_temp][y_temp] == 0) {
                        graph[z_temp][x_temp][y_temp] = graph[dzz][dxx][dyy] + 1;
                        q.offer(new Tomato(z_temp,x_temp,y_temp));
                }
            }
           }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        sc.nextLine();

        graph = new int[h+1][n+1][m+1];

        for(int i=1;i<=h;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=m;k++){
                    graph[i][j][k] = sc.nextInt();
                }
            }

        }

        for(int i=1;i<=h;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=m;k++){
                    if(graph[i][j][k] == 1){
                        q.offer(new Tomato(i,j,k));


                    }
                }
            }
        }
        bfs(q);
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=h;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=m;k++){
                    if(graph[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }

                    else{
                        max = Math.max(max , graph[i][j][k]);
                    }
                }
            }
        }


        System.out.println(max-1);
    }
}
