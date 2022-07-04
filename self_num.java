public class self_num {


    public static void main(String[] args) {
        boolean[] self_num = new boolean[10001];
        int sum=0;
        int num;
        int m_num;
        int th_num;
        int h_num;
        int t_num;
        int o_num;

        for(int i =1;i<=10000;i++){
            if(i<10 && i%2 !=0)
                System.out.println(i);

            num = i;
            sum += num;
            m_num = num / 10000;
            num = num % 10000;
            th_num = num / 1000;
            num = num % 1000;
            h_num = num / 100;
            num = num % 100;
            t_num = num / 10;
            num = num % 10;
            o_num = num;

            sum += m_num + th_num + h_num + t_num + o_num;

            if(sum <= 10000)
                self_num[sum] = true;

            sum =0;
        }

        for(int i=10;i<10000;i++){
            if(self_num[i] == false)
                System.out.println(i);
        }


    }



}
