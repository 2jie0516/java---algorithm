import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Color{
    int x;
    int y;

    public Color(int x, int y) {
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

public class color {
    static Character[][] graph;
    static boolean[][] node;
    static Character char_temp;
    static int result =0;
    static int m;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        m = sc.nextInt();
        sc.nextLine();
        graph = new Character[m+1][m+1];
        node = new boolean[m+1][m+1];

        for(int i = 1;i <= m;i++){
            String str = sc.nextLine();
            for(int j=0;j<m;j++){
                graph[i][j+1] = str.charAt(j);

            }
        }

        for(int i = 1;i <= m;i++){
            for(int j=1;j<=m;j++){
                if(graph[i][j] == 'R' || graph[i][j] == 'G' || graph[i][j] == 'B' ){
                    if(!node[i][j]) {
                        char_temp = graph[i][j];

                        bfs(i, j, char_temp);
                        result++;
                    }
                }
            }
        }
        System.out.print(result+" ");
        result =0;
        for(int i = 1;i <= m;i++){
            for(int j=1;j<=m;j++){
                if(graph[i][j] == 'R' || graph[i][j] == 'G'){



                    bfs_rg(i, j);
                    result++;

                }
                else if(graph[i][j] == 'B' ){


                    bfs_b(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);

    }
    static void bfs_rg(int x,int y){
        Queue<Color> q = new LinkedList<Color>();
        q.offer(new Color(x,y));

        while(!q.isEmpty()){

            Color color = q.poll();
            int x_temp = color.getX();
            int y_temp = color.getY();

            for(int i=0;i<4;i++){
                int dxx = x_temp + dx[i];
                int dyy = y_temp + dy[i];

                if(dxx <=0 || dxx > m ||dyy<=0 || dyy>m) continue;



                if(graph[dxx][dyy] == 'R' ||graph[dxx][dyy] == 'G' ){

                    q.offer(new Color(dxx,dyy));
                    graph[dxx][dyy] = 'F';
                }
            }
        }


    }

    static void bfs_b(int x,int y){
        Queue<Color> q = new LinkedList<Color>();
        q.offer(new Color(x,y));

        while(!q.isEmpty()){

            Color color = q.poll();
            int x_temp = color.getX();
            int y_temp = color.getY();

            for(int i=0;i<4;i++){
                int dxx = x_temp + dx[i];
                int dyy = y_temp + dy[i];

                if(dxx <=0 || dxx > m ||dyy<=0 || dyy>m) continue;

                if(graph[dxx][dyy] == 'B'){
                    q.offer(new Color(dxx,dyy));
                    graph[dxx][dyy] = 'F';
                }


            }
        }


    }

    static void bfs(int x,int y,Character z){
        Queue<Color> q = new LinkedList<Color>();
        q.offer(new Color(x,y));
        node[x][y] = true;
        while(!q.isEmpty()){

            Color color = q.poll();
            int x_temp = color.getX();
            int y_temp = color.getY();

            for(int i=0;i<4;i++){
                int dxx = x_temp + dx[i];
                int dyy = y_temp + dy[i];

                if(dxx <=0 || dxx > m ||dyy<=0 || dyy>m) continue;



                if(graph[dxx][dyy] == z && !node[dxx][dyy]){

                    q.offer(new Color(dxx,dyy));
                    node[dxx][dyy] = true;
                }
            }
        }

    }

}
