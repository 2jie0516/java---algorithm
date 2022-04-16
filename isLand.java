import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


class Land{
    int x;
    int y;

    public Land(int x, int y) {
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

public class isLand {
    static int h;
    static int w;
    static int result;
    static int[][] graph;
    static int dx[] = {-1,1,0,0,1,-1,-1,1};
    static int dy[] = {0,0,-1,1,1,-1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            result = 0;
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w ==0 && h ==0) break;
            graph = new int[h + 1][w + 1];
            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j + 1] = Integer.parseInt(st.nextToken());


                }

            }
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (graph[i][j] == 1) {
                        result++;

                        bfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }
    static void bfs(int x,int y){

        Queue<Land> q= new LinkedList<Land>();
        q.offer(new Land(x,y));
        graph[x][y] = 0;
        while (!q.isEmpty()){
            Land land = q.poll();
            int x_temp = land.getX();
            int y_temp = land.getY();

            for(int i=0;i<8;i++){
                int dxx = x_temp + dx[i];
                int dyy = y_temp + dy[i];

                if(dxx <= 0 || dxx > h || dyy <= 0 || dyy >w){
                    continue;
                }

                if(graph[dxx][dyy] == 1){
                    graph[dxx][dyy] = 0;
                    q.offer(new Land(dxx,dyy));
                }
            }
        }


    }

}
