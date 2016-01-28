package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg029761 on 11/8/15.
 */
public class ArrayPermutations {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    void printArray(int []a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");

        }
        System.out.println("");
    }
    List<List<Integer>> permute(int []a, int k) {

        if(k >= a.length) {
            List<Integer> current = new ArrayList<Integer>();
            for (int num : a) {
                current.add(num);
            }
            result.add(current);
        } else {
            for (int i = k; i < a.length; i++) {

                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
                permute(a, k+1);

                //change it back
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayPermutations p=new ArrayPermutations();
        int a[]={1,2,3};
        System.out.println(p.permute(a, 0));
    }
}
