//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Scanner;
import java.util.Stack;

public class vps_stack {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<Character>();
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        for(int j=0;j<t;j++) {
            s.clear();
            int num = 0;

            String str = sc.nextLine();

            for (int i = 0; i < str.length(); i++) {


                char vps = str.charAt(i);


                if (vps == '(') {
                    s.push('(');
                }
                else if (vps == ')') {
                    if (s.size() == 0) {
                        break;
                    }
                    s.pop();
                }
                num ++;
            }

            if(num != str.length())
                System.out.println("NO");

            else {
                if (s.size() == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }

}

