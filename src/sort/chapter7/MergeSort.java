package sort.chapter7;

import static sort.chapter7.InsertSortDirectly.traverse;

/**
 * Merge sort using divide and conquer algorithm
 * divide unsorted array recursively and merge
 * @author Sheepcore
 * @date {3/21/2019}
 */
public class MergeSort {

    final static int MAX_AUX_Size = 10;
    int[] auxArray = new int[MAX_AUX_Size];

    void merge(int[] input, int low, int high){
        //1. compare with the two parts of list
        //2. merge as one list at the end.
        int mid = low + high >> 1;
        int front = low, back = mid + 1; //front part: from low to mid, back part: from mid + 1 to high
        int count = low;
        for(int i = low; i <= high; i++)
            auxArray[i] = input[i];

        while (front <= mid && back <= high){
            if(auxArray[front] < auxArray[back])
                input[count++] = auxArray[front++];
            else
                input[count++] = auxArray[back++];
        }
        while (front <= mid)
            input[count++] = auxArray[front++];

        while (back <= high)
            input[count++] = auxArray[back++];
    }

    void mergeSort(int[] input, int low, int high){
        if(low < high){
            int mid = low + high >> 1;
            mergeSort(input, low, mid);
            mergeSort(input, mid+1, high);
            merge(input, low, high);
        }
    }
    public static void main(String[] args){
       int[] arr = {5, 4, 3, 2, 1};
       MergeSort sort = new MergeSort();
       sort.mergeSort(arr, 0, arr.length-1);
       traverse(arr);
    }
}
