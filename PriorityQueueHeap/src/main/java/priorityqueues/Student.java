package priorityqueues;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rg029761 on 10/12/15.
 */
public class Student {
    static Map<String, Integer>  priorityMap = new HashMap<String, Integer>();
    static {
        priorityMap.put("B3425", 4);
        priorityMap.put("A787", 5);
        priorityMap.put("D987", 3);
        priorityMap.put("E2112", 2);
        priorityMap.put("F456", 10);
    }

//    public void orderProducts(String[] productCodes) {
//
//        productCodes.le
//
//        Queue<String> queue = new PriorityQueue<String>(10, new Comparator<String>() {
//            public int compare(String product1, String product2) {
//                return priorityMap.get("").compareTo(priorityMap.get(""));
//            }
//        });
//
//        for(String productCode : productCodes) {
//            queue.add(productCode);
//        }
//
//    }
}
