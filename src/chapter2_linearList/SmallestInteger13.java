package chapter2_linearList;

public class SmallestInteger13 {
    public static void main(String[] args){
        int[] arr = {-5, 1, 3, 5, 9};
        System.out.println(findSmallestPositiveInteger(arr));

    }
    public static int findSmallestPositiveInteger(int[] arr){
        int[] temp = new int[arr.length];
        //firstly traverse original array
        for(int i = 0; i < arr.length; i++)
            if(arr[i] > 0 && arr[i] <= arr.length)
                temp[arr[i]-1] = 1;

        for(int i = 0; i < temp.length; i++)
            if(temp[i] == 0)
                return i+1;
            return arr.length+1;

    }
}
