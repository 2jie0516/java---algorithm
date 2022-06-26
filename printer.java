import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int cost;
    int index;

    public Node(int cost, int index) {
        this.cost = cost;
        this.index = index;
    }

    public int getCost() {
        return cost;
    }

    public int getIndex() {
        return index;
    }
}

public class printer {
    static Queue<Node> q ;
    static int m;
    static int n;
    static int target;

    static void print(){
        int k = m;
        int cnt = 0;
        while(k != 0) {
            int max = 0;
            int max_index = 0;

            for (int i = 0; i < m; i++) {
                Node node = q.poll();

                if (max < node.getCost()) {
                    max = node.getCost();
                    max_index = node.getIndex();

                }

                q.offer(node);


            }

            for (int i = 0; i <= m; i++) {
                Node node = q.poll();



                if (max_index == node.getIndex()) {
                    cnt++;

                    if (n == max_index) {

                        System.out.println(cnt);

                        return;
                    }
                    break;
                }

                q.offer(node);

            }
            k--;
//            System.out.print("사이즈: ");
//            System.out.println(q.size());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();



        for(int i =0;i<num;i++){
            q = new LinkedList<Node>();
            m = sc.nextInt();
            n = sc.nextInt();
            for(int j =0;j<m;j++){
                int num_ = sc.nextInt();

                q.offer(new Node(num_,j));
            }
            print();
        }



    }
}
