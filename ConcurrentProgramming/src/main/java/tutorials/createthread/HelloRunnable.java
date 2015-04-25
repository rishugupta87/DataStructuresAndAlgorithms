package tutorials.createthread;

/**
 * Created by rg029761 on 10/28/15.
 */

/**
 * This employs a Runnable object, is more general, because the Runnable object can subclass a class other than Thread.
 * This lesson focuses on the first approach, which separates the Runnable task from the Thread object that executes the task. Not only is this approach more flexible,
 * but it is applicable to the high-level thread management APIs covered later.
 */
public class HelloRunnable{

    public static void main(String args[]) {
        Thread thread1 = new Thread(new Runnner());
        thread1.start();

        Thread thread2 = new Thread(new Runnner());
        thread2.start();

        Thread thread3 = new Thread(new Runnner());
        thread3.start();
    }
}

