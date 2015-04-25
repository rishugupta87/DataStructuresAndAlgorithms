package tutorials.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Deadlock occurs for following scenario:
 *
 * Thread1:
 * lock1.lock
 * lock2.lock
 *
 * Thread2:
 * lock2.lock
 * lock1.lock
 *
 * Thread 1 acquires lock1 and thread 2 acquired lock 2. Now thread 1 tries to acquire lock2 but cannot since its acquired by thread 2 and vice versa.
 *
 * One solution is to acquire the locks in the same order
 *  Thread1:
 * lock1.lock
 * lock2.lock
 *
 * Thread2:
 * lock1.lock
 * lock2.lock
 *
 * Another solution has been proposed below. using try locks.
 *
 * Another way is to use semaphores.
 *
 */
public class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        while(true) {
            // Acquire locks

            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            }
            finally {
                if(gotFirstLock && gotSecondLock) {
                    return;
                }

                if(gotFirstLock) {
                    firstLock.unlock();
                }

                if(gotSecondLock) {
                    secondLock.unlock();
                }
            }

            // Locks not acquired
            Thread.sleep(1);
        }
    }

    public void firstThread() throws InterruptedException {

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {

            acquireLocks(lock1, lock2);

            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {

            acquireLocks(lock2, lock1);

            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: "
                + (acc1.getBalance() + acc2.getBalance()));
    }
}
