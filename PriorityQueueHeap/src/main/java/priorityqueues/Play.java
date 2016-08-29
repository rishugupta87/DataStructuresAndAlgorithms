package priorityqueues;

import java.util.*;

/**
 * Created by rg029761 on 10/25/15.
 */
public class Play {

    static Map<String, Integer>  priorityMap = new HashMap<String, Integer>();
    static {
        priorityMap.put("B3425", 4);
        priorityMap.put("A787", 5);
        priorityMap.put("D987", 3);
        priorityMap.put("E2112", 2);
        priorityMap.put("F456", 10);
        priorityMap.put("f456", 1);
    }

    //https://www.youtube.com/watch?v=1mm1I40cniQ
    //The elements of the priority queue are ordered according to their natural ordering, or by a Comparator
    // provided at queue construction time, depending on which constructor is used.
    //by default min element has highest priority. implemented using min heap
    public static void play1(int[] array) {
        Queue<Integer> queue = new PriorityQueue<Integer>(); //creates a min heap
        for(int num : array) {
            queue.add(num); //this created a min heap
        }
        System.out.println(queue);
    }

    public static void play2(int[] array) {
        Queue<Integer> queue = new PriorityQueue<Integer>(); //creates a min heap
        for(int num : array) {
            queue.add(num); //this created a min heap
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); //retrieves and removes elements based on priorities, also heapifies and fixes heap property
        }

        System.out.println("now queue" + queue); //now its empty
    }

    //http://stackoverflow.com/questions/683041/java-how-do-i-use-a-priorityqueue
    //http://stackoverflow.com/questions/13346551/sorting-priorityqueue
    public static void play3(List<Product> products) {

    //check for empty too

    if(products.size() == 1) {
        System.out.println(products.get(0));
    }

    Queue<Product> queue = new PriorityQueue<Product>(products.size(), new Comparator<Product>() {
            public int compare(Product product1, Product product2) {
                return priorityMap.get(product1.getProductName()).compareTo(priorityMap.get(product2.getProductName()));
            }
        });

        for(Product product : products) {
            queue.add(product);
        }

        while (!queue.isEmpty()) { //sorted based on priorities
            System.out.println(queue.poll().toString());
        }


        //System.out.println(Arrays.asList(queue.toArray()));
    }

    //http://stackoverflow.com/questions/683041/java-how-do-i-use-a-priorityqueue
    //http://stackoverflow.com/questions/13346551/sorting-priorityqueue
    public static void play4(List<Product> products) {

        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product product1, Product product2) {
                return priorityMap.get(product1.getProductName()).compareTo(priorityMap.get(product2.getProductName()));
            }
        });

        System.out.println(Arrays.asList(products));
    }
}
