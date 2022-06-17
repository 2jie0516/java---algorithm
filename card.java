import java.util.Scanner;




public class card {


    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] num = new int[n+1];
        int[] dp = new int[n+1];
        num[0] = 0;

        for (int i = 1; i <= n; i++) {
            int num_ = sc.nextInt();
            num[i] = num_;
            dp[i] = num_;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= n; j++) {

                for (int k = 0; k <= n; k++) {
                    if (j + k == i) {

                        if (dp[j] + num[k] >= max) {
                            max = dp[j] + num[k];



                            break;
                        }
                    }
                }
            }
            dp[i] = max;
        }

        System.out.println(max);
    }
}
