import java.util.Scanner;

public class tile {

    static int[] tile;
    static int a;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        sc.nextLine();
        tile = new int[a+1];
        tile[1] = 1;

        if(a>=2) tile[2] = 2;

        if(a == 1)
            System.out.println(tile[1] % 15746);

        else if(a==2) {

            System.out.println(tile[a] % 15746);
        }
        else{
            for(int i=3 ; i<=a ;i++){
                tile[i] = tile[i-1] + tile[i-2];
                tile[i] %= 15746;
            }
            System.out.println(tile[a]);
        }


    }




}
