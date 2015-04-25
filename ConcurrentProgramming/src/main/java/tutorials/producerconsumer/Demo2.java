package tutorials.producerconsumer;

import java.util.Scanner;

/**
 * Wait and Notify. Note wait and notify can be only called inside synchronized block.
 */

class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) { //intrinsic lock on producer object.
            System.out.println("Producer thread running ....");
            wait();  // every object in java has this method, current thread waits(loses control of the lock unless notified.)

            //nor resume once the lock is reacquired after receiving notification.
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000); //so that the produce method kicks off first.


        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
        }
    }
}

public class Demo2 {

    public static void main(String[] args) throws InterruptedException {

        final Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
