package chapter2_linearList;

/**
 * search median between two isometric arrays
 * Time: T(n) = O(n), Space: S(n) = O(n)
 * @author SheepCore
 * @date Tuesday, March 12, 2019
 */
public class SearchMedian {
    public static void main(String[] args){
        int[] arr1 = {1, 3, 5, 7, 9, 11};
        int[] arr2 = {2, 4, 6, 8, 10, 14};
        System.out.println("median:"+searchMedian(arr1, arr2));

    }
    public static int searchMedian(int[] arr1, int[] arr2){
       int i = 0, j = 0, k = 0;
       int[] res = new int[arr1.length];
       while (i < arr1.length && j < arr2.length){
           //find the median
           if(k == arr1.length)
               return res[k - 1];
           //add numbers to result array in a descending order
           if(arr1[i] <= arr2[j])
               res[k++] = arr1[i++];
           else
               res[k++] = arr2[j++];
       }
       return res[arr1.length - 1];
    }
}
