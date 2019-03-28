package arrayList;

import abstractList.AbstractList;
import java.util.Arrays;


public class  ArrayList extends AbstractList {
    private transient int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    ArrayList(int capacity){
        if(capacity < 0)
            throw new IllegalArgumentException();
        data = new int[capacity];
        size = 0;

    }

    private void ensureCapacity(int minCapacity){
        int current = data.length;

        if(minCapacity > current){
            int[] newdata = new int[current << 1];
            System.arraycopy(data, 0, newdata, 0, size);
            data = newdata;

        }
    }

    /**
     * using for checking index while getElem or indexOf
     * index < size
     * @param index
     * @return
     */
    private boolean checkBoundExclusive(int index){
        return index < size;
    }

    /**
     * using for checking index while add element
     * @param index
     * @return
     */
    private boolean checkBoundInclusive(int index){
        return index <= size;
    }

    public void add(int element){
        if(data.length == size)
            ensureCapacity(size + 1);
        data[size++] = element;
    }

    /**
     * add an element to specific location
     * @param index -- start from 0 to size
     * @param e
     */
    public void add(int index, int e){
        if(data.length == size)
            ensureCapacity(size + 1);
        if(index != size){
            for(int i = size; i > index; i--)
                data[i] = data[i-1];
            data[index] = e;
        }
        else
            data[size] = e;
        size++;
    }

    public int get(int index){
        if(checkBoundExclusive(index))
            return data[index];
        else
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }
    public int indexOf(int e){
        for(int i = 0; i < size; i++)
            if(data[i] == e)
                return i;

         return -1;

    }
    public int remove(int index){
        if(checkBoundExclusive(index)){
            int removeElement = data[index];
            for(int i = index; i < size; i++)
                data[i] = data[i+1];
            size--;
            return removeElement;
        }
        else
            throw new IllegalArgumentException();

    }


    /**
     * remove the minimum element and replace by the last element.
     * 综合题2.1 p18
     *
     */
    public int removeMin(){
        if(size == 0)
            return -1;
        int min = data[0];
        int i = 1, minLoc = 0;
        while(i++ < size){
            if(min > data[i]) {
                min = data[i];
                minLoc = i;
            }
        }
            data[minLoc] = data[size--];
            return min;
    }

    public void removeAllInplace(int e){
        int i = 0, k = 0; //i is a pointer, k is num of nonElement
        while(i < size){
            if(data[i] != e)
                data[k++] = data[i++]; //move forward
            else
                i++;
        }
        size = size - k;
    }

    /**
     * remove duplicated elements
     */
    public void removeSameElem(){
        int i = 1, k = 0;
        while(i < size) {
            if (data[k] != data[i])
                data[++k] = data[i++];
            else
                i++;
        }
        size -= k;

    }
    public void traverse(){
        System.out.print("[");
        for(int i = 0; i < size - 1; i++)
            System.out.print(data[i]+",");
        System.out.print(data[size-1]+"]\n");

    }
    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }
    public void clear(){
        if(size > 0){
            for(int e : data)
                e = 0;
            size = 0;
        }
    }
    private void swap(int[] arr, int e1, int e2){
        int temp;
        temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }

    public void reverse(){
        int i = 0, j = size - 1;
        while(i < j)
            swap(data, data[i++], data[j--]);
    }

    public int[] merge(int[] sortedArr){
        int l1 = size, l2 = sortedArr.length;
        int[] mergedRes = new int[l1+l2];
        int i = 0, j = 0, k = 0;
        while(i < l1 && j < l2){
            if(data[i] < sortedArr[j])
                mergedRes[k++] = data[i++];
            else
                mergedRes[k++] = sortedArr[j++];
        }

        while(i < l1)
            mergedRes[k++] = data[i++];

        while(j < l2)
            mergedRes[k++] = sortedArr[j++];
        return mergedRes;
    }
}
