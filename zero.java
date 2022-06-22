import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class zero {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();

        int m = sc.nextInt();
        sc.nextLine();
        int num;
        for(int i =0;i < m;i++){
            num = sc.nextInt();
            if(num == 0)
                s.pop();
            else

                s.push(num);
        }
        int result=0;

        while(!s.empty()){
            result += s.pop();
        }

        System.out.println(result);






    }
}
