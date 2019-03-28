package sort.chapter7;
import static sort.chapter7.InsertSortDirectly.insertSortDirectly;
import static sort.chapter7.InsertSortDirectly.traverse;

public class QuickSort {
    /**
     * Partition given array by pivot
     * @param input
     * @param low
     * @param high
     * @return
     */
    int partition(int[] input, int low, int high){
        int pivot = input[low];
        while (low < high){
            // partition the higher part
            while (low < high && input[high] >= pivot)
                high--;
            input[low] = input[high]; //extract the smaller elem to the left

            while (low < high && input[low] <= pivot)
                low++;
            input[high] = input[low]; //extract the bigger elem to the right
        }//if low == high, then exit.
        input[low] = pivot; //find out the final position of pivot eventually
        return low; //return the position of partition so as to quick sort recursively.
    }

    /**
     * Quick sort with partition method
     * @param input
     * @param low
     * @param high
     */
    void quickSort(int[] input, int low, int high){
        if(low < high){
            int partition = partition(input, low, high);  //1. partition
            quickSort(input, low, partition - 1);   //2. partition left part
            quickSort(input, partition + 1, high);   //3. partition right part
        }
    }

    public static void main(String[] args){
        QuickSort sort = new QuickSort();
        int[] unsortedArr = {5, 4, 3, 2, 1};
        sort.quickSort(unsortedArr, 0, unsortedArr.length - 1);
        traverse(unsortedArr);
    }
}
