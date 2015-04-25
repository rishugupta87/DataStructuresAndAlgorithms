package priorityqueues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rg029761 on 10/12/15.
 */
public class ClosestPoints {

    PriorityQueue<Double> pq = new PriorityQueue<Double>(5, Collections.reverseOrder());

    public static void main(String[] args) {
        Collection<Point> points = new ArrayList<Point>();
        Point origin = new Point(0, 0);
        points.add(new Point(1, 1, origin));
        points.add(new Point(1, 3, origin));
        points.add(new Point(-1, 1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(3, -1, origin));
        points.add(new Point(-1, -1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(2, 2, origin));

        Collection<Point> closestPoints = new ClosestPoints().getClosestPoints(points, 5);
        System.out.print(closestPoints);
    }

    private Collection<Point> getClosestPoints(final Collection<Point> points, final int k) {

        List<Point> pointsList = new ArrayList<Point>();

        for(Point point: points) {
            if(pq.size() >= k) {
                if(point.dist < pq.peek()) {
                    pq.poll();
                    pq.offer(point.dist);
                }
            } else {
                pq.offer(point.dist);
            }
        }
        return pointsList;
    }

    static class Point implements Comparable<Point>{
        int x, y;
        double dist;

        public Point(int x, int y, Point originPoint) {
            this.x = x;
            this.y = y;
            this.dist = Math.hypot(x - originPoint.x, y - originPoint.y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point that) {
            return Double.valueOf(that.dist).compareTo(dist);
        }
    }
}
