package tutorials.createthread;

/**
 * he second idiom is easier to use in simple applications, but is limited by the fact that your task class must be a descendant of Thread.
 */
public class HelloThread {

    public static void main(String args[]) {

        Runner thread1 = new Runner();
        thread1.start(); //start method runs this thread, if used run method it executes main thread

        Runner thread2 = new Runner();
        thread2.start();
    }

    static class Runner extends Thread {

        public void run() {

            for (int i = 0 ; i < 6; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
