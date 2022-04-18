import java.io.IOException;
import java.util.Scanner;



public class Alphabet {
    static int R;
    static int C;
    static int max= 0;
    static int[][] graph;

    static boolean[] path = new boolean[26];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void dfs(int x, int y,int cnt){
        if(path[graph[x][y]] == true){
            max = Math.max(max , cnt);
            return;
        }
        else{
            path[graph[x][y]] = true;

            for(int i=0;i<4;i++){
                int dx_temp = x + dx[i];
                int dy_temp = y + dy[i];



                if(dx_temp >0 && dx_temp <= R && dy_temp >0 && dy_temp <= C ){
                    dfs(dx_temp,dy_temp,cnt+1);
                }
            }
        }
        path[graph[x][y]] = false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        graph = new int[R+1][C+1];
        for(int i=1 ; i <= R ; i++){
            String str = sc.nextLine();
            for(int j=0 ;j< C;j++){
                graph[i][j+1] =  str.charAt(j);
            }
        }
        System.out.println(graph[1][1]);

        dfs(1,1,0);

        System.out.println(max);


    }


}
