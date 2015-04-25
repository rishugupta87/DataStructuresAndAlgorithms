package tutorials.interrupt;

/**
 * An interrupt is an indication to a thread that it should stop what it is doing and do something else. It's up to the programmer to decide
 * exactly how a thread responds to an interrupt, but it is very common for the thread to terminate
 */
public class Interrupts {

    public static void main(String args[]) throws InterruptedException {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            // Pause for 4 seconds
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                // We've been interrupted: no more messages.
                return;
            }
            // Print a message
            System.out.println(importantInfo[i]);
        }

    }
}
