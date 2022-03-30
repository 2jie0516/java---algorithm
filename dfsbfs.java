import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.concurrent.ScheduledExecutorService;

public class dfsbfs {
    static boolean[] node = new boolean[1001];
    static int[][] path = new int[1001][1001];
    static int n;
    static int m;
    static int start;
    static int x;
    static int y;


    public static void dfs(int i){
        node[i] = true;
        System.out.print(i+" ");
        for(int j=1; j<= n;j++){
            if(path[i][j] == 1 && node[j]==false) dfs(j);
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        node[start] = true;
        System.out.print(start+" ");

        while (!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=1 ; i<=n;i++){
                if (path[temp][i] == 1 && node[i] == false){
                    queue.offer(i);
                    node[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        sc.nextLine();

        for(int i= 0 ; i<m ; i++){
            x = sc.nextInt();
            y = sc.nextInt();

            path[x][y] = path[y][x] = 1;


        }

        dfs(start);

        node = new boolean[1001];
        System.out.println();

        bfs();
    }
}
