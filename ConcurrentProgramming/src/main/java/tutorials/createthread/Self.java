package tutorials.createthread;

/**
 * Created by rg029761 on 10/29/15.
 */
public class Self {

    public static void main(String args[]) {
        Thread thread1 = new Thread(new Runnable() {
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
        });

        thread1.start();
    }
}
