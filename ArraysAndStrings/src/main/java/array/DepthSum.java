package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg029761 on 11/8/15.
 */
public class DepthSum {

    public static int depthSum(List<NestedInteger> input) {
        if (null == input) {
            return 0;
        } else {
            int sum = 0;
            for (NestedInteger current : input) {
                sum += depthSumNestedInteger(current, 1);
            }
            return sum;
        }

    }

    private static int depthSumNestedInteger(NestedInteger current, int level) {
        System.out.println("current: " + current + " level: " + level);
        if (null == current) {
            return 0;
        } else {
            if (current.isInteger()) {
                return current.getInteger() * level;
            } else {
                int tempSum = 0;
                if (current.getInteger() != null) {
                    tempSum = current.getInteger() * level;
                }
                for (NestedInteger nestedCurrent : current.getList()) {
                    tempSum += depthSumNestedInteger(nestedCurrent, level + 1);
                }
                return tempSum;
            }
        }
    }

    public static void main(String[] args) {

        List<NestedInteger> list1 = new ArrayList<NestedInteger>();
        List<NestedInteger> list2 = new ArrayList<NestedInteger>();

//        NestedInteger nestedInteger1 = new MyNestedIneteger(1, list1);
//        NestedInteger nestedInteger2 = new MyNestedIneteger(4, list2);
//        NestedInteger nestedInteger3 = new MyNestedIneteger(6, null);

//        list1.add(nestedInteger2);
//        list2.add(nestedInteger3);
//
//        List<NestedInteger> input = new ArrayList<>();
//        input.add(nestedInteger1);

//        System.out.println(input);
//        System.out.println(depthSum(input));
    }

}

