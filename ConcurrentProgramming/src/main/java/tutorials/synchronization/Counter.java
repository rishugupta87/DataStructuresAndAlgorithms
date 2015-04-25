package tutorials.synchronization;

/**
 * Created by rg029761 on 10/30/15.
 */
public class Counter implements Runnable{

    protected long count = 0;

    public void add(long value){
        this.count = this.count + value;
    }

    public void run() {
        add(2);
    }
}
