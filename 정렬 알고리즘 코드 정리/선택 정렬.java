import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
            for(int i=0;i<arr.length;i++){
                int min_idx = i;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[min_idx] > arr[j]){
                        min_idx = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
        for (int num : arr) {
            System.out.print(num+" ");
        }
        }

}
