import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue_bj {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        int back= -1;
        for(int i=0;i<t;i++){
            String str = sc.next();
            switch (str) {
                case "push":
                    back = sc.nextInt();
                    q.offer(back);
                    break;
                case "front":
                    sb.append(q.isEmpty()? -1:q.peek()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty()? -1: back).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty()? 1:0).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "pop":
                    sb.append(q.isEmpty()? -1:q.poll()).append("\n");
                    break;
            }

        }
        System.out.println(sb);
    }

}
