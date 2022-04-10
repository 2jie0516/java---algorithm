import java.util.*;

class Tomato_bfs {
    int x;
    int y;

    public Tomato_bfs(int x, int y) {
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



public class tomato_bfs {
    static int[][] box;
    static Queue<Tomato_bfs> q = new LinkedList<Tomato_bfs>();
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int m;
    static int n;

    public static void bfs(Queue<Tomato_bfs> q){


        while (!q.isEmpty()){
            Tomato_bfs node = q.poll();
            int x_temp = node.getX();
            int y_temp = node.getY();

            for(int i=0;i<4;i++){
                int x = x_temp +dx[i];
                int y = y_temp +dy[i];

                if(x < 0 || x >= n || y < 0 || y>= m) continue;

                if(box[x][y] == 0){
                    box[x][y] = box[x_temp][y_temp] + 1;
                    q.offer(new Tomato_bfs(x,y));


                }

            }


        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();

        box = new int[n][m];

        for(int i = 0;i< n;i++){

            for(int j=0;j<m;j++){
                box[i][j] = sc.nextInt();
            }
        }


        for(int i = 0;i < n;i++){
            for(int j=0;j <m;j++){
                if(box[i][j] == 1){
                    q.offer(new Tomato_bfs(i,j));

                }
            }
        }
        bfs(q);

        int max = Integer.MIN_VALUE;

        for(int i = 0;i < n;i++){
            for(int j=0;j <m;j++){
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                if(box[i][j] > max){
                    max = box[i][j];
                }
            }
        }
        System.out.println(max-1);

    }
}