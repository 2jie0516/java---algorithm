import java.io.IOException;
import java.util.*;

public class Apartment {
    public static int apartment;
    public static int[][] graph = new int[26][26];
    public static int m;
    public static int result;
    public static ArrayList<Integer> num = new ArrayList<Integer>();

    private static boolean dfs(int x,int y) {

        if (x < 0 || x > m || y < 0 || y > m)
        {
            return false;
        }

        if(graph[x][y] == 1){
            apartment ++;
            graph[x][y] = 0;

            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);

            return true;

        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        sc.nextLine();

        for(int i=1;i<=m;i++){
            String str = sc.nextLine();
            for(int j =0;j <m;j++){
                graph[i][j+1] = str.charAt(j) - '0';
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(graph[i][j] == 1){
                    result ++;
                    apartment = 0;
                    dfs(i,j);
                    num.add(apartment);
                }
            }
        }
        System.out.println(result);
        Collections.sort(num);
        for(int i=0;i<result;i++){
            System.out.println(num.get(i));
        }


    }

}
