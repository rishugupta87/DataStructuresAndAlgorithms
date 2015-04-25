package tutorials.synchronization;

/**
 * Created by rg029761 on 10/30/15.
 */
public class TwoSums implements Runnable{

    private int sum1 = 0;
    private int sum2 = 0;

    public void add(int val1, int val2){
        synchronized(this){
            System.out.println("curr thread:" + Thread.currentThread().getName());
            this.sum1 += val1;
            this.sum2 += val2;
        }
        System.out.println("sum1:" + sum1);
        System.out.println("sum2:" + sum2);
    }

    public void run() {
        add(2,3);
    }
}
