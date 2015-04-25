package tutorials.semaphores;

import java.util.concurrent.Semaphore;

/**
 * Semaphore sem = new Semaphore(1)
 * sem.acquire(); //decreases available permits by 1
 *
 * sem.acquire() now has to wait for this to be released, like a lock
 */
public class Connection {

    private static Connection instance = new Connection();

    private Semaphore sem = new Semaphore(10, true);//10 no of available permits.

    private int connections = 0;

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            sem.acquire(); //decreases no of available permits by 1
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            doConnect();
        } finally {

            sem.release(); //increases no of available permits bby 1
        }
    }

    public void doConnect() {

        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }

    }
}
