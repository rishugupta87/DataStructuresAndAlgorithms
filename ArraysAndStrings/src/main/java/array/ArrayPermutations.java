package array;

/**
 * Created by rg029761 on 11/8/15.
 */
public class ArrayPermutations {

    void printArray(int []a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");

        }
        System.out.println("");
    }
    void permute(int []a, int k) {
        if(k==a.length) {
            printArray(a);
        } else {
            for (int i = k; i < a.length; i++) {

                int temp=a[k];
                a[k]=a[i];
                a[i]=temp;
                permute(a,k+1);

                //change it back
                temp=a[k];
                a[k]=a[i];
                a[i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        ArrayPermutations p=new ArrayPermutations();
        int a[]={1,2,3};
        p.permute(a, 0);
    }
}
