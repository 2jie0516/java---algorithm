import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
            for(int i=1;i<arr.length;i++){
                for(int j=i;j>0;j--){
                    if(arr[j-1] > arr[j]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                    else break;
                }

            }
        for (int num : arr) {
            System.out.print(num+" ");
        }
        }

}
