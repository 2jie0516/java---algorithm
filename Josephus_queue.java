import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus_queue {
    static int num =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> q1 = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            q.offer(i);

        }


        int qsize;
        sb.append("<");
        while (true) {
            qsize = q.size();



            for (int i = 1; i <= qsize; i++) {

                num++;
                if (num == k) {

                    if(qsize == 2){
                        sb.append(q.poll()).append(", ");
                        break;
                    }


                    sb.append(q.poll()).append(", ");
                    num = 0;

                }
                else {

                    q1.offer(q.poll());

                }
            }


        if (q1.size() == 1) {
            sb.append(q1.poll()).append(">");
                break;
        }

        else{
            qsize = q1.size();
            for(int i =1;i<=qsize;i++){
                q.offer(q1.poll());
            }
        }



        }
        System.out.println(sb);
    }

}
