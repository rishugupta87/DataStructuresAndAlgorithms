package priorityqueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by rg029761 on 10/12/15.
 */
public class FinalScore {

    static Map<Integer, Double> calculateFinalScores (List<TestResult> results)
    {
        if(results == null || results.size() == 0)
            return null;

        HashMap<Integer, PriorityQueue<Integer>> id_scores = new HashMap<Integer, PriorityQueue<Integer>> ();

        for(TestResult res : results) {
            PriorityQueue<Integer> queue = null;
            if(id_scores.containsKey(res.studentId)) {
                queue = id_scores.get(res.studentId);
            } else {
                queue = new PriorityQueue<Integer>(5);
            }

            if(queue.size() >= 5) {
                if(res.testScore > queue.peek()) {
                    queue.poll();
                    queue.offer(res.testScore);
                }
            } else {
                queue.offer(res.testScore);
            }

            id_scores.put(res.studentId, queue);
        }

        Map<Integer, Double> averages = new HashMap<Integer, Double>();
        for(int key : id_scores.keySet()) {
            PriorityQueue<Integer> queue = id_scores.get(key);

            double avg = 0;
            for(int i = 0; i < 5 ; i++)
            avg += queue.poll();

            avg /= 5;

            averages.put(key, avg);
        }

        return averages;
    }

    public static void main(String[] args) {
        List<TestResult> testResults = new ArrayList<TestResult>();
        testResults.add(new TestResult(1, "02-07-2013", 60));
        testResults.add(new TestResult(1, "02-07-2013", 70));
        testResults.add(new TestResult(1, "02-07-2013", 80));
        testResults.add(new TestResult(1, "02-07-2013", 20));
        testResults.add(new TestResult(1, "02-07-2013", 30));
        testResults.add(new TestResult(1, "02-07-2013", 100));
        testResults.add(new TestResult(1, "02-07-2013", 120));

        testResults.add(new TestResult(2, "02-07-2013", 60));
        testResults.add(new TestResult(2, "02-07-2013", 65));
        testResults.add(new TestResult(2, "02-07-2013", 70));
        testResults.add(new TestResult(2, "02-07-2013", 75));
        testResults.add(new TestResult(2, "02-07-2013", 80));

        calculateFinalScores(testResults);
    }
}
