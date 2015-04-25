package tutorials.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * thread pool; It is a collection of threads which are re-used.
 */
class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println();

        System.out.printf("Thread %s started task %d", Thread.currentThread().getName(), id);
        System.out.println();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.printf("Thread %s completed task %d", Thread.currentThread().getName(), id);
    }

}

public class Demo1 {
    public static void main(String args[]) {

        //analogous to two workers in a factory.
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //allot 5 tasks to the workers. Each worker when it finishes a task, performs the next task.
        for(int i = 0 ; i < 5; i ++) {
            executorService.submit(new Processor(i)); //submit task
        }

        System.out.println("All tasks submitted");

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS); //wait for 1 day for workers to complete the tasks
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");
    }

}

