package tutorials.synchronization.tutorial2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Demonstrate the problem of using intrinsic locks
 * Demo1 without using any threads takes about 2 seconds to add numbers to both list
 * both the lists have correct num of elements
 */
public class Demo1 {

    private static Random random = new Random();

    private static List<Integer> list1 = new ArrayList<Integer>();
    private static List<Integer> list2 = new ArrayList<Integer>();

    private static void stage1() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(1000));
    }

    private static void stage2() {
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
        process();
        long end = System.currentTimeMillis();

        System.out.println("Time taken:" + (end - start));
        System.out.printf("List1 size:%d, List2 sie: %d", list1.size(), list2.size());
    }
}
