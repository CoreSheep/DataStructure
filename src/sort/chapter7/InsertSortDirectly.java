package sort.chapter7;

public class InsertSortDirectly {
    public static void main(String[] args){
        int[] input = {0, 5, 4, 3, 2, 1};
        //traverse(insertSortDirectly(input));
        insertSortBinary(input);
        traverse(input);
    }

    /**
     * insert sort directly with a sentinel
     * @param input -- input array needed to be sorted
     * @return sorted input
     */
    public static int[] insertSortDirectly(int[] input){
        if(input.length == 1)
            return input;
        //1. determine
        for(int i = 2; i < input.length; i++){
            if(input[i] < input[i-1]){
                input[0] = input[i];
                int j;
                for(j = i - 1; input[0] < input[j]; j--)
                    input[j+1] = input[j];
                input[j+1] = input[0];
            }
        }
        return input;
    }

    public static void insertSort(int[] input){
        if(input.length == 1)
            return ;
        int i = 1;
        while(i <  input.length){
            if(input[i] < input[i-1]){
                int sentinel = input[i];  //store current value
                int j = i - 1;
                while(sentinel < input[j] && j >= 0){
                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = sentinel;
            }
            i++;
        }
    }

    /**
     * insert with binary-searching
     * @param input
     */
    public static void insertSortBinary(int[] input){
        for(int i = 1; i < input.length; i++){
            if(input[i] < input[i-1]){
                int sentinel = input[i];
                int low = 0, high = i - 1;
                int mid = (low + high) >> 1;
                while (low <= high){
                    if(sentinel > input[mid])
                        low = mid + 1;
                    else
                        high = mid - 1;
                    mid = (low + high) >> 1;
                }
                int j;
                for(j = i - 1; j > high; j--)
                    input[j+1] = input[j];
                input[j+1] = sentinel;
            }
        }
    }

    public static void traverse(int[] input){
        for(int elem : input)
            System.out.print("\t"+elem);
    }
}
