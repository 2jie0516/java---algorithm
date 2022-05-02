import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;




public class black_jack {
    static int[] card;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        card = new int[m+1];
        for(int i =0;i<m ; i++) {
            card[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                for(int k=j+1;k<m;k++){

                    int sum_ = card[i] + card[j] +card[k];
                    if( sum_<= n && sum_ > sum){
                        sum = sum_;
                    }
                }
            }
        }

        System.out.println(sum);

    }
}
