package sort.chapter7;

import java.util.logging.Level;

import static sort.chapter7.BubbleSort.swap;
import static sort.chapter7.InsertSortDirectly.traverse;

public class SelectSort {
    /**
     * simple select sort
     * from i = 1 to i = length - 1, select the minimum num and add it to the front part
     * @param input
     */
    void simpleSelectSort(int[] input){
        for(int i = 0; i < input.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < input.length; j++)
                if(input[j] < input[min])
                    min = j;
                if(min != i)
                    swap(input, i, min);
        }
    }

    /**
     * adjust the heap as a max-heap from bottom to the top
     *
     * @param input
     * @param root
     */
    void adjustHeap(int[] input, int root){
        //if the value of root node is larger than its children nodes' value, then break for-loop
        //else we shift the value between root and the bigger children node.
        //Then we continue to adjust its subtree till the pointer reaches the end.
        for(int lnode = 2 * root + 1; lnode < input.length; lnode = lnode * 2 + 1){
            if(input[lnode] < input[lnode+1]){
                lnode++;
            }
            if(input[root] >= input[lnode])
                break;
            swap(input, root, lnode);
            root = lnode;
        }
    }

    void buildMaxHeap(int[] input){
        for(int root = input.length >> 1 - 1; root >= 0; root--){
            adjustHeap(input, root);
        }
    }


    public static void main(String[] args){
        int[] unsortedArr = {5, 4, 3, 2, 1};
        SelectSort sort = new SelectSort();
        sort.buildMaxHeap(unsortedArr);
        traverse(unsortedArr);
    }



}
