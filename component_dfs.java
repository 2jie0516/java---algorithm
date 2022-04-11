import java.util.ArrayList;
import java.util.Scanner;

public class component_dfs {
    static int[][] graph;
    static boolean[] node;
    static int m;
    static int n;
    static int result;
    public static void dfs(int x){
        node[x] = true;

        for(int i =1;i<=n;i++) {
            if (node[n] != true && graph[x][i] ==1) dfs(n);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new int[n+1][n+1];
        node = new boolean[n+1];
        for(int i=1;i<=m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = graph[y][x] = 1;
        }

        for(int i=1;i <= n;i++){
            if(node[i] != true)
                dfs(i);
                result ++;
        }
        System.out.println(result);
    }
}
