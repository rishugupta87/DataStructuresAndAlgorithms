package tutorials.synchronization;

/**
 * Created by rg029761 on 10/29/15.
 */
public class App {

    public static void main(String args[]) {

        Thread t1 = new Thread(new TwoSums());
        t1.start();

        Thread t2 = new Thread(new TwoSums());
        t2.start();


        Thread t3 = new Thread(new Counter());
        t2.start();


        Counter counter = new Counter();
        Thread t4 = new Thread(counter);
        t4.start();

    }
}
