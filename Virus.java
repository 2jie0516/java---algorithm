import java.util.*;

public class Virus {
    public static int virus=0;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] node;
    public static int m;
    public static int n;
    public static int x;
    public static int y;
    public static int temp;
    public static int temp1;

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        node[x] = true;
        q.offer(x);
        while(!q.isEmpty()) {
            temp = q.poll();

            for (int i = 0; i < graph.get(temp).size(); i++) {
                temp1 = graph.get(temp).get(i);
                if(!node[temp1]){
                    q.offer(temp1);
                    node[temp1] = true;
                    virus ++;

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        node = new boolean[m+1];
        for(int i=1; i <= m;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 1;i<=n;i++){
            x = sc.nextInt();
            y = sc.nextInt();

            graph.get(x).add(y);
        }


        bfs(1);
        System.out.println(virus);
    }


}
