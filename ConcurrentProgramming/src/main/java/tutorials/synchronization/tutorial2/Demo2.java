package tutorials.synchronization.tutorial2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Can we decrease the time taken by using threads.
 * Lets see
 */
public class Demo2 {

    private static Random random = new Random();

    private static List<Integer> list1 = new ArrayList<Integer>();
    private static List<Integer> list2 = new ArrayList<Integer>();

    private synchronized static void stage1() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(1000));
    }

    private synchronized static void stage2() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(1000));
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

        //Now this will take twice the time but the num of elements in both the lists are 2000 which is correct.
        //why this takes time is because when we call the synchronized method, it acquires the intrinsic or monitor lock of the Demo2 object.
        //since there is just 1 lock, if 1 thread runs stage1 method it acquires the intrinsic lock, then the 2nd thread has to wait to run either stage1 or stage 2 method.
        //What is the solution ? See Demo3
        System.out.println("Time taken:" + (end - start));
        System.out.printf("List1 size:%d, List2 sie: %d", list1.size(), list2.size());
    }
}
