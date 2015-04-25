package array;

import java.util.List;

/**
 * Created by rg029761 on 11/7/15.
 */

public class IntervalCoverage {

    public static int distance(final List<Interval> intervals) {

        Interval previousInterval = intervals.get(0);
        Interval mergedInterval = new Interval();

        int distance = 0;

        int i = 1;
        while(i < intervals.size()) {
            Interval currentInterval = intervals.get(i);

            //check if the currentInterval overlaps with the previous interval
            if(currentInterval.start < previousInterval.end) {

                //merge the intervals, update the previous interval
                mergedInterval.setStart(previousInterval.start);
                mergedInterval.setEnd(Math.min(previousInterval.end, currentInterval.end));
            } else {
                distance += previousInterval.end;
            }

            previousInterval = currentInterval;
        }

        return 0;
    }
}
