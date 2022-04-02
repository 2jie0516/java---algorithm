import java.util.*;

public class Virus_dfs {
    public static int virus=0;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] node;



    public static void dfs(int x){
        node[x] = true;

        for(int i=0;i<graph.get(x).size();i++){
            int temp = graph.get(x).get(i);
            if(!node[temp]) {
                virus ++;
                dfs(temp);
            }
            }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        node = new boolean[101];
        for(int i=0; i <= m;i++){
            node[i] = false;
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 1;i<=n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);

        }


        dfs(1);
        System.out.println(virus);
    }


}
