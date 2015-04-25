package tutorials.synchronization.tutorial1;

/**
 * Demonstrates executing 2 threads which try to modify the value of count.
 * this is not synchronized so the counter value will be incorrect.
 * Need to synchronize this. See Demo2
 */
public class Demo1 {

    private int counter = 0;

    public static void main(String args[]) {
        Demo1 demo1 = new Demo1();
        demo1.play();
    }

    private void play() {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ; i < 10000; i++) {
                    counter++; // this is actually count = count + 1 , 3 operations
                               // read count from memory, then add 1 to it, store back in memory
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ; i < 10000; i++) {
                    counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //wait for threads to finish and then calculate counter
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count is:" + counter);
    }
}
