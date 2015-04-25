package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg029761 on 11/7/15.
 */
public class OverlappingIntervalsTest {

    @Test
    public void test1() {
        Interval interval1 = new Interval(-2, 3);
        Interval interval2 = new Interval(1, 4);
        Interval interval3 = new Interval(2, 5);
        Interval interval4 = new Interval(4, 6);
        Interval interval5 = new Interval(6, 8);
        Interval interval6 = new Interval(10, 12);

        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        list.add(interval5);
        list.add(interval6);

        ArrayList<Interval> merged = OverlappingIntervals.merge(list);
        for(Interval interval : merged) {
            System.out.printf("(%d, %d)", interval.getStart(), interval.getEnd());
            System.out.println();
        }

        System.out.println("coverage:" + OverlappingIntervals.findCoverage(merged));

    }
}
