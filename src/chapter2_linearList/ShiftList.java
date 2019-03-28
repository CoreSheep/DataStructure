package chapter2_linearList;

import com.sun.deploy.panel.ITreeNode;

public class ShiftList {
    public static void main(String[] args){

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8}, res;
        int left = 2;
        print(shiftListLeft(input, left));

    }

    public static int[] shiftListLeft(int[] arr, int left){
        if(left < 0 || left > arr.length)
            throw new IllegalArgumentException("left: "+left);
        else if(left == 0 || left == arr.length)
            return arr;
        else {
            int[] temp = new int[arr.length >> 1];
            //shift left if the sum of numbers shifting leftward is less than the half of totals rows
            if(left < arr.length >> 1){
                //put the elements which are about to move leftward into a new array to contain temporarily
                for(int i = 0; i < left; i++)
                    temp[i] = arr[i];
                for(int i = left; i < arr.length; i++)
                    arr[i - left] = arr[i];
                for(int i = arr.length - left, j = 0; i < arr.length; i++, j++)
                    arr[i] = temp[j];
            }
            else { //left is greater than the half of the total rows
                int right = arr.length - left;
                for(int i = left; i < arr.length; i++)
                    temp[i-left] = arr[i];
                for(int i = left - 1,j = arr.length-1; i >= 0; i--, j--)
                    arr[j] = arr[i];
                for(int i = 0; i < right; i++)
                    arr[i] = temp[i];
            }
            print(temp);

        }
        return arr;
    }
    public static void print(int[] arr){
        for(int e : arr)
            System.out.print(e+"\t");
        System.out.println();
    }
}
