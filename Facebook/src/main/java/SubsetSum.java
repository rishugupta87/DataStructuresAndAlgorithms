/**
 * Created by rg029761 on 6/25/15.
 */
public class SubsetSum {

    /**
     * Objec­tive: Given a num­ber N, print all pos­si­ble sub­sets with Sum equal to N

     Exam­ple:

     N=4

     1111
     112
     121
     13
     211
     22
     31
     4
     * @param n
     * @param x
     */
    public static void print(int n, String x){
        if(n==0){
            System.out.println(x);
            return;
        }else{
            for(int i=1;i<=n;i++){
                x = x + i;
                print(n-i,x);
                x = x.substring(0,x.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        int n =4;
        print(n,"");

    }
}
