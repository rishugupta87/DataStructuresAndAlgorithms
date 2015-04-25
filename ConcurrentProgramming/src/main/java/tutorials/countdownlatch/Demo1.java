package tutorials.countdownlatch;

/**
 * Created by rg029761 on 10/31/15.
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        latch.countDown(); // counts downs the latch counter by 1
    }
}

public class Demo1 {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3); // this is a thread safe class, can be accessed by mutiple threads.
        //lets you coutdown from 3 to 0, lets 1 or more thread to wait until the latch reaches 0.

        ExecutorService executor = Executors.newFixedThreadPool(3); //spawn three threads.

        for(int i=0; i < 3; i++) {
            executor.submit(new Processor(latch));
        }

        try {
            latch.await(); //wait till the latch has counted down to 0.
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }

}
