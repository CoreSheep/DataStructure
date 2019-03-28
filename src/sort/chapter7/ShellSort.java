package sort.chapter7;


/**
 * insert sort
 * shell sort with increment
 */
public class ShellSort {
    public static void shellSort(int[] input){
        int dec = input.length >> 1;
        while (dec >= 1){
            //insert sort directly
            for(int i = dec; i < input.length; i++){
                if(input[i] < input[i-dec]){
                    int sentinel = input[i];
                    int j;
                    for(j = i - dec; j >= 0 && sentinel < input[j]; j-=dec)
                        input[j+dec] = input[j];
                    input[j+dec] = sentinel;
                }
            }
            dec = dec >> 1;
        }
    }

    public static void main(String[] args){
        int[] input = {5, 4, 3, 2, 1, 0};
        shellSort(input);
        InsertSortDirectly.traverse(input);
    }
}
