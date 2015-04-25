package tutorials.synchronization.tutorial1;

/**
 * Using a synchronized keyword on instance method. Only one thread per instance can access a synchronized block.
 */
public class Demo2 {

    private int counter = 0;

    private synchronized void increment() {
        counter++;
    }

    public static void main(String args[]) {
        Demo2 demo2 = new Demo2();

        Demo2 demo22 = new Demo2(); //every object in java has an intrinsic lock called as the monitor lock or mutex.
        demo2.play();
        demo22.play();
    }

    private void play() {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ; i < 10000; i++) {
                    increment();
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
