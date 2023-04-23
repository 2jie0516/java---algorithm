import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int[] sort = new int[arr.length+1];

        for(int i=0;i<arr.length;i++){
            sort[arr[i]] ++;
        }

        for(int i=0;i<sort.length;i++){
            for(int j=0;j<sort[i];j++){
                System.out.print(i+" ");
            }
        }
        }

}
