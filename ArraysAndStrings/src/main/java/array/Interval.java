package array;

/**
 * Created by rg029761 on 11/7/15.
 */
public class Interval {

    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Interval() {
        start = 0;
        end = 0;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
