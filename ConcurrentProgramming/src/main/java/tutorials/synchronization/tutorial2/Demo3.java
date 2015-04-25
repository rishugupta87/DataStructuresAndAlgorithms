package tutorials.synchronization.tutorial2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * How to solve problem introduced in Demo2.
 */
public class Demo3 {

    private static Random random = new Random();

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    private static List<Integer> list1 = new ArrayList<Integer>();
    private static List<Integer> list2 = new ArrayList<Integer>();

    private static void stage1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(1000));
        }
    }

    private static void stage2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(1000));
        }
    }

    private static void process() {
        for(int i = 0 ; i < 1000; i ++) {
            stage1();
            stage2();
        }
    }

    public static void main(String args[]) {

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        //Now time takes 2 sec and the elements in both lists are correct
        // Even if thread1 acquired lock1 to run stage1, thread2 can still acquire lock2 and run stage2.
        System.out.println("Time taken:" + (end - start));
        System.out.printf("List1 size:%d, List2 sie: %d", list1.size(), list2.size());
    }
}
