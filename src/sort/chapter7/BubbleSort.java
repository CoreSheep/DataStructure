package sort.chapter7;

import static sort.chapter7.InsertSortDirectly.traverse;

public class BubbleSort {
    public static void main(String[] args){
        int[] input = {1, 2, 3, 4, 5};
        bubbleSort(input);
        traverse(input);

    }

    public static void bubbleSort(int[] input){
        boolean sortfinished = true;
        for(int i = 0; i < input.length - 1; i++){
            for(int j = input.length - 1; j > i; j--){

                if(input[j] < input[j-1]) {
                    sortfinished = false;
                    swap(input, j, j - 1);
                }
            }
            if(sortfinished)
                return;
        }
    }

    public static void swap(int[] Input, int i, int j){
        int temp = Input[i];
        Input[i] = Input[j];
        Input[j] = temp;
    }
}
