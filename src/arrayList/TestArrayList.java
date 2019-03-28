package arrayList;

import abstractList.AbstractList;

public class TestArrayList {
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        for( int i = 0; i < 5; i++) {
            list.add(i<<1);
            //System.out.print("size: " + ((ArrayList) list).size());
        }
        int[] arr = {1, 3, 5, 7, 9, 10, 11, 12, 13, 1111};
        int[] res;
        res = list.merge(arr);

        for(int e : res)
            System.out.print(e+"\t");
        list.traverse();


    }
}
