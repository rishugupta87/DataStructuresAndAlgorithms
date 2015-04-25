package array;

import java.util.HashSet;
import java.util.Set;

/**
 * T(n) = 0(n)
 */
public class TwoSumProblem {

    Set<Integer> set = new HashSet<Integer>();

    public void store(int input){
        set.add(input);
    }

    public boolean test(int value) {

        for(int num : set) {
            if(set.contains(value - num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        TwoSumProblem problem = new TwoSumProblem();
        problem.store(1);
        problem.store(-2);
        problem.store(3);
        problem.store(6);

        System.out.println("test1:" + problem.test(4));
        System.out.println("test2:" + problem.test(-1));
        System.out.println("test3:" + problem.test(7));
        System.out.println("test4:" + problem.test(1));
        System.out.println("test5:" + problem.test(10));
    }
}
